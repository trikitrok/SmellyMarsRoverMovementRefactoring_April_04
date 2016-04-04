public class Rover {
    private Vector vector;

    public Rover(int x, int y, String directionRepresentation) {
        this.vector = new Vector(new Coordinates(x, y),  Direction.heading(directionRepresentation));
    }

    public void receive(String commandsSequence) {
        apply(commandsCreatedFrom(commandsSequence));
    }

    private void apply(Commands commands) {
        vector = commands.apply(vector);
    }

    private Commands commandsCreatedFrom(String commandsSequence) {
        return CommandsFactory.create(commandsSequence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        return vector != null ? vector.equals(rover.vector) : rover.vector == null;
    }
}
