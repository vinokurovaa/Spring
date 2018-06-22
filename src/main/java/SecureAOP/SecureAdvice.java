package SecureAOP;


import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SecureAdvice implements MethodBeforeAdvice {
    private SecureManager secureManager;
    public SecureAdvice(){
        this.secureManager = new SecureManager();
    }
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        UserInfo user = secureManager.getLoggedIoUser();

        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: "
                    + method.getName());
        } else if ("chris".equals(user.getUserName())) {
            System.out.println("Logged in user is chris - OKAY!");
        } else {
            System.out.println("Logged in user is " + user.getUserName() + " NOT GOOD :(");
            throw new SecurityException("User " + user.getUserName() + " is not allowed access to method "
                    + method.getName());
        }
    }
}
