import bestRoudProblem.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem pb= new Problem();
        City city1= new City("Oras1",3,2,20000);
        City city2 = new City("Oras2",8,4,30000);
        City city3 = new City("Oras3", 10,6,1000);
        GasStation station1= new GasStation("Statie1",4,6,(float) 7.45);
        Airport airport1 = new Airport("Airport", 10,1,4);
        pb.addLocation(city1);
        pb.addLocation(city2);
        pb.addLocation(city3);
        pb.addLocation(station1);
        pb.addLocation(airport1);

        Road road1= new Road("Oras1-GasStation",50,RoadType.COUNTRY,city1,station1,5.00);
        Road road2 = new Road("GasStatie-Oras2",50,RoadType.COUNTRY,station1,city2,7.00);
        Road road3 = new Road("Oras1-AirPort", 70,RoadType.HIGWAYS,city1,airport1,10.00);
        Road road4 = new Road("Oras2-Airport", 50,RoadType.COUNTRY,city2,airport1,9.00);
        Road road5 = new Road("Airport-Oras3", 120, RoadType.EXPRESS,airport1,city3, 15.00);

        pb.addRoads(road1);
        pb.addRoads(road2);
        pb.addRoads(road3);
        pb.addRoads(road4);
        pb.addRoads(road5);

    }
}
