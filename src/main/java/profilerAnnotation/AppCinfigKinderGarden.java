package profilerAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import profilerAnnotation.kindergarten.FoodProviderServiceImpl;

@Configuration
@Profile("kinderGarden")
public class AppCinfigKinderGarden {

    @Bean(name="foodProviderService")
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
