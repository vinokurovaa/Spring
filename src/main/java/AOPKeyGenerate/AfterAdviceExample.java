package AOPKeyGenerate;


import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {
    private static KeyGenerator getkeyGenerator() {
        KeyGenerator keyGenerator = new KeyGenerator();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new WeakKeyCheckAdvice());
        pf.setTarget(keyGenerator);

        KeyGenerator proxy = (KeyGenerator) pf.getProxy();
        return proxy;
    }

    public static void main(String[] args) {
        KeyGenerator keyGenerator = getkeyGenerator();
        for (int i = 0; i < 10; i++) {
            try {
                long key = keyGenerator.getKey();
                System.out.println("Key = " + key);
            } catch (SecurityException e) {
                System.out.println("Weak key generate");
            }
        }
    }
}
