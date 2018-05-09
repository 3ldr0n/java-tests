abstract class Animal {
    public int numberOfLegs;
    public String color;

    abstract void eat();
    abstract void makeSound();
}

class Cat extends Animal {
    public int numberOfLegs = 4;
    public String color = "black";

    public void eat() {
        System.out.println("Cat eating...");
    }

    public void makeSound() {
        System.out.println("Meow... ");
    }
}

class Dog extends Animal {
    public int numberOfLegs = 4;
    public String color = "white";

    public void eat() {
        System.out.println("Dog eating...");
    }

    public void makeSound() {
        System.out.println("Woof... ");
    }
}

public class Polymorphism {
    public static void main (String[] args) {
        Animal myCat = new Cat();
        Animal myDog = new Dog();
        Cat mySecondCat = new Cat();
        Dog mySecondDog = new Dog();

        System.out.println("The cat has " + mySecondCat.numberOfLegs + " legs.");
        System.out.println("Color: " + mySecondCat.color);
        
        mySecondCat.eat();
        myDog.eat();
        myCat.makeSound();
    }
}
