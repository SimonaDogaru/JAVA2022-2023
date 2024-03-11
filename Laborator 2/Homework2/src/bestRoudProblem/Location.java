package bestRoudProblem;

import java.util.Objects;
/**
 * @author Simona Dogaru
 * */
public abstract class  Location {
    protected String name;
    protected double x,y;
    /**
     * the constructor for the Location
     * @param name a string
     * @param x double value
     * @param y double value
     * */
    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }
/**
 * @param name string
 * */

    public void setName(String name) {
        this.name = name;
    }


    public double getX() {
        return x;
    }
/**
 * @param x double value
 * */
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
/**
 * @param y double value
 * */
    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
/**
 * @param o  location object
 * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0 && Objects.equals(name, location.name);
    }
}
