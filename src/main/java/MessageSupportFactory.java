import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by anvi0616 on 6/19/2018.
 */
public class MessageSupportFactory {

    private static MessageSupportFactory instance;
    private MessageRenderer messageRenderer;
    private MessageProvider messageProvider;
    private Properties properties;

    private MessageSupportFactory(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/java/msf.properties"));
            String rendererClass = properties.getProperty("renderer.class");
            String providerClass = properties.getProperty("provider.class");

            messageRenderer = (MessageRenderer)Class.forName(rendererClass).newInstance();
            messageProvider = (MessageProvider)Class.forName(providerClass).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static{
        instance = new MessageSupportFactory();
    }
    public static MessageSupportFactory getinstance(){
        return instance;
    }
    public MessageRenderer getRenderer(){
        return messageRenderer;
    }
    public MessageProvider getProvider(){
        return messageProvider;
    }
}
