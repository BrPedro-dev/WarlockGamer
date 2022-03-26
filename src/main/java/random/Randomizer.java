package random;

import java.util.Random;

public class Randomizer {

    private static final Random RANDOM = new Random();

    private Randomizer()
    {}

    public static Integer getValue(Integer range){
        return RANDOM.nextInt(range);
    }
}
