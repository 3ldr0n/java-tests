import java.util.Scanner;

public class BinaryConverter {
    public static String reverseString(String number) {
        for (int i = 0;i < number.length(); i++) {
            System.out.println(i);
        }
        return "a";
    }

    public static void main(String[] args) {
        try {
            Scanner binaryNumber = new Scanner(System.in);
            System.out.println("Your binary number: ");
            String number = binaryNumber.nextLine();

            System.out.println(number);

            reverseString(number);

        } catch (Exception e) {
            System.out.println("Invalid number.");
        }
    }
}
