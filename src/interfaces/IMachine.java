package interfaces;

/**
 * Created by stefanius on 27/06/14.
 */
public interface IMachine {

    public char readTape();

    public void shiftTapeLeft();

    public void shiftTapeRight();

    public void match();

    public void step();

}
