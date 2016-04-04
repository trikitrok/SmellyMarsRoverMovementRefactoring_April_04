public class Direction {
    private String directionRepresentation;

    protected Direction(String directionRepresentation) {
        this.directionRepresentation = directionRepresentation;
    }

    public Direction rotateRight() {
        throw new RuntimeException("Defect, code should not get here! (Direction rotateRight)");
    }

    public Direction rotateLeft() {
        if (isNorth(directionRepresentation)) {
            throw new RuntimeException("Defect, code should not get here! (Direction rotateLeft)");
        } else if (isSouth(directionRepresentation)) {
            throw new RuntimeException("Defect, code should not get here! (Direction rotateLeft)");
        } else if (isWest(directionRepresentation)) {
            throw new RuntimeException("Defect, code should not get here! (Direction rotateLeft)");
        } else {
            return north();
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
        return isWest(directionRepresentation);
    }

    public boolean isSouth() {
        return isSouth(directionRepresentation);
    }

    public boolean isNorth() {
        return isNorth(directionRepresentation);
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
