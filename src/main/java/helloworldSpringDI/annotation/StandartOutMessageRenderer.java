package helloworldSpringDI.annotation;

import helloworldSpringDI.MessageProvider;
import helloworldSpringDI.MessageRenderer;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandartOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set property messageProvide of class" + StandartOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
