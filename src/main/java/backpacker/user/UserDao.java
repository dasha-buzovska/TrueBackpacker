package backpacker.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 19.09.2018
 */
@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(User user) {
        return 0;
    }

    public void update(User user) {

    }

    public void delete(int id) {

    }

    public User getById() {
        return new User();
    }

    public List<User> getAll() {
        return null;
    }

}
