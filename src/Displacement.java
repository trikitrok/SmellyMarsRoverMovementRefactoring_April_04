public class Displacement implements Command {
    private int length;

    public Displacement(int length) {
        this.length = length;
    }

    public Vector apply(Vector vector) {
        return vector.displace(length);
    }
}
