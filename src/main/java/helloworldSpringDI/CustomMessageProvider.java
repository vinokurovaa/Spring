package helloworldSpringDI;

/**
 * Created by anvi0616 on 6/19/2018.
 */
public class CustomMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Custom message";
    }
}
