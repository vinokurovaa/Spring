package springJdbcAnnotation;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class SelectContactByFirstName extends MappingSqlQuery<Contact> {
    private static final String GET_ALL_CONTACTS = "SELECT id, first_name, last_name, birth_date FROM contact WHERE first_name = :first_name";

    public SelectContactByFirstName(DataSource dataSource){
        super(dataSource, GET_ALL_CONTACTS);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
    }
    @Nullable
    @Override
    protected Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setBirthDate(resultSet.getDate("birth_date"));
        return contact;
    }
}
