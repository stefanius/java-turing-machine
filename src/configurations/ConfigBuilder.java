package configurations;

import models.Config;
import models.State;

/**
 * Created by stefanius on 29/06/14.
 */
public class ConfigBuilder {

    public Config createIncrementer() {
        Config config = new Config("state1", "HALT");

        State state1 = new State("state1");
        State state2 = new State("state2");
        State state3 = new State("HALT");

        state1.addStateAction('0', '1', 'r', "state2");
        state1.addStateAction('_', '1', 'r', "state2");
        state1.addStateAction('1', '0', 'l', "state1");

        state2.addStateAction('0', '0', 'r', "state2");
        state2.addStateAction('1', '1', 'r', "state2");
        state2.addStateAction('_', '_', 'l', "HALT");

        config.addState(state1);
        config.addState(state2);
        config.addState(state3);

        return config;
    }

    public Config createDecrementer() {
        Config config = new Config("state1", "HALT");

        State state1 = new State("state1");
        State state2 = new State("state2");
        State state3 = new State("HALT");

        state1.addStateAction('1', '0', 'r', "state2");
        state1.addStateAction('_', '0', 'r', "state2");
        state1.addStateAction('0', '1', 'l', "state1");

        state2.addStateAction('0', '0', 'r', "state2");
        state2.addStateAction('1', '1', 'r', "state2");
        state2.addStateAction('_', '_', 'l', "HALT");

        config.addState(state1);
        config.addState(state2);
        config.addState(state3);

        return config;
    }
}
