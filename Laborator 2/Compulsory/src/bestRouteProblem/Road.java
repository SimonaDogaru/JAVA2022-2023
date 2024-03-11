package bestRouteProblem;

public class Road {
    private String name;
    private int speedLimit;
    private RoadType type;
    private Location a, b;
    private double length; // don't forget to validate the length in the constructor

    public Road(String name, int speedLimit,RoadType type, Location a, Location b, double length) {
        this.name = name;
        this.speedLimit = speedLimit;
        this.type = type;
        this.a = a;
        this.b =b;
        this.length = length;
    }
    // ... getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSleedLimit() {
        return speedLimit;
    }

    public void setSleedLimit(int sleedLimit) {
        this.speedLimit = sleedLimit;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public Location getA() {
        return a;
    }

    public void setA(Location a) {
        this.a = a;
    }

    public Location getB() {
        return b;
    }

    public void setB(Location b) {
        this.b = b;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

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
}
