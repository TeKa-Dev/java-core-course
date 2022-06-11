package module_6_collections.lesson_6_2_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Collect {
    public static void main(String[] args) {

        Collection<?> collection = new ArrayList<>();
        Object object = new Object();

//      Какие операции над collection допустимы?

//        collection.add(object);
        collection.contains(object);
//        collection.addAll(Arrays.asList(object));
        collection.clear();
        collection.remove(object);
        collection.toArray();
        collection.iterator();
        collection.size();
    }
}
