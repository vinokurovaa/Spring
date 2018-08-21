package springDataJpa;


import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class exampleSpringDataJpa {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/spring-data-jpa.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("ContactService", ContactService.class);

        listContacts("find All = ", contactService.findAll());
        listContacts("find by fist Name = ", contactService.findByFirstName("Chris"));


    }

    private static void listContacts(String message, List<Contact> contacts) {
        System.out.println("");
        System.out.println(message);
        for (Contact contact: contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
