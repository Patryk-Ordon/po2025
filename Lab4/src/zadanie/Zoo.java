package zadanie;

import animals.*;

import java.util.Random;

public class Zoo {
    Animal[] animals = new Animal[100];

    public Zoo() {
        for (int i = 0; i < 100; i++) {
            int random = new Random().nextInt() % 3;
            switch (Math.abs(random)) {
                case 0:
                    animals[i] = new Snake("Snake "+i);
                    break;
                case 1:
                    animals[i] = new Parrot("Parrot "+i);
                    break;
                case 2:
                    animals[i] = new Dog("Dog "+i);
                    break;
            }
            animals[i].getDescription();
        }
    }

    public int sumLegs() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += animals[i].getLegs();
        }
        return sum;
    }
}