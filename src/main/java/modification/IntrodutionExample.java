package modification;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by anvi0616 on 6/28/2018.
 */
public class IntrodutionExample {
    public static void main(String[] args) {
        TargetBean target = new TargetBean();
        target.setName("Chris Schaefer");

        IntroductionAdvisor advisor = new isModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        TargetBean proxy = (TargetBean) pf.getProxy();
        isModified proxyInterface = (isModified) proxy;

        System.out.println("Is TargetBean?: " + (proxy instanceof TargetBean));
        System.out.println("Is IsModified?: " + (proxy instanceof isModified));

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Chris Schaefer1");

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Clarence Ho");

        System.out.println("Has been modified?: " + proxyInterface.isModified());
    }
}
