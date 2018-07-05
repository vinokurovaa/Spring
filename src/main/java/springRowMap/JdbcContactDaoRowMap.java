package springRowMap;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JdbcContactDaoRowMap implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if(jdbcTemplate == null){
            throw new BeanCreationException("Null JdbcTemplate on ContactDao");
        }
    }

    public List<Contact> findAll() {
        String sql = "select id, first_name, last_name, birth_date from contact";
        return jdbcTemplate.query(sql, new ContactMapper());
    }

    public String findFirstNameById(Long id) {
        Map<String, Object> namedParams = new HashMap<String, Object>();
        namedParams.put("contactId", id);
        return jdbcTemplate.queryForObject("select first_name from contact where id = :contactId", namedParams, String.class);
    }
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    private static class ContactMapper implements RowMapper<Contact>{

        @Nullable
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));

            return contact;
        }
    }
}
