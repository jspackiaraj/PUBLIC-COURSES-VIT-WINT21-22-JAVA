import java.util.Scanner;
public class GettingNumericInputFromUser {
    public static void main(String[] args) {
        Scanner inputObject = new Scanner(System.in);
        System.out.print("Enter the first number : ");
        int intA = inputObject.nextInt();
        System.out.print("Enter the next  number : ");
        int intB = inputObject.nextInt();
        System.out.print("Quotient of Division is: ");
        int intRslt = intA / intB;
        System.out.print (intRslt);
    }
}
