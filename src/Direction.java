public class Direction {
    private String directionRepresentation;

    protected Direction(String directionRepresentation) {
        this.directionRepresentation = directionRepresentation;
    }

    public Direction rotateRight() {
        throw new RuntimeException("Defect, code should not get here! (Direction rotateRight)");
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
        if (directionRepresentation.equals("N")) {
            return north();
        } else if (directionRepresentation.equals("S")) {
            return south();
        } else if (directionRepresentation.equals(("W"))) {
            return west();
        }
        return east();
    }

    public static Direction east() {
        return new East("E");
    }

    public static Direction west() {
        return new West("W");
    }

    public static Direction north() {
        return new North("N");
    }

    public static Direction south() {
        return new South("S");
    }
}
