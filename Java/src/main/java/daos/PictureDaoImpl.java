package daos;

import entities.Picture;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PictureDaoImpl implements PictureDao{

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Picture createPicture(Picture p) {
        String sql = "INSERT INTO picture VALUES (DEFAULT,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, p.getMechId());
            ps.setByte(2, p.getFile());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPicture(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Picture readPicture(int id) {

        String sql = "SELECT * FROM picture WHERE id = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPicture(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Picture> readAllPictures() {
        String sql = "SELECT * FROM picture";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Picture> pictures = new ArrayList<>();

            while(rs.next()) {
                pictures.add(buildPicture(rs));
            }

            return pictures;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Picture updatePicture(Picture change) {
        String sql = "UPDATE picture SET mech_id=?, file=? WHERE id=? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, change.getMechId());
            ps.setByte(2, change.getFile());
            ps.setInt(3, change.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPicture(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Picture deletePicture(int id) {
        try {
            String sql = "DELETE FROM picture WHERE id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPicture(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private Picture buildPicture(ResultSet rs) throws SQLException {
        Picture p = new Picture();
        p.setId(rs.getInt("id"));
        p.setMechId(rs.getInt("mech_id"));
        p.setFile(rs.getByte("file"));

        return p;
    }
}
