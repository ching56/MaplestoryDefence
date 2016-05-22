import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Animation {
private int speed;
private int frames;

private int index = 0;
private int count = 0;

private BufferedImage[] images;
private BufferedImage currentImg;

public static void main(String[] args){
	
	try {
		BufferedImage img = ImageIO.read(Animation.class.getClassLoader().getResource("stand/stand1.png"));
		BufferedImage img2 = ImageIO.read(Animation.class.getClassLoader().getResource("stand/stand2.png"));
		Animation dragon = new Animation(2,img,img2);
		JFrame Hello = new JFrame("dragon");
		dragon.runAnimation();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public Animation(int speed, BufferedImage... args){
    this.speed = speed;
    images = new BufferedImage[args.length];
    for(int i = 0; i < args.length; i ++){
        images[i] = args[i];
    }
    frames = args.length;
}

public Animation(int speed, boolean flip, BufferedImage... args) {
    if (flip) {
        this.speed = speed;
        images = new BufferedImage[(args.length * 2) - 2];
        for (int i = 0; i < args.length; i++) {
            images[i] = args[i];
        }
        BufferedImage[] temp = new BufferedImage[args.length - 2];
        for (int i = args.length - 2; i > 0; i--) {
            temp[args.length - i - 2] = images[i];
        }
        for (int i = args.length; i < images.length; i++) {
            images[i] = temp[i - args.length];
        }
        frames = images.length;
    }else{
        this.speed = speed;
        images = new BufferedImage[args.length];
        for (int i = 0; i < args.length; i++) {
            images[i] = args[i];
        }
        frames = args.length;
    }
}

public void runAnimation(){
    index ++;
    if(index > speed){
        index = 0;
        nextFrame();
    }
}

private void nextFrame(){
    for(int i = 0; i < frames; i ++){
        if(count == i)
            currentImg = images[i];
    }

    count ++;

    if(count >= frames)
        count = 0;
}

public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY){
    g.drawImage(currentImg, x, y, scaleX, scaleY, null);
}
}