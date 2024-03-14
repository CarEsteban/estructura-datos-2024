import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.HashMap;

public class FactoryMaps<K,V> {
    AbstractMap<K,V> getInstanceMap(int index){

        switch (index) {
            case 1:
                return new HashMap<K,V>();
            case 2:
                return new TreeMap<K,V>();

            case 3:
                return new LinkedHashMap<K,V>();

            default:
                return null;
        }

        
    }
}