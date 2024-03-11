package bestRoudProblem;

import java.util.Objects;

public class City extends Location{
    private int population;

    /**
     * Constructor
     * @param name a string
     * @param x a double value
     * @param y a double value
     * @param population  the nr of people
     */
    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }

    /**
     *
     * @return a Interge value - the number of people in the city
     */
    public int getPopulation() {
        return population;
    }

    /**
     *
     * @param population an Integer - the numer of people
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     *
     * @return an string representing the city object
     */
    @Override
    public String toString() {
        return "City{" +
                "population=" + population +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return getPopulation() == city.getPopulation();
    }

}
