package messagesource;


import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/app-context-messageSource.xml");
        ctx.refresh();

        Locale eng = Locale.ENGLISH;
        Locale czh = new Locale("cs", "CZ");

        System.out.println(ctx.getMessage("msg", null, eng));
        System.out.println(ctx.getMessage("msg", null, czh));
    }
}
