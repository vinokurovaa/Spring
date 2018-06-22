package SecureAOP;


import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
    public static void main(String[] args) {
        SecureManager secureManager = new SecureManager();
        SecureBean secureBean = getSecureBean();
        secureManager.login("chris", "psw");
        secureBean.writeSecureMessage();
        secureManager.logout();
        try{
            secureManager.login("invalidUser", "psw");
        }catch (SecurityException e){
            System.out.println(e.getMessage());
        }finally {
            secureManager.logout();
        }
    }
    private static SecureBean getSecureBean(){
        SecureBean target = new SecureBean();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SecureAdvice());
        pf.setTarget(target);

        SecureBean proxy = (SecureBean)pf.getProxy();
        return proxy;
    }
}
