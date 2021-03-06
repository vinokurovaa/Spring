package springJdbcAnnotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private Log log = LogFactory.getLog(JdbcContactDao.class);

    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstName;

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        selectAllContacts = new SelectAllContacts(dataSource);
        selectContactByFirstName = new SelectContactByFirstName(dataSource);
    }
    public DataSource getDataSource(){
        return dataSource;
    }
    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> namedParams = new HashMap<String, Object>();
        namedParams.put("first_name", firstName);
        return selectContactByFirstName.executeByNamedParam(namedParams);
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void insertWithDetail(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }
}
