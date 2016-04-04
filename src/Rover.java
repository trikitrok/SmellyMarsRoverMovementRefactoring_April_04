public class Rover {
    private Vector vector;

    public Rover(int x, int y, String directionRepresentation) {
        this.vector = new Vector(new Coordinates(x, y),  Direction.heading(directionRepresentation));
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (isLeftRotation(command)) {
                rotateLeft();
            } else if (isRightRotation(command)) {
                vector = new RightRotation().apply(vector);
            } else {
                displace(command);
            }
        }
    }

    private void rotateLeft() {
        vector = vector.rotateLeft();
    }

    private void displace(String command) {
        int displacement = extractDisplacement(command);
        vector = vector.displace(displacement);
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
