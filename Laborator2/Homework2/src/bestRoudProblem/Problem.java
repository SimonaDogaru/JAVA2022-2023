package bestRoudProblem;

import java.util.Arrays;
import java.util.List;

public class Problem {

    private Road[] roads;
    private Location[] locations;
    private int numberOfRoads;
    private int numberOfLocations;
    public Problem()
    {
        this.locations=new Location[1000];
        this.roads=new Road[1000];
        numberOfLocations=0;
        numberOfRoads=0;
    }

    /**
     * this method is used to add a road in the roads array if it is not already added
     * @param road a road object
     */
    public void addRoads(Road road)
    {
        boolean duplicates = false;
        if(numberOfRoads==0)
        {
            roads[numberOfRoads]=road;
            numberOfRoads++;
        }
        else
        {
            for(int i=0;i<numberOfRoads;i++)
            {
                if(roads[i].equals(road))
                    duplicates=true;
            }
            if(!duplicates)
            {
                roads[numberOfRoads]=road;
                numberOfRoads++;
            }
        }
    }

    /**
     * this method is used to add a road in the roads array if it is not already added
     * @param location a location object
     */
    public void addLocation(Location location)
    {
        boolean duplicates = false;
        if(numberOfLocations==0)
        {
            locations[numberOfLocations]=location;
            numberOfLocations++;
        }
        else
        {
            for(int i=0;i<numberOfLocations;i++)
            {
                if(locations[i].equals(location))
                    duplicates=true;
            }
            if(!duplicates)
            {
                locations[numberOfLocations]=location;
                numberOfLocations++;
            }
        }
    }

    /**
     *
     * @return a boolean value - true if the problem instance is a valid one
     */
    public boolean isValid(){
        if(locations.length<1 || roads.length==0)
            return false;

        for(int index=0; index< locations.length; index++){
            for(int index2=0; index2< locations.length; index2++){
                if(locations[index].equals(locations[index2]) && index!=index2) {
                    return false;
                }
            }
        }
        for(int index=0; index< roads.length; index++){
            for(int index2=0; index2< roads.length; index2++){
                if(roads[index].equals(roads[index2]) && index!=index2) {
                    return false;
                }
            }
        }
        return true;
    }
    public Road[] getRoads() {
        return roads;
    }

    public int getNumberOfRoads() {
        return numberOfRoads;
    }

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public Location[] getLocations() {
        return locations;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "roads=" + Arrays.toString(roads) +
                ", locations=" + Arrays.toString(locations) +
                ", numberOfRoads=" + numberOfRoads +
                ", numberOfLocations=" + numberOfLocations +
                '}';
    }

}
