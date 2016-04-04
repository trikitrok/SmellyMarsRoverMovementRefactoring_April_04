import java.util.ArrayList;
import java.util.List;

public class CommandsFactory {
    public static Commands create(String commandsSequence) {
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
        return new Commands(commands);
    }

    private static int extractDisplacement(String commandRepresentation) {
        final int DISPLACEMENT_LENGTH = 1;
        if (isForwardsDisplacement(commandRepresentation)) {
            return DISPLACEMENT_LENGTH;
        }
        return -DISPLACEMENT_LENGTH;
    }

    private static boolean isForwardsDisplacement(String commandRepresentation) {
        return commandRepresentation.equals("f");
    }

    private static boolean isRightRotation(String command) {
        return command.equals("r");
    }

    private static boolean isLeftRotation(String command) {
        return command.equals("l");
    }
}
