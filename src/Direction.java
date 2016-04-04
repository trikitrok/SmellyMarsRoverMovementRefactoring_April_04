public class Direction {
    private String directionRepresentation;

    protected Direction(String directionRepresentation) {
        this.directionRepresentation = directionRepresentation;
    }

    public Direction rotateRight() {
        if (isNorth()) {
            return east();
        } else if (isSouth()) {
            return west();
        } else if (isWest()) {
            return north();
        } else {
            return south();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return directionRepresentation != null ? directionRepresentation.equals(direction.directionRepresentation) : direction.directionRepresentation == null;

    }

    public boolean isWest() {
        return directionRepresentation.equals("W");
    }

    public boolean isSouth() {
        return directionRepresentation.equals("S");
    }

    public boolean isNorth() {
        return directionRepresentation.equals("N");
    }

    public static Direction heading(String directionRepresentation) {
        return new Direction(directionRepresentation);
    }

    public static Direction east() {
        return new Direction("E");
    }

    public static Direction west() {
        return new Direction("W");
    }

    public static Direction north() {
        return new Direction("N");
    }

    public static Direction south() {
        return new Direction("S");
    }
}
