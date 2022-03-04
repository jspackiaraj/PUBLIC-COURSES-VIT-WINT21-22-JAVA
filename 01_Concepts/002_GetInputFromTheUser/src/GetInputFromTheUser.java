import java.util.Scanner;
public class GetInputFromTheUser{
    public static void main(String[] args){
        Scanner inputObject = new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        int intA;
        intA = inputObject.nextInt();
        System.out.print("The Entered number is : " + intA + "\n");
        System.out.printf("The Entered number is : %d\n", intA);
        //
        System.out.print("Enter a Floating Point: ");
        float fltA;
        fltA = inputObject.nextFloat();
        System.out.printf("The Entered number is : %f\n", fltA);
        //
        System.out.print("Enter your name: ");
        String strA;
        strA = inputObject.next();
        System.out.printf("Your name : %s\n", strA);
        System.out.printf("Hi \"%s\"\nYou entered the integer %d, and the float %.3f", strA, intA, fltA);

    }
}