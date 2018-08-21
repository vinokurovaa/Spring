package jpa;


import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class exampleJPA {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/persistent.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
        List<Contact> all = contactService.findAll();

        for(Contact contact : all){
            System.out.println(contact.toString());
        }
    }
}
