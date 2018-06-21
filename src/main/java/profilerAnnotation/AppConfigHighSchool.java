package profilerAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import profilerAnnotation.highschool.FoodProviderServiceImpl;

@Configuration
@Profile("highSchool")
public class AppConfigHighSchool {

    @Bean(name="foodProviderService")
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
