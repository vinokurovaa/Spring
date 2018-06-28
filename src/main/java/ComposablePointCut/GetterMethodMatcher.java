package ComposablePointCut;

import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;


public class GetterMethodMatcher extends StaticMethodMatcher {
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        return method.getName().startsWith("get");
    }
}
