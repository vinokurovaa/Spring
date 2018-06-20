package methodInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("standardLookupBean")
public class StandartLookUpDemoBean implements DemoBean {
    @Autowired
    private MyHelper myHelper;
    public void setMyHelper(MyHelper myHelper){
        this.myHelper = myHelper;
    }
    public MyHelper getMyHelper() {
        return this.myHelper;
    }

    public void someOperation() {
        this.myHelper.doSomethingHelpful();
    }
}
