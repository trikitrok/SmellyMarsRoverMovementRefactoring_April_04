public class North extends Direction {
    protected North(String directionRepresentation) {
        super(directionRepresentation);
    }

    public Direction rotateRight() {
        return east();
    }

    public Direction rotateLeft() {
        return west();
    }
}
