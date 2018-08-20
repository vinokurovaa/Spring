package springRowMap;


import java.util.List;

public interface ContactDao {
    List<Contact> findAll();
    String findFirstNameById(Long id);
    List<Contact> findAllLyamda();
}
