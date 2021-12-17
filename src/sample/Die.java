package sample;

import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


import java.util.Random;

public class Die {
    private Random random = new Random();
    private int numberOfFaces = 6;
    private int faceValue;
    private ImageView diceFaceImage;
    private ImageView dice_image1;
    private ImageView dice_image2;
    private ImageView dice_image3;
    private ImageView dice_image4;
    private ImageView dice_image5;
    private ImageView dice_image6;

    public Die(int numberOfFaces,ImageView diceFaceImage, ImageView dice_image1, ImageView dice_image2, ImageView dice_image3, ImageView dice_image4, ImageView dice_image5, ImageView dice_image6) {
        this.numberOfFaces = numberOfFaces;
        this.numberOfFaces = 6;
        this.diceFaceImage = diceFaceImage;
        this.dice_image1 = dice_image1;
        this.dice_image2 = dice_image2;
        this.dice_image3 = dice_image3;
        this.dice_image4 = dice_image4;
        this.dice_image5 = dice_image5;
        this.dice_image6 = dice_image6;
    }

    RotateTransition rotate = new RotateTransition();

    public void roll(){
        this.faceValue = random.nextInt(numberOfFaces) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setDiceFaceImage(int faceValue){
        if (faceValue == 1) {
            diceFaceImage.setImage(dice_image1.getImage());
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(360);
            rotate.setDuration(Duration.millis(1000));
            rotate.setNode(diceFaceImage);
            rotate.setCycleCount(1);
            rotate.play();
        } else if (faceValue == 2) {
            diceFaceImage.setImage(dice_image2.getImage());
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(360);
            rotate.setDuration(Duration.millis(1000));
            rotate.setNode(diceFaceImage);
            rotate.setCycleCount(1);
            rotate.play();
        } else if (faceValue == 3) {
            diceFaceImage.setImage(dice_image3.getImage());
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(360);
            rotate.setDuration(Duration.millis(1000));
            rotate.setNode(diceFaceImage);
            rotate.setCycleCount(1);
            rotate.play();
        } else if (faceValue == 4) {
            diceFaceImage.setImage(dice_image4.getImage());
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(360);
            rotate.setDuration(Duration.millis(1000));
            rotate.setNode(diceFaceImage);
            rotate.setCycleCount(1);
            rotate.play();
        } else if (faceValue == 5) {
            diceFaceImage.setImage(dice_image5.getImage());
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(360);
            rotate.setDuration(Duration.millis(1000));
            rotate.setNode(diceFaceImage);
            rotate.setCycleCount(1);
            rotate.play();
        } else if (faceValue == 6) {
            diceFaceImage.setImage(dice_image6.getImage());
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(360);
            rotate.setDuration(Duration.millis(1000));
            rotate.setNode(diceFaceImage);
            rotate.setCycleCount(1);
            rotate.play();
        }
    }
}