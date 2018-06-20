package methodInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by anvi0616 on 6/20/2018.
 */
public class LookUpDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/app-context-demobean.xml");
        ctx.refresh();

        DemoBean abstractBean = (DemoBean)ctx.getBean("abstractLookupBean");
        DemoBean standartBean = (DemoBean)ctx.getBean("standardLookupBean");
        displayInfo(abstractBean);
        displayInfo(standartBean);
    }
    public static void displayInfo(DemoBean bean){
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println(bean.getClass().getName());

        System.out.println("Helper Instances the Same?: " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookup");


        for (int x = 0; x < 100000; x++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
