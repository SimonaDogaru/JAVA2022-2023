package bestRoudProblem;

import java.util.Objects;

public class Airport extends Location{
    private int numberOfTerminals;

    /**
     * co
     * @param name
     * @param x
     * @param y
     * @param terminals
     */
    public Airport(String name, double x, double y, int terminals) {
        super(name, x, y);
        this.numberOfTerminals=terminals;
    }

    /**
     *
     * @param numberOfTerminals
     */
    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    /**
     *
     * @return the number of terminals
     */
    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    /**
     *
     * @return a string representing the airport object
     */
    @Override
    public String toString() {
        return "Airport{" +
                "numberOfTerminals=" + numberOfTerminals +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     *
     * @param o - an Airport object
     * @return a boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return getNumberOfTerminals() == airport.getNumberOfTerminals();
    }

}
