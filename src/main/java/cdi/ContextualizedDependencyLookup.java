package cdi;

/**
 * Created by anvi0616 on 6/19/2018.
 */
public class ContextualizedDependencyLookup implements ManagedComponent {
    private Dependency dependency;

    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("Dependency");
    }

    public String toString(){
        return dependency.toString();
    }
}
