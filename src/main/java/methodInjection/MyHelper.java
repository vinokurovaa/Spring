package methodInjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("helper")
@Scope("prototype")
public class MyHelper {
    public void doSomethingHelpful(){

    }
}
