import java.util.Scanner;
public class ArrayWithIfLadder {
    static float fltPassMarkForSubject = 40.F;
    static float fltPassMarkForPromotion = 50.F;
    static float fltMaxPossibleMarks = 100.F;
    public static void  main(String [] args){
        // Declaring Variables
        // New Scanner object to get input from user
        Scanner inputObject = new Scanner(System.in);
        // Declaring a variable to hold the number of subjects
        int intNoOfSubs;
        // Declaring a variable to store if the student has failed in
        // a subject
        boolean isFailInSubject = false;
        // Declaring and initializing the string which will give output
        String strFailedSubjectsString = "Failed in ";
        //
        // PROGRAM STARTS HERE
        // Get the number of subjects to work with.
        System.out.print("Enter the number of subjects to work with : ");
        intNoOfSubs = inputObject.nextInt();
        // Declare an array of floating points to store the marks
        float [] fltArrOfMarks = new float[intNoOfSubs];
        float fltSumOfSubjects = 0.F;
        // Loop over and assign marks to the array
        for (int intI = 0; intI < intNoOfSubs; intI++){
            System.out.printf("Enter the mark in subject %d : ", (intI + 1));
            // Create a variable to print an error message if the mark entered
            // is greater than the mark received
            int intJ = 0;
            // Do not pass the block till valid mark is received
            do {
                if (intJ > 0){
                    System.out.println("Please enter a valid grade less than " + fltMaxPossibleMarks);
                }
                fltArrOfMarks[intI] = inputObject.nextFloat();
                intJ++;
            } while(fltArrOfMarks[intI] > fltMaxPossibleMarks);
            // Add the marks received from user to the variable fltSumOfSubjects
            fltSumOfSubjects += fltArrOfMarks[intI];
            // IF student gets less than Mark to pass a subject
            // make a note of the subject
            if (fltArrOfMarks[intI] < fltPassMarkForSubject){
                isFailInSubject = true;
                strFailedSubjectsString += "Subject " + (intI +1) + ", ";
            }
        } // All the marks would have been got if this line is crossed
        //
        //Compute the average
        // DO the if ladder according to the problem requirement
        float fltAvg = fltSumOfSubjects / intNoOfSubs;
        if (isFailInSubject){
            System.out.println(strFailedSubjectsString);
        }
        else if (fltAvg < fltPassMarkForPromotion){
            System.out.printf("Student has failed to secure %f %% and is detained.\n", fltPassMarkForPromotion);
        }
        else{
            System.out.println("Congratulations, the student has been promoted to the next class");
        }
        System.out.println("Average Marks Secured " + fltAvg);

    }
}
