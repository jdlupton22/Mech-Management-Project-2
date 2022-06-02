package daos;

import entities.User;
import util.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public User createUser(User u) {
        String sql = "INSERT INTO users VALUES (Default,?,?,?,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getFirstname());
            ps.setString(4, u.getLastname());
            ps.setBoolean(5, u.getIsPilot());
            ps.setBoolean(5, u.getIsAdmin());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User readUser(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> readAllUsers() {
        String sql = "SELECT * FROM users";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<User> users = new ArrayList<>();

            while(rs.next()) {
                users.add(buildUser(rs));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User updateUser(User change) {
        try {
            String sql = "UPDATE users SET username=?, password=?, firstname=?, lastname=?," +
                    " isPilot=?, isAdmin=? WHERE id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getUsername());
            ps.setString(2, change.getPassword());
            ps.setString(3, change.getFirstname());
            ps.setString(4, change.getLastname());
            ps.setBoolean(5, change.getIsPilot());
            ps.setBoolean(5, change.getIsAdmin());
            ps.setInt(7, change.getId());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildUser(rs);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User deleteUser(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User loginUser(String username, String password) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private User buildUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setFirstname(rs.getString("firstname"));
        u.setLastname(rs.getString("lastname"));
        u.setIsPilot(rs.getBoolean("isPilot"));
        u.setIsPilot(rs.getBoolean("isAdmin"));

        return u;
    }
}
