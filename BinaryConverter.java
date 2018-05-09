import java.util.Scanner;

public class BinaryConverter {
    public static String reverseString(String number) {
        String newNumber = new StringBuilder(number).reverse().toString();
        return newNumber;
    }

    public static double toDecimal(String number) {
        int counter = 0;
        double finalSum = 0;
        for (char singleNumber : number.toCharArray()) {
            int realNumber = Character.getNumericValue(singleNumber);
            double math = realNumber * Math.pow(2, counter);
            finalSum += math;
            counter++;
        }
        return finalSum;
    }

    public static void main(String[] args) {
        Scanner binaryNumber = new Scanner(System.in);
        System.out.println("Your binary number: ");
        String number = binaryNumber.nextLine();
        // Reverts the number.
        String newNumber = reverseString(number);
        System.out.println(newNumber);

        double finalNumber = toDecimal(newNumber);
        System.out.println("Your binary number in decimal is: " + finalNumber);

        binaryNumber.close();
    }
}
