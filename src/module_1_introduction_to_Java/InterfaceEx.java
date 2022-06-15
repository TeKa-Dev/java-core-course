package module_1_introduction_to_Java;

public interface InterfaceEx {

    public static final int B = 5;
    public static final String S = "S";

    public abstract int pubAbsInt();

    private int prvInt() {
        return pubAbsInt();
    }

    public default int defInt() {
        return prvInt();
    }

    public static int stcInt(InterfaceEx t) {
        return t.defInt();
    }

}
