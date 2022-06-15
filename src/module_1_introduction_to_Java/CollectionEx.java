package module_1_introduction_to_Java;

import java.util.*;

public class CollectionEx {
    public static void main(String[] args) {

        HashMap<Integer, String> hm = new HashMap<>();
        TreeMap<Integer, String> tm = new TreeMap<>();

        hm.put(5, "g");
        hm.put(null, null);
        hm.put(8, "o");
        hm.put(4, "y");
        System.out.println(hm);

        for (Map.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


//        tm.put(null,null);
//        System.out.println();



        Iterator ir;
        Iterable ib;

//        TreeSet<StringBuilder> ts = new TreeSet<>();
////        ts.add(null);
//        ts.add(new StringBuilder("a"));
//        ts.add(new StringBuilder("b"));
//        ts.remove(new StringBuilder("a"));
//        ts.iterator();
//        System.out.println(ts.first());
//        System.out.println(ts);

//        HashSet<String> hs = new HashSet<>();
//        hs.add("ghi");
//        hs.add(null);
//        hs.add("abc");
//        hs.add(null);
//        hs.add("def");
//        System.out.println(hs);

//        LinkedHashSet<String> lhs = new LinkedHashSet<>();
//        lhs.add("ghi");
//        lhs.add("abc");
//        lhs.add(null);
//        lhs.add("def");
//        lhs.add(null);
//        System.out.println(lhs);

        ArrayList<String> al = new ArrayList<>();
        al.iterator();
//        al.add("first");
//        al.add(0, "second");
//        al.add("third");
//        al.set(1, "forth");
//        al.add(2, null);
//        al.add(2, null);
//        System.out.println(al);

//        LinkedList<String> ll = new LinkedList<>();
//        ll.add("first");
//        ll.add(0, "second");
//        ll.add("third");
//        ll.set(1, "forth");
//        ll.add(2, null);
//        ll.add(2, null);
//        System.out.println(ll);
    }

    //  Какие операции над collection допустимы?
    void abilityExample() {
        Collection<?> collection = new ArrayList<>();
        Object object = new Object();

//      collection.add(object);
//      collection.addAll(Arrays.asList(object));
        collection.contains(object);
        collection.clear();
        collection.remove(object);
        collection.toArray();
        collection.iterator();
        collection.size();
    }
}

class Example {
    //  Что произойдет? Почему отработает 2метод? Как это исправить?
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        Gen gen = new Gen();
        gen.m(integerList);
    }

    static class Gen<T> {
        <T> void m(Collection<T> collection) {
            for (T s : collection) {
                System.out.println(s);
            }
        }

        <T> void m(List<String> list) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
// нужно добавить тип параметра
//    Gen<Integer> gen = new Gen<>();
