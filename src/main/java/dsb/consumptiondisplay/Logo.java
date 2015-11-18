package dsb.consumptiondisplay;

import java.util.Observable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Jim on 11/18/2015.
 *
 * @author Jim
 * @version 1.0
 * @since 11/18/2015
 */
public class Logo extends Observable {

    BufferedImage image;
    int x;
    int y;

    public Logo(BufferedImage image, int x, int y, DisplayRttN displayRttN) {
        this.image = image;
        this.x = x;
        this.y = y;
        addObserver(displayRttN);
    }

    public void move() {
        if (x < 742) {
            x = 1760;
        } else {
            x -= 10;
        }
        notifyObservers();
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
