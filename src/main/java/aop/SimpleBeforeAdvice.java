package aop;


import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("before method = " + method.getName());
    }
}
