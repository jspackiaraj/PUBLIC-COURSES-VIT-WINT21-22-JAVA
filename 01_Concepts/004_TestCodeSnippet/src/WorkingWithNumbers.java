import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
public class WorkingWithNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputObject = new Scanner(System.in);
// We will fix the file name in the interest of time during debugging
        String strFileName = inputObject.next();  // Remember to escape the string in Windows machines
        File fileName = new File(strFileName);
        Scanner fileObject = new Scanner(fileName);
        String strRsltN_01, strRsltN_02,strRsltN_03,strPower;
        double dblRsltN_01, dblRsltN_02,dblRsltN_03,dblPower;
// Rounding Formats
        DecimalFormat df4places = new DecimalFormat("0.0000");
        DecimalFormat df5places = new DecimalFormat("0.00000");
        while(fileObject.hasNextLine()){
            String[] strRecords = fileObject.nextLine().split(",");
            try{
                dblRsltN_01 = Double.parseDouble(strRecords[0]);
                dblRsltN_02 = Double.parseDouble(strRecords[1]);
                dblRsltN_03 = Double.parseDouble(strRecords[2]);
                dblPower = Double.parseDouble(strRecords[3]);
                // If there is no error in the setting of date, the following lines of code will be executed
                dblRsltN_01 = Math.log10(dblRsltN_01);
                dblRsltN_02 = Math.log(dblRsltN_02);
                dblRsltN_03 = Math.pow(dblRsltN_03, dblPower);

                System.out.println(df4places.format(dblRsltN_01) + "," + df4places.format(dblRsltN_02) + "," + df5places.format(dblRsltN_03));
            }catch(Exception e){
                System.out.println("NAN");
            }
        }
    }
}
