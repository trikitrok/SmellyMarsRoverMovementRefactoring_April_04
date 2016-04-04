public class Rover {
    private Direction direction;
    private Coordinates location;

    public Rover(int x, int y, String directionRepresentation) {
        this.direction = Direction.heading(directionRepresentation);
        this.location = new Coordinates(x, y);
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
        direction = direction.rotateRight();
    }

    private void rotateLeft() {
        direction = direction.rotateLeft();
    }

    private void displace(String command) {
        int displacement = extractDisplacement(command);
        location = direction.displace(location, displacement);
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

    private boolean isHeadedWest() {
        return direction.isWest();
    }

    private boolean isHeadedSouth() {
        return direction.isSouth();
    }

    private boolean isHeadedNorth() {
        return direction.isNorth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (direction != null ? !direction.equals(rover.direction) : rover.direction != null) return false;
        return location != null ? location.equals(rover.location) : rover.location == null;

    }
}
