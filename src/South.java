public class South extends Direction {
    protected South(String directionRepresentation) {
        super(directionRepresentation);
    }

    public Direction rotateRight() {
        return west();
    }

    public Direction rotateLeft() {
        return east();
    }

    public Coordinates displace(Coordinates location, int displacement) {
        return location.add(new Coordinates(0, -displacement));
    }
}
