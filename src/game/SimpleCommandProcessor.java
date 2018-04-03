package game;

public class SimpleCommandProcessor implements CommandProcessor {
    @Override
    public Command getCommand() {
        return Command.DOWN;
    }
}
