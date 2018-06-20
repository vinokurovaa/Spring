package factorybean.annotation;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
@Service("customdigest")
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
    private String algorithmName = "MD5";
    private MessageDigest messageDigest;
    @Nullable
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Nullable
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }
    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }
}
