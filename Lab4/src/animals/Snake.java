package animals;

public class Snake extends Animal {
    public Snake(String newName) {
        name = newName;
        legs = 0;
    }

    @Override
    public String getDescription() {
        return "Snake";
    }
}
