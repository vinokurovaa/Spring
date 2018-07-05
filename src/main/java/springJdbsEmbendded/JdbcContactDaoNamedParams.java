package springJdbsEmbendded;


import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcContactDaoNamedParams implements ContactDao, InitializingBean {
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

    public String findFirstNameById(Long id) {
        Map<String, Object> namedParams = new HashMap<String, Object>();
        namedParams.put("contactId", id);
        return jdbcTemplate.queryForObject("select first_name from contact where id = :contactId", namedParams, String.class);
    }
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}
