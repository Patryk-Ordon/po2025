package animals;

public class Dog extends Animal {
    public Dog(String newName) {
        name = newName;
        legs = 4;
    }

    @Override
    public String getDescription() {
        return "Dog";
    }

    @Override
    public void makeSound() {
        System.out.println("HauHau Hau");
    }
}
