package factorybean;


import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest messageDigest1;
    private MessageDigest messageDigest2;

    public void setDigest1(MessageDigest messageDigest1){
        this.messageDigest1 = messageDigest1;
    }

    public void setDigest2(MessageDigest messageDigest2){
        this.messageDigest2 = messageDigest2;
    }

    public void digest(String msg){
        System.out.println("messageDigest1");
        digest(msg,messageDigest1);
        System.out.println("messageDigest2");
        digest(msg,messageDigest2);
    }
    private void digest(String msg, MessageDigest messageDigest){
        System.out.println("Algorithm is " + messageDigest.getAlgorithm());
        messageDigest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = messageDigest.digest(bytes);
        System.out.println(out);
    }
}
