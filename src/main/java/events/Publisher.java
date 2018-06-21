package events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("publisher")
public class Publisher implements ApplicationContextAware {
    private ApplicationContext ctx;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
    public void publish(String message){
        ctx.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring/app-context-event.xml");
        Publisher publisher = (Publisher) ctx.getBean("publisher");
        publisher.publish("Hello World!");
        publisher.publish("The quick brown fox j umped over the lazy dog");
    }
}
