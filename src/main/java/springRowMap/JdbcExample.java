package springRowMap;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;


public class JdbcExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/Spring/springJDBC.xml");
        context.refresh();

        //  ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        springRowMap.ContactDao contactDao = context.getBean("NamedParamsContactDaoRowMap", springRowMap.ContactDao.class);

        System.out.println(Arrays.toString(contactDao.findAll().toArray()));
    }
}
