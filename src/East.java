public class East extends Direction {
    protected East(String directionRepresentation) {
        super(directionRepresentation);
    }

    public Direction rotateRight() {
        return south();
    }
}
