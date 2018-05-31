import java.util.Scanner;

class DoubleBinaryConverter {
    private String binaryNumber;
    public double finalNumber = 0;
    private String floatPart;
    private String integerPart;

    public DoubleBinaryConverter(String binaryNumber) {
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
            counter++;
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
    public static boolean isDouble(String number) {
        try {
            double doubleNumber = Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String number) {
        try {
            int intNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner binaryNumber = new Scanner(System.in);
        System.out.println("Your binary number: ");
        String number = binaryNumber.nextLine();

        while (!isInteger(number) && !isDouble(number)) {
            binaryNumber = new Scanner(System.in);
            System.out.println("Your binary number: ");
            number = binaryNumber.nextLine();
            
        }

        if (isInteger(number)) {
            IntegerBinaryConverter converter = new IntegerBinaryConverter(number);
            converter.revertString();

            double finalNumber = converter.toDecimal();
            System.out.println("Your binary number in decimal is: " + finalNumber);
        } else if (isDouble(number)) {
            DoubleBinaryConverter converter = new DoubleBinaryConverter(number);
            converter.revertString();
            converter.splitNumber();
            double finalNumber = converter.convertNumber();
            System.out.println("Final number is: " + finalNumber);
        } else {
            System.out.println("That's not a number");
        }

        binaryNumber.close();
    }
}
