package factorybean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service("digester")
public class MessageDigester {
    @Autowired
    private MessageDigest digest1;
    @Autowired
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1){
        this.digest1 = digest1;
    }
    public void setDigest2(MessageDigest digest2){
        this.digest2 = digest2;
    }
    public void digest(String msg){
        System.out.println("digest 1");
        digest(msg,digest1);
        System.out.println("digest 2");
        digest(msg,digest2);
    }
    private void digest(String msg, MessageDigest digest){
        System.out.println("AlgorithnName is " + digest.getAlgorithm());
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);
    }
}
