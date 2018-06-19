package helloworldSpringDI;

import helloworldSpringDI.MessageProvider;

/**
 * Created by anvi0616 on 6/19/2018.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
