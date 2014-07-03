package models;

import interfaces.ITape;

import java.util.Arrays;

/**
 * Created by stefanius on 29/06/14.
 */
public class Tape implements ITape {
    protected String initialTape;

    protected char[] tape;

    protected int postition;

    public Tape(String initialTape) {
        this.initialTape = initialTape;
        this.reset();
    }

    public String getInitialTape() {
        return initialTape;
    }

    public int getPostition() {
        return postition;
    }

    public void setPosition(int position) {
        this.postition = position;
    }

    public String getTape() {
        return new String(this.tape);
    }

    public String toString() {
        return this.getTape();
    }
    public char getCharOnCurrentPosition(){
        return this.tape[this.postition];
    }

    public void increasePosition() {
        this.postition++;
    }

    protected void increasePosition(boolean increaseTapeLength) {
        this.postition++;

        if (this.postition >= this.tape.length - 1) {
            if (increaseTapeLength) {
                this.tape = Arrays.copyOf(this.tape, this.tape.length + 1);
                this.tape[this.tape.length - 1] = '_';
            } else {
                this.postition = 0;
            }
        }
    }

    public void decreasePosition() {
        if ( this.postition > 0) {
            this.postition--;
        } else {
            this.postition = 1;
        }
    }

    public void reset() {
        String tape = '_' + this.initialTape + '_';
        this.postition = 1;
        this.tape = tape.toCharArray();
    }

    public char move(char direction, boolean increaseTapeLength) {
        if (direction == 'r') {
            this.decreasePosition();
        }

        if (direction == 'l') {
            this.increasePosition(increaseTapeLength);
        }

        return this.getCharOnCurrentPosition();
    }

    public char move(char direction) {
        return this.move(direction, false);
    }

    public void writeOnCurrentPostition(char c) {
        this.tape[this.postition] = c;
    }
}