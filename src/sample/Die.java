package sample;

import java.util.Random;

public class Die {
    private Random random = new Random();
    private int numberOfFaces = 6;
    private int faceValue;

    public void roll(){
        faceValue = random.nextInt(numberOfFaces) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
