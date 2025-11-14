package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidArgumentsException;

/**
 *
 */
public class FieldIce extends BaseField {
    public FieldIce(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    public void initialize() {
    }

    public boolean enterField(Direction direction) {

        setPlayerPositionToField();

        Field next = getNextInDirection(direction);

        boolean success = next.enterField(direction);

        if (!success) {
            gameBoard.getPlayer().walkStep();;
        }

        return true;
    }

    public boolean leaveField(Direction direction) {
        return true;
    }

    public Field getNextInDirection(Direction direction) {
        switch (direction) {
            case Up:
                return gameBoard.getField(row - 1, col);
            case Down:
                return gameBoard.getField(row + 1, col);
            case Left:
                return gameBoard.getField(row, col - 1);
            case Right:
                return gameBoard.getField(row, col + 1);
            default:
                return null;
        }
    }
}
