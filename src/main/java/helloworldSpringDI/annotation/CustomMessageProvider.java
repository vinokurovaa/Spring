package helloworldSpringDI.annotation;


import helloworldSpringDI.MessageProvider;
import org.springframework.stereotype.Service;

@Service("provider")
public class CustomMessageProvider implements MessageProvider{
    public String getMessage() {
        return "Custom Message";
    }
}
