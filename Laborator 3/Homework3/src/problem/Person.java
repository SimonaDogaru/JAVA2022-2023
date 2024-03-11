package problem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Person implements Node , Comparable<Person> {
    protected String name;
    protected Date birthDate;
    private Map<Node, String> relationships = new HashMap<>();

    public Person(String name, Date date) {
        this.name = name;
        this.birthDate =date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public int getNumberOfRelationship() {
        return relationships.size();
    }
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        String birthDatePrint = new SimpleDateFormat("MM-dd-yyyy").format(this.birthDate);
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDatePrint +
                ", relationships=" + relationships +
                "}\n";
    }
}
