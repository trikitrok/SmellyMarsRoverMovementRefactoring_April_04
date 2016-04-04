public class East extends Direction {
    public Direction rotateRight() {
        return south();
    }

    public Direction rotateLeft() {
        return north();
    }

    public Coordinates displace(Coordinates location, int displacement) {
        return location.add(new Coordinates(+displacement, 0));
    }
}
