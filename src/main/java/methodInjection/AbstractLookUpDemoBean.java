package methodInjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;


@Component("abstractLookupBean")
public abstract class AbstractLookUpDemoBean implements DemoBean {

    @Lookup()
    public abstract MyHelper getMyHelper();

    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
