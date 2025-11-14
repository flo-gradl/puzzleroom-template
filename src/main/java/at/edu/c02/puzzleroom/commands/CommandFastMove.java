package at.edu.c02.puzzleroom.commands;

import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.Player;
import at.edu.c02.puzzleroom.exceptions.*;

public class CommandFastMove implements Command {
    private final String[] arguments;

    public CommandFastMove(String[] arguments) throws PuzzleRoomException {
        this.arguments = arguments;
    }

    public void execute(GameBoard gameBoard) throws PuzzleRoomException {
        Player player = gameBoard.getPlayer();
        if (player == null) {
            throw new PuzzleRoomInvalidMoveException();
        }

        for (String arg : arguments) {
            boolean success = switch (arg) {
                case "l" -> player.moveLeft();
                case "r" -> player.moveRight();
                case "u" -> player.moveUp();
                case "d" -> player.moveDown();
                default -> throw new PuzzleRoomInvalidArgumentsException();
            };

            if (!success) {
                throw new PuzzleRoomInvalidMoveException();
            }
        }

        CommandShow showCommand = new CommandShow();
        showCommand.execute(gameBoard);
    }
}