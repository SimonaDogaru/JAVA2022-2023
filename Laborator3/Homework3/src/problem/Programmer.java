package problem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Programmer extends Person{

    String programingLanguage;

    public Programmer(String name, Date date, String language) {
        super(name, date);
        this.programingLanguage=language;
    }
    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }

    @Override
    public String toString() {
        String birthDatePrint = new SimpleDateFormat("MM-dd-yyyy").format(this.birthDate);
        return "Programmer{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDatePrint +
                ", programingLanguage='" + programingLanguage + '\'' +
                "}\n";
    }
}
