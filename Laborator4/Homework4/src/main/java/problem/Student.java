package problem;

import java.util.List;
import java.util.TreeSet;

public class Student implements Comparable<Student> {
    private String name;
    private Project assignedProject;
    private TreeSet<Project> admissibleProjects;
    public Student(String name, List<Project> admissibleProjects )
    {
        this.name=name;
        this.admissibleProjects = new TreeSet<>(admissibleProjects);
    }

    public TreeSet<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setAssignedProject(Project project) {
        this.assignedProject = project;
    }

    public Project getAssignedProject() {
        return assignedProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", assignedProject=" + assignedProject +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }
}
