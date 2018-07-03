package modification;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;


public class isModifiedAdvisor extends DefaultIntroductionAdvisor {
    public isModifiedAdvisor() {
        super(new isModifiedMixin());
    }
}
