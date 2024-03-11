import problem.*;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(1, 2).mapToObj(i -> new Student("S" + i) ).toArray(Student[]::new);
        var projects = IntStream.rangeClosed(3, 5).mapToObj(i -> new Project("P" + i) ).toArray(Project[]::new);
        List<Student> listOfStudents = new LinkedList<>();
        listOfStudents.addAll( Arrays.asList(students) );
        listOfStudents.add(new Student("S0"));
        System.out.println("Students: ");
        for (Student student : listOfStudents) {
            System.out.println(student.getName());
        }

        Collections.sort(listOfStudents, Student::compareTo);
        for (Student student : listOfStudents) {
            System.out.println(student.getName());
        }
        System.out.println("Proiecte:");
        Set<Project> listOfProjects = new TreeSet<>(Project::compareTo);
        listOfProjects.addAll(Arrays.asList(projects));
        for (Project project : listOfProjects) {
            System.out.println(project.getName());
        }
        System.out.println("Add P2,P1,P0 in decreasing order");
        listOfProjects.add(new Project("P2"));
        listOfProjects.add(new Project("P1"));
        listOfProjects.add(new Project("P0"));
        for (Project project : listOfProjects) {
            System.out.println(project.getName());
        }

    }
}

