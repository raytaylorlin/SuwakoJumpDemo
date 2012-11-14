package Lib;

import java.util.Random;

public class RandomHelper {
    private static Random random = new Random(97);

    public static float getRandom() {
        return random.nextFloat();
    }

    public static int getRandom(int max){
        return random.nextInt(max);
    }

    public static int getRandom(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
