package problem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Designer extends Person{

    private String designTool;

    public Designer(String name, Date date, String designTool) {
        super(name, date);
        this.designTool=designTool;
    }

    public String getDesignTool() {
        return designTool;
    }

    public void setDesignTool(String designTool) {
        this.designTool = designTool;
    }

    @Override
    public String toString() {
        String birthDatePrint = new SimpleDateFormat("MM-dd-yyyy").format(this.birthDate);
        return "Designer{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDatePrint +
                ", designTool='" + designTool + '\'' +
                '}';
    }
}
