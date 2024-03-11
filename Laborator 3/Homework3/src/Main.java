import problem.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Network myNodes=new Network();

        Person person1=new Programmer("Ana", new Date(2001,07,20),"Java");
        Person person2=new Designer("Eliot", new Date(2001,12,07), "Canvas");
        Node companie1=new Company("Companie1");
        person1.addRelationship(person2,"besti");


        person1.addRelationship(companie1,"Leader");

        myNodes.addNode(person1);
        myNodes.addNode(person2);
        myNodes.addNode(companie1);

        System.out.println(myNodes + "\n");
        System.out.println(person1.getName()+"'s relationships: "+ person1.getRelationships() + "\n");
        System.out.println(person1.getName()+" has "+ person1.getNumberOfRelationship() + " in this Network\n");


    }

}
