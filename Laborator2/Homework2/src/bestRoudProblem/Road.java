package bestRoudProblem;

import java.util.Objects;

public class Road {
    private String name;
    private int speedLimit;
    private RoadType type;
    private Location a, b;
    private double length;
/**
 * Constructor for roads
 * @param name
 * @param a
 * @param b
 * @param length
 * @param speedLimit
 * @param type
 * */
    public Road(String name, int speedLimit,RoadType type, Location a, Location b, double length) {
        this.name = name;
        this.speedLimit = speedLimit;
        this.type = type;
        this.a = a;
        this.b =b;
        if (length < Math.sqrt(Math.pow((a.getX()-b.getX()),2) + Math.pow((a.getY()-b.getY()),2))) {
            System.out.println("Lungimea drumului nu este una valida");
            System.exit(-1);
        }
        this.length = length;
    }

    public String getName() {
        return name;
    }
/**
 * @param name
 * */

    public void setName(String name) {
        this.name = name;
    }

    public int getSleedLimit() {
        return speedLimit;
    }

    /**
     *
     * @param sleedLimit
     */
    public void setSleedLimit(int sleedLimit) {
        this.speedLimit = sleedLimit;
    }

    public RoadType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(RoadType type) {
        this.type = type;
    }

    public Location getA() {
        return a;
    }

    /**
     *
     * @param a
     */
    public void setA(Location a) {
        this.a = a;
    }

    public Location getB() {
        return b;
    }

    /**
     *
     * @param b
     */
    public void setB(Location b) {
        this.b = b;
    }

    public double getLength() {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(double length) {
        if (length < Math.sqrt(Math.pow((a.getX()-b.getX()),2) + Math.pow((a.getY()-b.getY()),2))) {
            System.out.println("Lungimea drumului nu este una valida");
            System.exit(-1);
        }
        this.length = length;
    }

    /**
     *
     * @return a string representing the Road object
     */
    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", sleedLimit=" + speedLimit +
                ", type=" + type +
                ", a=" + a +
                ", b=" + b +
                ", length=" + length +
                '}';
    }

    /**
     *
     * @param o road object
     * @return a boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return speedLimit == road.speedLimit && Double.compare(road.getLength(), getLength()) == 0 && getName().equals(road.getName()) && getType() == road.getType() && getA().equals(road.getA()) && getB().equals(road.getB());
    }

}
