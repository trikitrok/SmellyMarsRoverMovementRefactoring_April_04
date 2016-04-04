public class CommandFactory {

    private static final int DISPLACEMENT_LENGTH = 1;

    public static Command createFrom(String representation) {
        if (isLeftRotation(representation)) {
            return new LeftRotation();
        } else if (isRightRotation(representation)) {
            return new RightRotation();
        } else if (isForwardsDisplacement(representation)) {
            return new Displacement(DISPLACEMENT_LENGTH);
        } else if (isBackwardsDisplacement(representation)) {
            return new Displacement(- DISPLACEMENT_LENGTH);
        } else {
            return new StayingPut();
        }
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
