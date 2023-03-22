package problem;

public class Project implements Comparable<Project>{
    private String name;
    private Student assignedStudent;

    public Project(String name)
    {
        this.name=name;
    }

    public void setAssignedStudent(Student assignedStudent) {
        this.assignedStudent = assignedStudent;
    }

    public Student getAssignedStudent() {
        return assignedStudent;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}