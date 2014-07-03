package interfaces;

import java.util.Arrays;

/**
 * Created by stefanius on 29/06/14.
 */
public interface ITape {

    public String getInitialTape();
    public int getPostition();
    public void setPosition(int position);
    public String getTape();
    public char getCharOnCurrentPosition();
    public void increasePosition();
    public void decreasePosition();
    public void reset();
    public char move(char direction, boolean increaseTapeLength);
    public char move(char direction);
    public void writeOnCurrentPostition(char c);
}
