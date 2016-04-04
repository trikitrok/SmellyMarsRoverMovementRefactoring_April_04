public class Rover {
    private int y;
    private int x;
    private Direction direction;

    public Rover(int x, int y, String directionRepresentation) {
        this.y = y;
        this.x = x;
        this.direction = Direction.heading(directionRepresentation);
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
        if (isHeadedNorth()) {
            this.direction = Direction.west();
        } else if (isHeadedSouth()) {
            this.direction = Direction.east();
        } else if (isHeadedWest()) {
            this.direction = Direction.south();
        } else {
            this.direction = Direction.north();
        }
    }

    private void displace(String command) {
        int displacement = extractDisplacement(command);

        if (isHeadedNorth()) {
            y += displacement;
        } else if (isHeadedSouth()) {
            y -= displacement;
        } else if (isHeadedWest()) {
            x -= displacement;
        } else {
            x += displacement;
        }
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

        if (y != rover.y) return false;
        if (x != rover.x) return false;
        return direction != null ? direction.equals(rover.direction) : rover.direction == null;
    }
}
