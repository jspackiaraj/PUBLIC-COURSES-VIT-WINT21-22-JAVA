import java.util.Scanner;
public class ArrayWithIfLadder {
    static float fltPassMarkForSubject = 40.F;
    static float fltPassMarkForPromotion = 50.F;
    static float fltMaxPossibleMarks = 100.F;
    public static void  main(String [] args){
        Scanner inputObject = new Scanner(System.in);
        int intNoOfSubs;
        boolean isFailInSubject = false;
        String strFailedSubjectsString = "Failed in ";
        System.out.print("Enter the number of subjects to work with : ");
        intNoOfSubs = inputObject.nextInt();
        float [] fltArrOfMarks = new float[intNoOfSubs];
        float fltSumOfSubjects = 0.F;
        for (int intI = 0; intI < intNoOfSubs; intI++){
            System.out.printf("Enter the mark in subject %d : ", (intI + 1));
            int intJ = 0;
            do {
                if (intJ > 0){
                    System.out.println("Please enter a valid grade less than " + fltMaxPossibleMarks);
                }
                fltArrOfMarks[intI] = inputObject.nextFloat();
                intJ++;
            } while(fltArrOfMarks[intI] > fltMaxPossibleMarks);
            fltSumOfSubjects += fltArrOfMarks[intI];
            if (fltArrOfMarks[intI] < fltPassMarkForSubject){
                isFailInSubject = true;
                strFailedSubjectsString += "Subject " + (intI +1) + ", ";
            }
        }
        float fltAvg = fltSumOfSubjects / intNoOfSubs;
        if (isFailInSubject){
            System.out.println(strFailedSubjectsString);
        }
        else if (fltAvg < fltPassMarkForPromotion){
            System.out.printf("Student has failed to secure %f % and is detained.\n", fltPassMarkForPromotion);
        }
        else{
            System.out.println("Congratulations, the student has been promoted to the next class");
        }
        System.out.println("Average Marks Secured " + fltAvg);

    }
}
