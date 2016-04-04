import java.util.ArrayList;
import java.util.List;

public class Rover {
    private Vector vector;

    public Rover(int x, int y, String directionRepresentation) {
        this.vector = new Vector(new Coordinates(x, y),  Direction.heading(directionRepresentation));
    }

    public void receive(String commandsSequence) {
        List<Command> commands = createCommands(commandsSequence);
        applyCommands(commands);
    }

    private void applyCommands(List<Command> commands) {
        for(Command command : commands) {
            vector = command.apply(vector);
        }
    }

    private List<Command> createCommands(String commandsSequence) {
        List<Command> commands = new ArrayList<>();

        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (isLeftRotation(command)) {
                commands.add(new LeftRotation());
            } else if (isRightRotation(command)) {
                commands.add(new RightRotation());
            } else {
                int displacement = extractDisplacement(command);
                commands.add(new Displacement(displacement));
            }
        }
        return commands;
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
