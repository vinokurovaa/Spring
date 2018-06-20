package collectionInjectInSpring.annotation;

import collectionInjectInSpring.Oracle;
import org.springframework.stereotype.Service;

@Service("oracle")
public class BookWormOracle implements Oracle {
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - use the Internet";
    }
}
