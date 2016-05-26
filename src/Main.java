import javax.swing.*;

public class Main {
	public static void main(String [] args){
		JFrame window = new JFrame();
		window.setLayout(null);
		window.setSize(1280, 720);
		
		Dragon dragon = new Dragon("left",window);
		Thread thread1 = new Thread(dragon);
		Dragon dragon2 = new Dragon("right",window);
		Thread thread2 = new Thread(dragon2);
		Tank tank = new Tank("left", window);
		Thread thread3 = new Thread(tank);
		Tank tank2 = new Tank("right", window);
		Thread thread4 = new Thread(tank2);
		Green green = new Green("left",window);
		Thread thread5 = new Thread(green);
		Green green2 = new Green("right",window);
		Thread thread6 = new Thread(green2);
		Wolf wolf = new Wolf("left", window);
		Thread thread7 = new Thread(wolf);
		Wolf wolf2 = new Wolf("right", window);
		Thread thread8 = new Thread(wolf2);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread8.start();
		thread7.start();
		window.setVisible(true);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dragon.setFuck();
		
		dragon2.setFuck();
		tank.setFuck();
		tank2.setFuck();
		green.setFuck();
		green2.setFuck();
		wolf.setFuck();
		wolf2.setFuck();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dragon.setDamage();
		dragon2.setFuck();
		tank.setDamage();
		green.setDamage();
		green2.setDamage();
		wolf.setDamage();
		wolf2.setDamage();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tank.setDamage();
		green.setDamage();
		green2.setDamage();
		wolf.setDamage();
		
	}
}




//green dead 150x8
//green fuck 150x7
//green move 150x7
//green stand 500x2


//wolf dead 150x8
//wolf fuck 200
//wold move 250x4
//wolf stand 150x7
