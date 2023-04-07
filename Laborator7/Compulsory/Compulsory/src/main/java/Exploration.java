import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory mem = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap(5);
    private final List<Robot> robots = new ArrayList<>();

    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMem() {
        return mem;
    }

    public void start() {
        for (Robot robot : robots) {
            Thread t= new Thread(robot);
            t.start();
        }
    }
    public void addRobot(Robot robot)
    {
        robots.add(robot);
        robot.setExplore(this);
    }
    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

}