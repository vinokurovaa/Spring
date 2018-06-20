package replacementMethod;


import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/app-context-replacement.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget1 = ctx.getBean("replacementTarget", ReplacementTarget.class);
        ReplacementTarget replacementTarget2 = ctx.getBean("standardTarget", ReplacementTarget.class);

        displayInfo(replacementTarget1);
        displayInfo(replacementTarget2);
    }
    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x < 1000000; x++) {
            String out = target.formatMessage("foo");
        }

        stopWatch.stop();

        System.out.println("1000000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
