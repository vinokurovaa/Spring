package springJdbsEmbendded;


import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcContactDAO implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if(jdbcTemplate == null){
            throw new BeanCreationException("Null JdbcTemplate on ContactDao");
        }
    }

    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject("select first_name from contact where id = ?", new Object[] {id}, String.class);
    }
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;

        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        MySQLErrorCodesTranslator sqlErrorCodesTranslator = new MySQLErrorCodesTranslator();

        sqlErrorCodesTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(sqlErrorCodesTranslator);
    }

}
