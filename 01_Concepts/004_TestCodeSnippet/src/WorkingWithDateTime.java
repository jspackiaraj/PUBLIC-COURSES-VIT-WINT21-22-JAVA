import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
//Start your class name and include the following code in the method main
public class WorkingWithDateTime {
    public static void main(String[] args) throws ParseException {
        Scanner inputObject = new Scanner(System.in);
        double dblDistanceTravelled = inputObject.nextDouble();
        String strFormatString = "HH:mm:ss";
        String strStartTime = inputObject.next();
        String strEndTime = inputObject.next();

        Date dateStartTime = new SimpleDateFormat(strFormatString).parse(strStartTime);
        Date dateEndTime = new SimpleDateFormat(strFormatString).parse(strEndTime);

        double dblTimeInterval = dateEndTime.getTime() - dateStartTime.getTime();
        // Above line calculates the time in mili second.  Now, let us convert
        // the units of time and distance
        if (dblTimeInterval > 0.){
            dblDistanceTravelled = dblDistanceTravelled / 1000; //m to km
            dblTimeInterval = dblTimeInterval / 1000 / 60 / 60; // millisecond to hour
            System.out.println(dblDistanceTravelled / dblTimeInterval);
        }else{
            System.out.println("ERROR IN INPUT");
        }
// End your method main and your class here with }}.
    }
}
