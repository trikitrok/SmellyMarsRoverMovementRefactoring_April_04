public class Rover {
    private Direction direction;
    private Coordinates location;
    private Vector vector;

    public Rover(int x, int y, String directionRepresentation) {
        this.direction = Direction.heading(directionRepresentation);
        this.location = new Coordinates(x, y);
        this.vector = new Vector(location, direction);
    }

    private void setVector(Direction direction, Coordinates location) {
        this.direction = direction;
        this.location = location;
        this.vector = new Vector(location, direction);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (isLeftRotation(command)) {
                rotateLeft();
            } else if (isRightRotation(command)) {
                rotateRight();
            } else {
                displace(command);
            }
        }
    }

    private void rotateRight() {
        vector = vector.rotateRight();
        setVector(direction.rotateRight(), location);
    }

    private void rotateLeft() {
        vector = vector.rotateLeft();
        setVector(direction.rotateLeft(), location);
    }

    private void displace(String command) {
        int displacement = extractDisplacement(command);
        vector = vector.displace(displacement);
        setVector(direction, direction.displace(location, displacement));
    }

    private int extractDisplacement(String commandRepresentation) {
        final int DISPLACEMENT_LENGTH = 1;
        if (isForwardsDisplacement(commandRepresentation)) {
            return DISPLACEMENT_LENGTH;
        }
        return -DISPLACEMENT_LENGTH;
    }

    private boolean isForwardsDisplacement(String commandRepresentation) {
        return commandRepresentation.equals("f");
    }

    private boolean isRightRotation(String command) {
        return command.equals("r");
    }

    private boolean isLeftRotation(String command) {
        return command.equals("l");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        return vector != null ? vector.equals(rover.vector) : rover.vector == null;
    }
}
