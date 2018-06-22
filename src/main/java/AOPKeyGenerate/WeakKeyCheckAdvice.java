package AOPKeyGenerate;


import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice{
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable {
        if(target instanceof KeyGenerator){
            if("getKey".equals(method.getName())){
                long key = ((Long)returnValue).longValue();
                if(KeyGenerator.WEAK_KEY == key){
                    throw new SecurityException("Кеу Generator generated а weak key. Try again");
                }
            }
        }
    }
}
