package animals;

public class Parrot extends Animal {
    public Parrot(String newName) {
        name = newName;
        legs = 2;
    }

    @Override
    public String getDescription() {
        return "Parrot";
    }

    @Override
    public void makeSound() {
        System.out.println("DźwiękPapugi.mp3");
    }
}
