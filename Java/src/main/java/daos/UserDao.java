package daos;

import entities.User;

import java.util.List;

public interface UserDao {

    public User createUser(User u);

    public User readUser(int id) ;

    public List<User> readAllUsers() ;

    public User updateUser(User change) ;

    public User deleteUser(int id);

    public User loginUser(String username, String password);
}

