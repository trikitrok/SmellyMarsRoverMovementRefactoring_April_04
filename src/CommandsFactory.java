import java.util.ArrayList;
import java.util.List;

public class CommandsFactory {
    public static Commands create(String commandsSequence) {
        List<Command> commands = new ArrayList<>();

        for (int i = 0; i < commandsSequence.length(); ++i) {
            String commandRepresentation = commandsSequence.substring(i, i + 1);
            commands.add(CommandFactory.createFrom(commandRepresentation));
        }
        return new Commands(commands);
    }
}
