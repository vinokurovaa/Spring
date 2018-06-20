package collectionInjectInSpring.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("injectCollection")
public class CollectionInjection {
    @Resource(name="map")
    private Map<String, Object> map;

    @Resource(name="props")
    private Properties prop;

    @Resource(name="set")
    private Set set;

    @Resource(name="list")
    private List list;

    public void displayInfo(){
        System.out.println("Map contents: ");
        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
            System.out.println();
        }
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        System.out.println("\nSet contents:\n");

        for (Object obj : set) {
            System.out.println("Value: " + obj);
        }
        System.out.println("\nList contents:\n");

        for (Object obj : list) {
            System.out.println("Value: " + obj);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/Spring/app-context-annotation.xml");
        ctx.refresh();

        CollectionInjection collectionInjection = ctx.getBean("injectCollection", CollectionInjection.class);
        collectionInjection.displayInfo();
    }
}
