package models;

/**
 * Created by stefanius on 27/06/14.
 */
public class StateAction {

    protected char writeValue;

    protected char moveDirection;

    protected String newState;

    public StateAction(char writeValue, char moveDirection, String newState) {
        this.writeValue = writeValue;
        this.moveDirection = moveDirection;
        this.newState = newState;
    }

    public char getWriteValue() {
        return writeValue;
    }

    public char getMoveDirection() {
        return moveDirection;
    }

    public String getNewState() {
        return newState;
    }
}
