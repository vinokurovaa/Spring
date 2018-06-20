package replacementMethod;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


public class FormatMessageReplacer implements MethodReplacer {
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        if(isFormatMessageMethod(method)){
            String msg = (String) objects[0];
            return "<h2>" + msg + "</h2>";
        }else{
            throw new IllegalArgumentException("Unable replace method = " + method.getName());
        }
    }
    public boolean isFormatMessageMethod(Method method){
        if(method.getParameterTypes().length != 1){
            return false;
        }
        if(!"formatMessage".equals(method.getName())){
            return false;
        }
        if(method.getReturnType() != String.class){
            return false;
        }
        if(method.getParameterTypes()[0] != String.class){
            return false;
        }
        return true;
    }
}
