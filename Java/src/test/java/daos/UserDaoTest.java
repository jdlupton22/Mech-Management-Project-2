package daos;

import entities.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {
    UserDao ud = new UserDaoImpl();

    @Test
    public void readUser() {

        int id = 1;
        User actual = ud.readUser(id);
        User expected = new User(1, "tsnark","password",  "Tommy", "Snark",
                true, true);

        assertEquals(expected, actual);

    }
}
