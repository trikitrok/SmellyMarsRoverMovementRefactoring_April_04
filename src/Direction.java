public class Direction {
    private String directionRepresentation;

    protected Direction(String directionRepresentation) {
        this.directionRepresentation = directionRepresentation;
    }

    public Direction rotateRight() {
        throw new RuntimeException("Defect, code should not get here! (Direction rotateRight)");
    }

    public Direction rotateLeft() {
        throw new RuntimeException("Defect, code should not get here! (Direction rotateLeft)");
    }

    public Coordinates displace(Coordinates location, int displacement) {
        throw new RuntimeException("Defect, code should not get here! (Direction displace)");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return directionRepresentation != null ? directionRepresentation.equals(direction.directionRepresentation) : direction.directionRepresentation == null;

    }

    public static Direction heading(String directionRepresentation) {
        if (isNorth(directionRepresentation)) {
            return north();
        } else if (isSouth(directionRepresentation)) {
            return south();
        } else if (isWest(directionRepresentation)) {
            return west();
        }
        return east();
    }

    protected static Direction east() {
        return new East("E");
    }

    protected static Direction west() {
        return new West("W");
    }

    protected static Direction north() {
        return new North("N");
    }

    protected static Direction south() {
        return new South("S");
    }

    private static boolean isNorth(String directionRepresentation) {
        return directionRepresentation.equals("N");
    }

    private static boolean isSouth(String directionRepresentation) {
        return directionRepresentation.equals("S");
    }

    private static boolean isWest(String directionRepresentation) {
        return directionRepresentation.equals("W");
    }
}
