import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
public class WorkingWithDatesAndExceptionHandling {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputObject = new Scanner(System.in);
// We will fix the file name in the interest of time during debugging
        String strFileName = inputObject.next();  // Remember to escape the string in Windows machines
        File fileName = new File(strFileName);
        Scanner fileObject = new Scanner(fileName);
        String strFormatString = "dd/MM/yyy";
        String strMaintDueDate;
        String strLastMaintDate;
        double dblTimeInterval;
        SimpleDateFormat sdfFormat = new SimpleDateFormat(strFormatString);
        sdfFormat.setLenient(false);
        while(fileObject.hasNextLine()){
            String[] strRecords = fileObject.nextLine().split(",");
            //System.out.println(strRecords[0]);
            strMaintDueDate = strRecords[4];
            strLastMaintDate = strRecords[1];
            try{
                Date dateMaintDueDate = sdfFormat.parse(strMaintDueDate);
                Date dateLastMaintDate = sdfFormat.parse(strLastMaintDate);
                // If there is no error in the setting of date, the following lines of code will be executed
                dblTimeInterval = dateMaintDueDate.getTime() - dateLastMaintDate.getTime();
                System.out.printf("%.0f%n",dblTimeInterval / 1000 / 60 / 60 /24);
            }catch(Exception e){
                System.out.println("DATE ERROR");
            }
        }
    }
}
