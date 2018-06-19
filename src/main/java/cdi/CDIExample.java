package cdi;

/**
 * Created by anvi0616 on 6/19/2018.
 */
public class CDIExample {
    public static void main(String[] args) {
        Container container = new DefaultContainer();

        ManagedComponent managedComponent = new ContextualizedDependencyLookup();
        managedComponent.performLookup(container);
        System.out.println(managedComponent);
    }
}
