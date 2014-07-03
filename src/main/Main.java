package main;

import configurations.ConfigBuilder;
import machines.Machine;
import models.Config;
import models.State;
import models.Tape;

/**
 * Created by stefanius on 28/06/14.
 */
public class Main {

    public static void main(String [] args)
    {
        ConfigBuilder builder = new ConfigBuilder();

        Config config = builder.createDecrementer();

        Tape tape = new Tape("000100");

        Machine m = new Machine(config, tape, false, false);

        while(m.isLoop()){
            m.run();
        }
    }

}
