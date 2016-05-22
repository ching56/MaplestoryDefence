import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Tank extends Warrior implements Runnable{
	private JFrame win;
	public Tank t;
	
	public Tank(String direction, JFrame w) {
		super(direction);
		// TODO Auto-generated constructor stub
		win=w;
		standIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/TankLeftStand.gif"));
		moveIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/TankLeftMove.gif"));
		fuckIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/TankLeftFuck.gif"));
		deadIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/TankLeftDead.gif"));
		damageIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/TankLeftDamage.png"));
		standIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightStand.gif"));
		moveIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightMove.gif"));
		fuckIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightFuck.gif"));
		deadIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightDead.gif"));
		damageIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightDamage.gif"));
		
		hp = 2;
		fkDistance = 45; 
		speed = 5;
		standTime = 600;
		fuckTime = 1800;
		deadTime = 750;
		damageTime = 500;
	}

	public void run() {
		t = new Tank(direction,win);
		win.add(t);
		t.summon();
		setMove();
	
		while(true){
		
			if(isMove)
				t.move();
		
			if(isDamage){
				System.out.println("1 "+t.location()+t.Xposition);
				t.setLocation(t.Xposition,Yposition-50);
				System.out.println("2 "+t.location());
				t.damage();
				hp--;
				if(hp<=0){
					t.setLocation(t.Xposition,Yposition-50);
					t.dead();
					t.setVisible(false);
					t=null;
					break;
				}
				t.setLocation(t.Xposition,Yposition);
				setMove();
			}
		
			if(isFuck){
				t.setLocation(t.Xposition-100,t.Yposition-20);
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
