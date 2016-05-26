import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Wolf extends Warrior implements Runnable{
	private JFrame win;
	public Wolf t;
	
	public Wolf(String direction, JFrame w) {
		super(direction);
		//setBounds(1280, 720, 400, 250);
		// TODO Auto-generated constructor stub
		win=w;
		standIconLeft = new ImageIcon(Wolf.class.getClass().getResource("/WolfLeftStand.gif"));
		moveIconLeft = new ImageIcon(Wolf.class.getClass().getResource("/WolfLeftMove.gif"));
		fuckIconLeft = new ImageIcon(Wolf.class.getClass().getResource("/WolfLeftFuck.gif"));
		deadIconLeft = new ImageIcon(Wolf.class.getClass().getResource("/WolfLeftDead.gif"));
		damageIconLeft = new ImageIcon(Wolf.class.getClass().getResource("/WolfLeftDamage.png"));
		standIconRight = new ImageIcon(Wolf.class.getClass().getResource("/WolfRightStand.gif"));
		moveIconRight = new ImageIcon(Wolf.class.getClass().getResource("/WolfRightMove.gif"));
		fuckIconRight = new ImageIcon(Wolf.class.getClass().getResource("/WolfRightFuck.gif"));
		deadIconRight = new ImageIcon(Wolf.class.getClass().getResource("/WolfRightDead.gif"));
		damageIconRight = new ImageIcon(Wolf.class.getClass().getResource("/WolfRightDamage.png"));
		hp = 2;
		fkDistance = 50; 
		speed = 8;
		standTime = 1050;
		fuckTime = 2400;
		deadTime = 1200;
		damageTime = 1000;
	}


	public void run() {
		t = new Wolf(direction,win);
		win.add(t);
		t.summon();
		try {
			Thread.sleep(standTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMove();
	
		while(true){
		
			if(isMove)
				t.move();
		
			if(isDamage){
				System.out.println("1 "+t.location()+t.Xposition);
				//t.setLocation(t.Xposition,Yposition-30);
				System.out.println("2 "+t.location());
				t.damage();
				hp--;
				if(hp<=0){
					//t.setLocation(t.Xposition,Yposition-30);
					t.dead();
					t.setVisible(false);
					t=null;
					break;
				}
				//t.setLocation(t.Xposition,Yposition);
				setMove();
			}
		
			if(isFuck){
				if(t.direction.equals("left"))
					t.setLocation(t.Xposition-150,t.Yposition-40);
				else
					t.setLocation(t.Xposition,t.Yposition-40);
				t.fuck();
				t.setLocation(t.Xposition,t.Yposition);
				setMove();
			}
		
			if(isDead){
				t.dead();
				t.setVisible(false);
				t=null;
				break;
			}
		
		}
	}


}
