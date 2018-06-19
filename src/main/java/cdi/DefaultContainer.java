package cdi;

/**
 * Created by anvi0616 on 6/19/2018.
 */
public class DefaultContainer implements Container {
    public Object getDependency(String key) {
        if("Dependency".equals(key)){
            return new Dependency();
        }
        throw  new RuntimeException("This dependency is not found");
    }
}
