public class West extends Direction {
    protected West(String directionRepresentation) {
        super(directionRepresentation);
    }

    public Direction rotateRight() {
        return north();
    }

    public Direction rotateLeft() {
        return south();
    }

    public Coordinates displace(Coordinates location, int displacement) {
        return location.add(new Coordinates(-displacement, 0));
    }
}
