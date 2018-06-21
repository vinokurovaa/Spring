package appConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource(value="META-INF/Spring/app-context-appConfig.xml")
@PropertySource(value="classpath:message.properties")
@ComponentScan(basePackages = "appConfig")
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    Environment environment;

    @Bean
    @Lazy(value = true)
    public MessageProvider messageProvider(){
        return new ConfigurationMessageProvider(environment.getProperty("message"));
    }

    @Bean(name="messageRenderer")
    @DependsOn(value="messageProvider")
    @Scope(value = "prototype")
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandartMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }
}
