public class North extends Direction {
    public Direction rotateRight() {
        return east();
    }

    public Direction rotateLeft() {
        return west();
    }

    public Coordinates displace(Coordinates location, int displacement) {
        return location.add(new Coordinates(0, displacement));
    }
}
