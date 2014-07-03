package models;

import java.util.HashMap;

/**
 * Created by stefanius on 27/06/14.
 */
public class State {

    protected String name;

    protected HashMap<Char, StateAction> stateActions;

    public State(String name) {
        this.name = name;
        this.stateActions = new HashMap<Char, StateAction>();
    }

    public String getName() {
        return name;
    }

    public HashMap<Char, StateAction> getStateActions() {
        return stateActions;
    }

    public void addStateAction (char condition, StateAction stateAction) {
        this.addStateAction(new Char(condition), stateAction);
    }

    public void addStateAction (Char condition, StateAction stateAction) {
        this.stateActions.put(condition, stateAction);
    }

    public void addStateAction (char condition, char writeValue, char moveDirection, String newState) {
        this.addStateAction(new Char(condition), new StateAction(writeValue, moveDirection, newState));
    }

    public StateAction getStateAction(char condition) {
        Char c = new Char(condition);

        return this.stateActions.get(c);
    }
}
