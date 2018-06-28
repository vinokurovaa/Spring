package ComposablePointCut;


import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ComposablePointCutExample {

    public static void main(String[] args) {
        SimpleBean sb = new SimpleBean();
        ComposablePointcut composablePointcut = new ComposablePointcut(ClassFilter.TRUE, new GetterMethodMatcher());

        //test1
        System.out.println("test1");
        SimpleBean proxy = getProxy(composablePointcut, sb);
        testInvoke(proxy);

        //test2
        System.out.println("test2");
        composablePointcut.union(new SetterMethodMatcher());
        proxy = getProxy(composablePointcut, sb);
        testInvoke(proxy);


        //test3
        System.out.println("test3");
        composablePointcut.intersection(new GetterAgeMethodMatcher());
        proxy = getProxy(composablePointcut, sb);
        testInvoke(proxy);
    }

    private static SimpleBean getProxy(ComposablePointcut pc, SimpleBean target){
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        return (SimpleBean) pf.getProxy();
    }
    private static void testInvoke(SimpleBean proxy){
        proxy.getName();
        proxy.getAge();
        proxy.setName("fdfdf");
    }
}
