package StaticPointCut;


import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPoiuntCutExample {
    public static void main(String[] args) {
        BeanOne beanOne = new BeanOne();
        BeanTwo beanTwo = new BeanTwo();

        Pointcut pc = new SimpleStaticPointCut();
        Advice ad = new SimpleAdvice();

        Advisor advisor = new DefaultPointcutAdvisor(pc,ad);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(beanOne);

        BeanOne proxyBeanOne = (BeanOne) pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(beanTwo);

        BeanTwo proxyBeanTwo = (BeanTwo) pf.getProxy();

        proxyBeanOne.foo();
        proxyBeanTwo.foo();
    }
}
