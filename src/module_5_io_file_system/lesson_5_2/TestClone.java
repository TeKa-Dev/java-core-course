package module_5_io_file_system.lesson_5_2;

import java.util.Arrays;

public class TestClone {
    public static void main(String[] args) {

        Car bmw = new Car();
        bmw.model = "BMW X";
        bmw.serial = 6;
        bmw.rule = new Rule("hydro");
        bmw.options = new String[]{"climate ctrl", "auto trans", "airbag"};

        Car vaz = bmw.clone();
        vaz.model = "Lada 210";
        vaz.serial = 1;
        vaz.rule.type = "mechanic";
        vaz.options[0] = "vent";
        vaz.options[1] = "mech";
        vaz.options[2] = "seat";

        System.out.println(bmw.model + bmw.serial + " " + bmw.rule.type);
        System.out.println(Arrays.toString(bmw.options) + "\n");

        System.out.println(vaz.model + vaz.serial + " " + vaz.rule.type);
        System.out.println(Arrays.toString(vaz.options) + "\n");

//        System.out.println(vaz == bmw);
//        System.out.println(vaz);
//        System.out.println(bmw);
    }
}

class Car implements Cloneable {
    String model;
    Integer serial;
    Rule rule;
    String[] options;

    @Override
    public Car clone() {
        try {
            Car clone = (Car) super.clone();
            clone.rule = rule.clone();
            clone.options = options.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Rule implements Cloneable {
    String type;

    public Rule(String type) {
        this.type = type;
    }

    @Override
    public Rule clone() {
        try {
            return (Rule) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
