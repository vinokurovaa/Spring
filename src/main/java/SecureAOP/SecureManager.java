package SecureAOP;


public class SecureManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();
    public void login(String userName, String passWord){
        threadLocal.set(new UserInfo(userName, passWord));
    }
    public void logout(){
        threadLocal.set(null);
    }
    public UserInfo getLoggedIoUser(){
        return threadLocal.get();
    }
}
