package helloworldSpringDI;


import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringConponent {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/app-context-annotation.xml");
        ctx.refresh();
        MessageProvider mp = ctx.getBean("provider", MessageProvider.class);
        System.out.println(mp.getMessage());
    }
}
