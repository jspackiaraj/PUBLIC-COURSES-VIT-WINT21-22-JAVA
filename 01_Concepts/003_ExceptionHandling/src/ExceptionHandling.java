import java.util.Scanner;
import java.util.InputMismatchException;
public class ExceptionHandling {
    public static void main(String[] args) {
        // INITIALIZE ALL THE VARIABLES
        int intNumberOfWrongAttempts = 0;
        int intMaxNumberOfWrongAttempts = 5;
        int intA = 0, intB=0;
        boolean boolProgramExecutionInComplete = true; // We will set this to true only after both the input are right
// The input is going to be got using an exit controlled loop
        boolean boolFirstNumberIsWrong = true;
        boolean boolSecondNumberIsWrong = true;
        Scanner inputObject = new Scanner(System.in);
        do{
            try{
                if (boolFirstNumberIsWrong){
                    System.out.print("Enter the first number : ");
                    intA = inputObject.nextInt();
                }
                // If this point is reached, the first number is correct
                boolFirstNumberIsWrong = false;
                if (boolSecondNumberIsWrong){
                    System.out.print("Enter the next  number : ");
                    intB = inputObject.nextInt();
                }
                // If this point is reached, the first number is correct
                boolSecondNumberIsWrong = false;
                // Java can compute 'Infinity', the following code does not cause error
                double dblRslt = (double)intA / intB; //explicit type casting is done, so that fractions get printed
                System.out.print("Quotient of Division (as double) is : ");
                System.out.println(dblRslt);
                // This case causes an / by zero' error, requiring error handling
                int intRslt = intA / intB; //explicit type casting is done, so that fractions get printed
                System.out.print("Quotient of Division (as integer) is: ");
                System.out.println(intRslt);

                boolProgramExecutionInComplete = false;
            } // This is the end of the try block.  Catch block should follow immediately

            catch(InputMismatchException e){// Different convention can be used, I use e for error
                System.err.printf("It is expected that the input which is received by the system is an integer.%n");
                intNumberOfWrongAttempts++;
                inputObject.nextLine(); // The input is cleared so that
                if (intNumberOfWrongAttempts >= intMaxNumberOfWrongAttempts) {
                    boolProgramExecutionInComplete = false;
                } else{
                    System.out.printf("You have %d attempts remaining.%n", intMaxNumberOfWrongAttempts - intNumberOfWrongAttempts);
                }
            } // This is the end of the first catch block

            catch(ArithmeticException e){// This block caches the Arithmetic exceptions
                System.err.printf("Zero causes an errror, enter a non-zero integer.%n");
                intNumberOfWrongAttempts++;
                inputObject.nextLine(); // The input is cleared so that
                if (intNumberOfWrongAttempts >= intMaxNumberOfWrongAttempts) {
                    boolProgramExecutionInComplete = false;
                } else{
                    System.out.printf("You have %d attempts remaining.%n", intMaxNumberOfWrongAttempts - intNumberOfWrongAttempts);
                    boolSecondNumberIsWrong = true; // This is to make the code receive values in the second number
                }
            }
        }while(boolProgramExecutionInComplete);
        if(intNumberOfWrongAttempts < intMaxNumberOfWrongAttempts){
            System.out.print("Program executed successfully ...");
        } else {
            System.out.printf("Program exited as %d attempts in input was exceeded ...", intMaxNumberOfWrongAttempts);
        }
    }

}
