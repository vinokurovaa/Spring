package jdbc;

import java.util.List;

/**
 * Created by anvi0616 on 7/2/2018.
 */
public class example {
    private static ContactDAO contactDao = new PlainContactDAO();

    private static void listAllContacts() {
        List<Contact> contacts = contactDao.findByFirstName("Chris");

        for (Contact contact : contacts) {
            System.out.println(contact);
          //  contact.setFirstName("Anton");
         //   contactDao.update(contact);
        }
    }

    public static void main(String[] args) {
        System.out.println("Listing initial contact data:");

        listAllContacts();
    }

}
