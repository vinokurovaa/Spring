package events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component("messageEventListener")
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent mv = (MessageEvent) messageEvent;
        System.out.println("Recieved msg = " + mv.getMessage());

    }
}
