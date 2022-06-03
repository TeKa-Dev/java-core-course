package I_introduction_to_Java;

public abstract class TestAbstract {

    byte b;
    private byte pb;
    public byte bb;
    static byte sb;
    final byte fb = 0;


    byte pacByte() {
        return b;
    }

    private byte prvByte() {
        return pb;
    }

    public byte pubByte() {
        return bb;
    }

    static byte stcByte() {
        return sb;
    }

    final byte finByte() {
        return fb;
    }

    abstract byte absByte();
}
