package springJdbcAnnotation;


import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class SpringJdbcAnnotationExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/Spring/spring-jdbc-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> all = contactDao.findAll();

        System.out.println(Arrays.toString(all.toArray()));

        List<Contact> allByFirstName = contactDao.findByFirstName("Chris");

        System.out.println(Arrays.toString(allByFirstName.toArray()));

    }
}
