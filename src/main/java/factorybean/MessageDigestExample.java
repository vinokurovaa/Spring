package factorybean;


import factorybean.annotation.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/app-context-factorybean-annotation.xml");
        ctx.refresh();

        MessageDigester messageDigester = (MessageDigester) ctx.getBean("digester");
        messageDigester.digest("Hello Anton!");
    }
}
