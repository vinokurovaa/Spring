package hibernate;


import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/spring-jdbc-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
       // System.out.println(Arrays.toString(contactDao.findAll().toArray()));
        List<Contact> all = contactDao.findAllWithDetail();

        for(Contact contact : all){
            System.out.println(contact.toString());
            if(contact.getContactTelDetails() != null){
                for(ContactTelDetail contactTelDetail : contact.getContactTelDetails()){
                    System.out.println(contactTelDetail.toString());
                }
            }
            if(contact.getHobbies() != null){
                for(Hobby hobby : contact.getHobbies()){
                    System.out.println(hobby.toString());
                }
            }
        }
    }
}
