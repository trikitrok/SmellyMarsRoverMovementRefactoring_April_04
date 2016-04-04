public class West extends Direction {
    protected West(String directionRepresentation) {
        super(directionRepresentation);
    }

    public Direction rotateRight() {
        return north();
    }
}
