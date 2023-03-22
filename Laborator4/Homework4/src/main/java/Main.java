import com.github.javafaker.Faker;
import problem.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {

        var projects = IntStream.rangeClosed(0,2).mapToObj(i -> new Project("P" + i) ).toArray(Project[]::new);
        Set<Project> listOfProjects = new TreeSet<>(Project::compareTo);
        listOfProjects.addAll(Arrays.asList(projects));

        LinkedList<Student> listOfStudents=new LinkedList<>();
        listOfStudents.add( new Student("S0", Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2"))));
        listOfStudents.add( new Student("S1", Arrays.asList(new Project("P0"), new Project("P1"))));
        listOfStudents.add(new Student("S2", Arrays.asList(new Project("P0"), new Project("P1"))));

        Collections.sort(listOfStudents);

        System.out.println("Students that have a number of preferences lower than the average number of preferences");

        double averageNumberOfPreferences = listOfStudents.stream()
                .mapToInt(student -> student.getAdmissibleProjects().size())
                .average()
                .orElse(0.0);

        /***
         * Using Java Stream API, write a query that display all the students that have a number of preferences lower
         * than the average number of preferences
         */

        listOfStudents.stream().filter(student -> student.getAdmissibleProjects().size() < averageNumberOfPreferences).
                forEach(System.out::println);

        StudentProjectAllocation problema1 = new StudentProjectAllocation(listOfStudents,listOfProjects);
        System.out.println("Solution:");
        problema1.matchingGreedyAlgorithem();
        problema1.getMatches();

        Faker faker = new Faker();
        List<Student> listFakeStudents = new ArrayList<>();
        Set<Project> listFakeProjects = new TreeSet<>();
        List<Project> admissibleProjects=new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            String name = faker.name().fullName();
            String nameProject = faker.lorem().word();

            Project project = new Project(nameProject);
            listFakeProjects.add(project);
            admissibleProjects.add(project);

            Student student = new Student(name, admissibleProjects);
            listFakeStudents.add(student);
        }
        System.out.println("Fake project names list: "+listFakeProjects);
        System.out.println("Fake students names list: "+listFakeStudents);

        StudentProjectAllocation fakeProblem = new StudentProjectAllocation(listFakeStudents,listFakeProjects);
        System.out.println("Solution:");
        fakeProblem.matchingGreedyAlgorithem();
        fakeProblem.getMatches();

    }
}