package springJdbsEmbendded;


import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcTemplateExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/Spring/springJDBC.xml");
        context.refresh();

      //  ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        ContactDao contactDao = context.getBean("NamedParamsContactDao", ContactDao.class);

        System.out.println(contactDao.findFirstNameById(1l));
    }
}
