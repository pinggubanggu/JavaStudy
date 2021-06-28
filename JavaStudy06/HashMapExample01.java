package JavaStudy06;

import java.util.*;

public class HashMapExample01 {

    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("핑구", 90);
        map.put("뱅구", 90);

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println( e.getKey() +","+  e.getValue());
        }
    }

}
