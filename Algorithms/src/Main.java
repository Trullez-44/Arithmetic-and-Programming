//First, we must import the classes we will use.
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("""
                \u001B[32m====================================================
                Welcome to this program!""");
        // Instantiate the Scanner class after importing the library.
        Scanner scanner = new Scanner(System.in);
        //We run the main program in a different method so we can call it to start the program again.
        InitProgram(scanner);
        // Create a loop that allows the user to restart the program after it finishes.
        String menu;
        while(true){
            System.out.println("""
                    \u001B[32m====================================================
                    0. Start again.
                    1. Exit.
                    \u001B[0m""");

            menu = scanner.nextLine();
            if (menu.equals("1")){
                System.out.println("""
                        \u001B[32m====================================================
                        Program finished, good bye
                        ====================================================\u001B[0m""");
                break;
                }
            else if(menu.equals("0")){
                InitProgram(scanner);
            }
            else {
                System.out.println("""
                        \u001B[31mNot a valid input\u001B[0m, please try again""");
            }
        }
        // Close the scanner, it is good practice.
        scanner.close();
        System.exit(0);
    }
    private static void InitProgram(Scanner scanner) {
        Long numberInput = 0L;
        /*Read user's input*/
        // Create a while loop to validate and handle incorrect user input.
        while (true) {
            // Print instructions for the user.
            System.out.println("====================================================\u001B[0m");
            System.out.println("Please, type \u001B[32many number\u001B[0m between \u001B[32m1\u001B[0m and \u001B[32m 9,999,999,999,999 \u001B[0m");
            // Use try/catch to validate the user's input.
            // Declare a variable to store the user's input.
            try {
                String input = scanner.nextLine().trim();
                // Parse the input and check if it's a valid number.
                numberInput = Long.parseLong(input);
                // If the input is valid, exit the loop and continue.
                if  (!input.matches("\\d+")) {
                    System.out.println("\u001B[31mInvalid input\u001B[0m: Only numbers are allowed (no spaces, letters, or symbols).");
                    continue;}
                else if(numberInput > 0 && numberInput <= 9999999999999L)
                    break;
                // If not valid, prompt the user again.
                else {
                    System.out.println("\u001B[31mInvalid number\u001B[0m, please try again.");}
            } catch (InputMismatchException NotANumber) {
                // If the input is invalid or too large, display an error message and continue the loop.
                System.out.println("The input you entered \u001B[31m is not a number\u001B[0m, please try again.");
                scanner.reset();
            }
            catch (NumberFormatException notANumber){
                // If the input is invalid or too large, display an error message and continue the loop.
                System.out.println("\u001B[31mInvalid input\u001B[0m: Only numbers are allowed (no spaces, letters, or symbols).");
                scanner.reset();
            }
        }
        KnowTheLengthOfTheNumberEasy(numberInput);
        ReverseNumber(numberInput);}
    private static void KnowTheLengthOfTheNumberEasy(Long numberInput) {
        // Easiest way to get the number of digits.
        byte stringToLength = (byte) (numberInput.toString().length());
        System.out.println("The number contains "+stringToLength+" digits");
    }
    private static void ReverseNumber(Long numberInput) {
        String newString = "";
        char[] storageNumbers = numberInput.toString().toCharArray();
        // Build the reversed string by traversing the character array from end to start.
        for (int i = storageNumbers.length-1; i >= 0; i--) {
            newString = newString + storageNumbers[i] ;}
        // Print the original and reversed number.
        System.out.println("The number read is "+numberInput+", and reversed number is " + newString);
    }
}