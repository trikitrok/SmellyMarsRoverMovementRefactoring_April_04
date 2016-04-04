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
}
