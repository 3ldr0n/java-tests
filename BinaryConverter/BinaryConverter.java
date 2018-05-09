import java.util.Scanner;

class doubleBinaryConverter {
    private String binaryNumber;
    public double finalNumber = 0;
    private String floatPart;
    private String integerPart;

    public doubleBinaryConverter(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public void setBinaryNumber(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public void revertString() {
        String newNumber = new StringBuilder(this.binaryNumber).reverse().toString();
        setBinaryNumber(newNumber);
    }

    public void splitNumber() {
        String integerPart = this.binaryNumber.split("\\.")[1];
        String floatPart = this.binaryNumber.split("\\.")[0];
        this.integerPart = integerPart;
        this.floatPart = floatPart;
    }

    public double convertNumber() {
        int counter = 0 - this.floatPart.length();

        for (char singleNumber : this.floatPart.toCharArray()) {
            double realNumber = Character.getNumericValue(singleNumber);
            double math = realNumber * Math.pow(2, counter);
            this.finalNumber += math;
            counter++;
        }
        counter = 0;
        for (char singleNumber : this.integerPart.toCharArray()) {
            double realNumber = Character.getNumericValue(singleNumber);
            double math = realNumber * Math.pow(2, counter);
            this.finalNumber += math;
            counter ++;
        }
        return this.finalNumber;
    }

}

class IntegerBinaryConverter {
    private String binaryNumber;
    public double finalNumber;

    public IntegerBinaryConverter(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public void setBinaryNumber(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public void revertString() {
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

        doubleBinaryConverter converter = new doubleBinaryConverter(number);
        converter.revertString();
        converter.splitNumber();
        double finalNumber = converter.convertNumber();
        System.out.println("Final number is: " + finalNumber);

        /*
        IntegerBinaryConverter converter = new IntegerBinaryConverter(number);
        converter.revertString();

        double finalNumber = converter.toDecimal();
        System.out.println("Your binary number in decimal is: " + finalNumber);
        */

        binaryNumber.close();
    }
}
