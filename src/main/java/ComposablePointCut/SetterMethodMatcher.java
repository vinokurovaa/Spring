package ComposablePointCut;

import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * Created by anvi0616 on 6/28/2018.
 */
public class SetterMethodMatcher extends StaticMethodMatcher {
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        return method.getName().startsWith("set");
    }
}
