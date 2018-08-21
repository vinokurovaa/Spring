package springDataJpa;


import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class exampleSpringDataJpa {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/spring-data-jpa.xml");
        ctx.refresh();

        /*ContactService contactService = ctx.getBean("ContactService", ContactService.class);

        listContacts("find All = ", contactService.findAll());
        listContacts("find by fist Name = ", contactService.findByFirstName("Chris"));*/

        ContactAuditService contactService = ctx.getBean(
                "contactAuditService", ContactAuditService.class);

        List<ContactAudit> contacts = contactService.findAll();
        listContacts(contacts);

        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);

        contact = contactService.findById(1l);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");

        System.out.println("Update contact");
        contact.setFirstName("Tom");
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);


    }

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println("");
        for (ContactAudit contact: contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
