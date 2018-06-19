package helloworldSpringDI;

/**
 * Created by anvi0616 on 6/19/2018.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello World";
    }
}
