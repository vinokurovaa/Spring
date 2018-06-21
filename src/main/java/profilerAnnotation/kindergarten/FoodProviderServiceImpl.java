package profilerAnnotation.kindergarten;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import profilerAnnotation.Food;
import profilerAnnotation.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("kinderGarden")
public class FoodProviderServiceImpl implements FoodProviderService {
    public List<Food> providerLunchSet() {
        List<Food> lunch = new ArrayList<Food>();
        lunch.add(new Food("food3"));
        lunch.add(new Food("food4"));
        return lunch;
    }
}
