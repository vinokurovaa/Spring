package appConfig;

/**
 * Created by anvi0616 on 6/21/2018.
 */
public class ConfigurationMessageProvider implements MessageProvider {
    String message;
    public ConfigurationMessageProvider(){

    }
    public ConfigurationMessageProvider(String message){
        this.message = message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
