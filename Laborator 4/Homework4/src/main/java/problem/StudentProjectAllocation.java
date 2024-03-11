package problem;

import java.util.*;

public class StudentProjectAllocation {
    private Map<Student, Project> matches;
    private List<Student> students;
    private Set<Project>projects;
    public StudentProjectAllocation(List<Student> students, Set<Project> projects) {
        this.students = students;
        this.projects = projects;
        this.matches = new HashMap<>();
    }

    public Map<Student, Project> getMatches() {
        for (Map.Entry<Student, Project> entry : matches.entrySet()) {
            System.out.println(entry.getKey().getName() + ":" + entry.getValue().getName() +"\n");
        }
        return matches;
    }

    /**
     * the method will sort the student by the nr of admissibleProjects...
     */
    public void matchingGreedyAlgorithem() {
        this.students.sort(Comparator.comparingInt(s -> s.getAdmissibleProjects().size()));
        for (Project project : this.projects) {
            Student studentCurent = null;

            for (Student student : this.students) {
                if (!matches.containsKey(student) && !matches.containsValue(project) && student.getAdmissibleProjects().contains(project)) {
                    studentCurent = student;
                    break;
                }
            }

            if (studentCurent != null) {
                studentCurent.setAssignedProject(project);
                project.setAssignedStudent(studentCurent);
                matches.put(studentCurent, project);
            }
        }
    }
}
