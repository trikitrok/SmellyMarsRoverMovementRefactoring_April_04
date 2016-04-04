public class South extends Direction {
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
