

public class Main {

    static int[][] createLatinMatrix(int n)
    {
        int[][] latinMatrix=new int[n][n];
        for(int index1=0; index1<n; index1++){
            for(int index2=0; index2<n;index2++){
                if(index1==0){
                    latinMatrix[index1][index2]= index2+1;
                }
                if(index1>0){
                    if(index2==n-1){
                        latinMatrix[index1][index2]=latinMatrix[index1-1][0];
                    }
                    else{
                        latinMatrix[index1][index2]=latinMatrix[index1-1][index2+1];
                    }

                }
            }
        }
        return latinMatrix;
    }

    static void displayLinesAndColoumns(int[][] matix){
        for (int line=0; line<matix.length; line++){
            StringBuilder concatLine = new StringBuilder();
            concatLine.append("line - ").append(line+1).append(": ");
            StringBuilder concatColumn = new StringBuilder();
            concatColumn.append("column - ").append(line+1).append(": ");
            for (int column=0; column<matix.length; column++){
                concatLine.append(matix[line][column]);
                concatColumn.append(matix[column][line]);
            }
            System.out.println(concatLine);
            System.out.println(concatColumn +"\n");

        }
    }
    public static void main(String args[]) {
        if(args.length<1)
        {
            System.out.println("There is the need for an argument in order to compute");
            System.exit(-1);
        }
        int n=0;
        try{
            n= Integer.parseInt(args[0]);
        }catch(Exception e){
            System.out.println("The argument should be an integer");
        }
        long time=System.nanoTime();
        int[][] matrix=createLatinMatrix(n);

        long endTime=System.nanoTime();
        if(n<30_000)
        {
            System.out.println("Print matrix:");
            for(int index1=0;index1<n;index1++) {
                for (int index2 = 0; index2 < n; index2++) {
                    System.out.print(matrix[index1][index2]);
                }
                System.out.println(" ");
            }
            displayLinesAndColoumns(matrix);
        }
        else
            System.out.println("Duration time:" + (endTime-time));
    }
}
