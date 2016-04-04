public class CommandFactory {
    public static Command createFrom(String commandRepresentation) {
        if (isLeftRotation(commandRepresentation)) {
            return new LeftRotation();
        } else if (isRightRotation(commandRepresentation)) {
            return new RightRotation();
        } else {
            int displacement = extractDisplacement(commandRepresentation);
            return new Displacement(displacement);
        }
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
