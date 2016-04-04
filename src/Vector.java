public class Vector {
    private final Coordinates origin;
    private final Direction direction;

    public Vector(Coordinates origin, Direction direction) {
        this.origin = origin;
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (origin != null ? !origin.equals(vector.origin) : vector.origin != null) return false;
        return direction != null ? direction.equals(vector.direction) : vector.direction == null;

    }
}
