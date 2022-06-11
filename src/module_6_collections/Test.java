package module_6_collections;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Optional<int[]> op;
        Optional<String> s = Optional.of("abc");
        System.out.println(s.orElse("def"));
        System.out.println(s.get());
        System.out.println(s);

    }
}
