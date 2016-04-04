public class Rover {

    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.direction = direction;
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (isLeftRotation(command) || isRightRotation(command)) {
                // Rotate Rover
                if (isHeadedNorth()) {
                    if (isRightRotation(command)) {
                        direction = "E";
                    } else {
                        direction = "W";
                    }
                } else if (isHeadedSouth()) {
                    if (isRightRotation(command)) {
                        direction = "W";
                    } else {
                        direction = "E";
                    }
                } else if (isHeadedWest()) {
                    if (isRightRotation(command)) {
                        direction = "N";
                    } else {
                        direction = "S";
                    }
                } else {
                    if (isRightRotation(command)) {
                        direction = "S";
                    } else {
                        direction = "N";
                    }
                }
            } else {
                displace(command);
            }
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

    private int extractDisplacement(String command) {
        int displacement1 = -1;

        if (command.equals("f")) {
            displacement1 = 1;
        }
        return displacement1;
    }

    private boolean isRightRotation(String command) {
        return command.equals("r");
    }

    private boolean isLeftRotation(String command) {
        return command.equals("l");
    }

    private boolean isHeadedWest() {
        return direction.equals("W");
    }

    private boolean isHeadedSouth() {
        return direction.equals("S");
    }

    private boolean isHeadedNorth() {
        return direction.equals("N");
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

        if (direction == null) {
            if (other.direction != null)
                return false;
        } else if (!direction.equals(other.direction))
            return false;

        if (x != other.x)
            return false;

        if (y != other.y)
            return false;

        return true;
    }
}
