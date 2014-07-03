package machines;

import models.Config;
import models.State;
import models.StateAction;
import models.Tape;

/**
 * Created by stefanius on 29/06/14.
 */
public class Machine {
    protected Config config;

    protected Tape tape;

    protected State currentState;

    protected boolean debug = false;

    protected boolean increaseTapeLength = false;

    protected boolean loop = true;

    protected int rounds = 0;

    protected int brakeAfterProcessedAction = 10000; //Terminate after 5000 actions. This is way to much, and is a good indicator the machine is in a endlessloop.

    protected int processedActions = 0;
    public Machine(Config config, Tape tape) {
        this.config = config;
        this.tape = tape;

        this.loadState(config.getInitalState());
    }

    public Machine(Config config, Tape tape, boolean debug) {
        this(config, tape);
        this.debug = debug;
    }

    public Machine(Config config, Tape tape, boolean debug, boolean increaseTapeLength) {
        this(config, tape);
        this.debug = debug;
        this.increaseTapeLength = increaseTapeLength;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void loadState(String name) {
        this.currentState = this.config.getState(name);
    }

    public void setTape(Tape tape) {
        this.tape = tape;
    }

    public void run() {
        StateAction action;

        this.processedActions++;

        if (!this.currentState.getName().equals(this.config.getFinalState()) ) {
            action = this.currentState.getStateAction(this.tape.getCharOnCurrentPosition());

        } else {
            this.rounds++;
            this.loadState(this.config.getInitalState());
            action = this.currentState.getStateAction(this.tape.getCharOnCurrentPosition());

            String tapeString = this.tape.toString().replace('_', ' ').trim();
            System.out.println(tapeString);

            if (!this.config.isLoop()) {
                this.setLoop(false);
                return;
            }

            if (this.config.getMaxRounds() > 0 && this.config.getMaxRounds() == this.rounds) {
                this.setLoop(false);
                System.out.println("Machine is terminated because it reached its max round limit. You may want to change this value.");
                return;
            }
        }

        this.tape.writeOnCurrentPostition(action.getWriteValue());
        this.tape.move(action.getMoveDirection(), this.increaseTapeLength);

        this.loadState(action.getNewState());

        if (this.debug) {
            System.out.println(this.tape);
        }

        if (this.processedActions > this.brakeAfterProcessedAction) {
            System.out.println("Machine is terminated to prevent a endless loop. Check the configuration and the tape input.");
            this.setLoop(false);
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isDebug() {
        return debug;
    }

    public int getRounds() {
        return rounds;
    }
}
