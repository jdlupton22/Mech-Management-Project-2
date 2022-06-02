package daos;

import entities.Mech;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MechDaoImpl implements MechDao {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Mech createMech(Mech m) {

        String sql = "INSERT INTO mechs VALUES (Default,?,?,?,?,?,?,?,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, m.getMake());
            ps.setString(2, m.getModel());
            ps.setString(3, m.getYear());
            ps.setString(4, m.getColor());
            ps.setDouble(5, m.getMaxSpeed());
            ps.setDouble(6, m.getWeight());
            ps.setDouble(7, m.getHeight());
            ps.setString(8, m.getDescription());
            ps.setInt(9, m.getPilotCount());
            ps.setBoolean(10, m.getAvailable());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildMech(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Mech readMech(int id) {
        String sql = "SELECT * FROM mech WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildMech(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Mech> readAllMechs() {

        String sql = "SELECT * FROM mech";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Mech> mechs = new ArrayList<>();

            while (rs.next()) {
                mechs.add(buildMech(rs));
            }
            return mechs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Mech updateMech(Mech change) {
        try {
            String sql = "UPDATE mech SET make=?, model=?, year=?, color=?, max_speed=?, weight=?, height=?," +
                    " description=?, pilot_count=?, available=? WHERE id=? RETURNING *";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getMake());
            ps.setString(2, change.getModel());
            ps.setString(3, change.getYear());
            ps.setString(4, change.getColor());
            ps.setDouble(5, change.getMaxSpeed());
            ps.setDouble(6, change.getWeight());
            ps.setDouble(7, change.getHeight());
            ps.setString(8, change.getDescription());
            ps.setInt(9, change.getPilotCount());
            ps.setBoolean(10, change.getAvailable());
            ps.setInt(11, change.getId());


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildMech(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Mech deleteMech(int id) {
         try {
              String sql = "DELETE FROM mech WHERE id = ? RETURNING *";
              PreparedStatement ps = conn.prepareStatement(sql);

              ps.setInt(1, id);
              ResultSet rs = ps.executeQuery();

              if (rs.next()) {
                  return buildMech(rs);
              }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

    private Mech buildMech(ResultSet rs) throws SQLException {
         Mech m = new Mech();
         m.setMechId(rs.getInt("id"));
         m.setMake(rs.getString("make"));
         m.setModel(rs.getString("model"));
         m.setYear(rs.getString("year"));
         m.setColor(rs.getString("color"));
         m.setMaxSpeed(rs.getDouble("max_speed"));
         m.setWeight(rs.getDouble("weight"));
         m.setHeight(rs.getDouble("height"));
         m.setDescription(rs.getString("description"));
         m.setPilotCount(rs.getInt("pilot_count"));
         m.setAvailable(rs.getBoolean("available"));

         return m;
        }
    }




