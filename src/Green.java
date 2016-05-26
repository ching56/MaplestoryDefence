import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Green extends Warrior implements Runnable{
	private JFrame win;
	public Green t;
	
	public Green(String direction, JFrame w) {
		super(direction);
		// TODO Auto-generated constructor stub
		win=w;
		standIconLeft = new ImageIcon(Green.class.getClass().getResource("/GreenLeftStand.gif"));
		moveIconLeft = new ImageIcon(Green.class.getClass().getResource("/GreenLeftMove.gif"));
		fuckIconLeft = new ImageIcon(Green.class.getClass().getResource("/GreenLeftFuck.gif"));
		deadIconLeft = new ImageIcon(Green.class.getClass().getResource("/GreenLeftDead.gif"));
		damageIconLeft = new ImageIcon(Green.class.getClass().getResource("/GreenLeftDamage.png"));
		standIconRight = new ImageIcon(Green.class.getClass().getResource("/GreenRightStand.gif"));
		moveIconRight = new ImageIcon(Green.class.getClass().getResource("/GreenRightMove.gif"));
		fuckIconRight = new ImageIcon(Green.class.getClass().getResource("/GreenRightFuck.gif"));
		deadIconRight = new ImageIcon(Green.class.getClass().getResource("/GreenRightDead.gif"));
		damageIconRight = new ImageIcon(Green.class.getClass().getResource("/GreenRightDamage.png"));
		hp = 2;
		fkDistance = 20; 
		speed = 4;
		standTime = 1000;
		fuckTime = 1050;
		deadTime = 1200;
		damageTime = 1000;
	}


	public void run() {
		t = new Green(direction,win);
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
				t.setLocation(t.Xposition,Yposition-30);
				System.out.println("2 "+t.location());
				t.damage();
				hp--;
				if(hp<=0){
					t.setLocation(t.Xposition,Yposition-30);
					t.dead();
					t.setVisible(false);
					t=null;
					break;
				}
				t.setLocation(t.Xposition,Yposition);
				setMove();
			}
		
			if(isFuck){
				//if(t.direction.equals("left"))
					//t.setLocation(t.Xposition-100,t.Yposition-20);
				//else
					//t.setLocation(t.Xposition,t.Yposition-20);
				t.fuck();
				//t.setLocation(t.Xposition,t.Yposition);
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
