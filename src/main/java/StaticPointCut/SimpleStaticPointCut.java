package StaticPointCut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;


public class SimpleStaticPointCut extends StaticMethodMatcherPointcut {
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        return "foo".equals(method.getName());
    }
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return clazz == BeanOne.class;
            }
        };
    }
}
