package models;

/**
 * Created by stefanius on 27/06/14.
 */
public class Char {

    protected char value;

    public Char(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean equals(Char c) {
        return c.getValue() == this.getValue();
    }

    public boolean equals (char c) {
        return c == this.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Char)) {
            return false;
        }

        return this.equals((Char) o);
    }

    @Override
    public int hashCode() {
        return (int) value;
    }
}
