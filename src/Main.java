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
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		window.setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dragon.setFuck();
		dragon.setDamage();
		dragon2.setFuck();
		tank.setFuck();
		tank2.setFuck();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dragon2.setFuck();
		tank.setDamage();
		//dragon.setDead();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tank.setDamage();
		
	}
}
