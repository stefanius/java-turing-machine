package models;

import java.util.HashMap;

/**
 * Created by stefanius on 27/06/14.
 */
public class Config {
    protected HashMap<String, State> states;

    protected String initalState;

    protected String finalState;

    protected int maxRounds = 10;

    protected boolean loop = true;

    protected String programm = "Unknown";

    protected String finalTape;

    public Config(String initalState, String finalState) {
        this.initalState = initalState;
        this.finalState = finalState;
        this.states = new HashMap<String, State>();
    }

    public Config(HashMap<String, State> states, String initalState, String finalState) {
        this.states = states;
        this.initalState = initalState;
        this.finalState = finalState;
    }

    public void addState(State state) {
        this.states.put(state.getName(), state);
    }

    public State getState(String name) {
        return this.states.get(name);
    }

    public HashMap<String, State> getStates() {
        return states;
    }

    public String getInitalState() {
        return initalState;
    }

    public String getFinalState() {
        return finalState;
    }

    public int getMaxRounds() {
        return maxRounds;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    public String getProgramm() {
        return programm;
    }

    public void setProgramm(String programm) {
        this.programm = programm;
    }

    public String getFinalTape() {
        return finalTape;
    }

    public void setFinalTape(String finalTape) {
        this.finalTape = finalTape;
    }
}
