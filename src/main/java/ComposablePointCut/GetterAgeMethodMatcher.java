package ComposablePointCut;


import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class GetterAgeMethodMatcher extends StaticMethodMatcher {
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        return "getAge".equals(method.getName());
    }
}
