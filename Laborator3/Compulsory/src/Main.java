import problem.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Person("Persoana1"));
        Person person2= new Person("Persoana2");
        Person person3= new Person("Persoana3");
        Company company1 = new Company("Companie1");
        Company company2 = new Company("Companie2");
        Company company3 = new Company("Companie3");

        nodes.add(person2);
        nodes.add(person3);
        nodes.add(company1);
        nodes.add(company2);
        nodes.add(company3);

        for (Node node : nodes) {
            System.out.println(node);
        }

    }

}
