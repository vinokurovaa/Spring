package aop;


import org.springframework.aop.framework.ProxyFactory;

public class AOPBeforeExample {
    public static void main(String[] args) {
        MessageWriter messageWriter = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(messageWriter);

        MessageWriter proxy = (MessageWriter) pf.getProxy();

        proxy.writeMessage();
    }
}
