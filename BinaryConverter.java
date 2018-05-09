import java.util.Scanner;

class IntegerBinaryConverter {
    private String binaryNumber;
    public double finalNumber;

    public IntegerBinaryConverter(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public void setBinaryNumber(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public void reverseString() {
        String newNumber = new StringBuilder(this.binaryNumber).reverse().toString();
        setBinaryNumber(newNumber);
    }

    public double toDecimal() {
        int counter = 0;
        double finalSum = 0;
        for (char singleNumber : this.binaryNumber.toCharArray()) {
            int realNumber = Character.getNumericValue(singleNumber);
            double math = realNumber * Math.pow(2, counter);
            finalSum += math;
            counter++;
        }
        this.finalNumber = finalSum;
        return this.finalNumber;
    }
}

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner binaryNumber = new Scanner(System.in);
        System.out.println("Your binary number: ");
        String number = binaryNumber.nextLine();

        // Reverts the number.
        IntegerBinaryConverter converter = new IntegerBinaryConverter(number);
        converter.reverseString();

        double finalNumber = converter.toDecimal();
        System.out.println("Your binary number in decimal is: " + finalNumber);

        binaryNumber.close();
    }
}
