// Abstract base class
abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract method (must be implemented by subclasses)
    public abstract void makeSound();

    // Concrete method (can be inherited as-is)
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// Subclass Dog extends abstract class Animal
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    // Implementation of abstract method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

// Subclass Cat extends abstract class Animal
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // Implementation of abstract method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// Main class to test the inheritance
public class InheritanceExample {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Whiskers");

        myDog.makeSound(); // Buddy says: Woof!
        myDog.sleep();     // Buddy is sleeping.

        myCat.makeSound(); // Whiskers says: Meow!
        myCat.sleep();     // Whiskers is sleeping.
    }
}

