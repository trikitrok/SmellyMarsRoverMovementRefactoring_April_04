public class Rover {
    private String directionRepresentation;
    private int y;
    private int x;
    private Direction direction;

    public Rover(int x, int y, String directionRepresentation) {
        this.directionRepresentation = directionRepresentation;
        this.y = y;
        this.x = x;
        this.direction = new Direction(directionRepresentation);
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
        if (isHeadedNorth()) {
            directionRepresentation = "E";
        } else if (isHeadedSouth()) {
            directionRepresentation = "W";
        } else if (isHeadedWest()) {
            directionRepresentation = "N";
        } else {
            directionRepresentation = "S";
        }
    }

    private void rotateLeft() {
        if (isHeadedNorth()) {
            directionRepresentation = "W";
        } else if (isHeadedSouth()) {
            directionRepresentation = "E";
        } else if (isHeadedWest()) {
            directionRepresentation = "S";
        } else {
            directionRepresentation = "N";
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
        return directionRepresentation.equals("W");
    }

    private boolean isHeadedSouth() {
        return directionRepresentation.equals("S");
    }

    private boolean isHeadedNorth() {
        return directionRepresentation.equals("N");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Rover other = (Rover) obj;

        if (directionRepresentation == null) {
            if (other.directionRepresentation != null)
                return false;
        } else if (!directionRepresentation.equals(other.directionRepresentation))
            return false;

        if (x != other.x)
            return false;

        if (y != other.y)
            return false;

        return true;
    }
}
