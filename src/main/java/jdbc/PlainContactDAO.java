package jdbc;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainContactDAO implements ContactDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlainContactDAO.class);
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC", "root", "CSKAmoscow2111");
    }
    private void closeConnection(Connection connection){
        if(connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<Contact>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate("birth_date"));

                result.add(contact);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    public List<Contact> findByFirstName(String firstName) {
        List<Contact> result = new ArrayList<Contact>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Contact where first_name = ?");
            ps.setString(1, firstName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Contact contact = new Contact();
                contact.setId(rs.getLong("id"));
                contact.setFirstName(rs.getString("first_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setBirthDate(rs.getDate("birth_date"));
                result.add(contact);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return result;
    }

    public String findLastNameById(Long id) {
        Connection connection = null;
        String lastName = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT last_name FROM Contact WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lastName = rs.getString("last_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return lastName;
    }

    public String findFirstNameById(Long id) {
        Connection connection = null;
        String firstName = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT first_name FROM Contact WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                firstName = rs.getString("first_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return firstName;
    }

    public void insert(Contact contact) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into contact (first_name, last_name, birth_date) values (?, ?, ?)");
            ps.setString(1, contact.getFirstName());
            ps.setString(2, contact.getLastName());
            ps.setDate(3, contact.getBirthDate());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Contact contact) {
        Connection connection = null;
        try {
            if(contact != null) {
                connection = getConnection();
                PreparedStatement ps = connection.prepareStatement("update contact set first_name = ?, last_name = ?, birth_date = ? where id = ?");
                ps.setString(1, contact.getFirstName());
                ps.setString(2, contact.getLastName());
                ps.setDate(3, contact.getBirthDate());
                ps.setLong(4, contact.getId());
                ps.execute();
            }else{
                LOGGER.error("update: contact is null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Long contactId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from contact where id = ?");
            ps.setLong(1,contactId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
