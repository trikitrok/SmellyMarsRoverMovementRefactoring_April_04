public class CommandFactory {
    public static Command createFrom(String representation) {
        if (isLeftRotation(representation)) {
            return new LeftRotation();
        } else if (isRightRotation(representation)) {
            return new RightRotation();
        } else if (isForwardsDisplacement(representation)) {
            int displacement = extractDisplacement(representation);
            return new Displacement(displacement);
        } else if (isBackwardsDisplacement(representation)) {
            int displacement = extractDisplacement(representation);
            return new Displacement(displacement);
        } else {
            return new StayingPut();
        }
    }

    private static int extractDisplacement(String representation) {
        final int DISPLACEMENT_LENGTH = 1;
        if (isForwardsDisplacement(representation)) {
            return DISPLACEMENT_LENGTH;
        }
        return -DISPLACEMENT_LENGTH;
    }

    private static boolean isBackwardsDisplacement(String representation) {
        return representation.equals("b");
    }

    private static boolean isForwardsDisplacement(String representation) {
        return representation.equals("f");
    }

    private static boolean isRightRotation(String representation) {
        return representation.equals("r");
    }

    private static boolean isLeftRotation(String representation) {
        return representation.equals("l");
    }
}
