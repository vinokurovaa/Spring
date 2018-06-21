package profilerAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ProfilerExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("kinderGarden");
        ctx.register(AppConfig.class);
        ctx.refresh();
        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> foods = foodProviderService.providerLunchSet();
        for(Food food : foods){
            System.out.println(food.getName());
        }
    }
}
