import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Dragon extends Warrior implements Runnable{

	private JFrame win;
	public Dragon d;
	
	public Dragon(String direction, JFrame w) {
		//seticon,frame,hp,fkdistance,speed
		super(direction);
		win=w;
		standIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/DragonLeftStand.gif"));
		moveIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/DragonLeftMove.gif"));
		fuckIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/DragonLeftFuck.gif"));
		deadIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/DragonLeftDead.gif"));
		damageIconLeft = new ImageIcon(Dragon.class.getClass().getResource("/DragonLeftDamage.gif"));
		standIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightStand.gif"));
		moveIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightMove.gif"));
		fuckIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightFuck.gif"));
		deadIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightDead.gif"));
		damageIconRight = new ImageIcon(Dragon.class.getClass().getResource("/DragonRightDamage.gif"));
		hp = 1;
		fkDistance = 30; 
		speed = 10;
		standTime = 500;
		fuckTime = 750;
		deadTime = 900;
		damageTime = 1500;
	}
	
	public void run() {
		d = new Dragon(direction,win);
		win.add(d);
		d.summon();
		setMove();
		
		while(true){
			
			if(isMove)
				d.move();
			
			if(isDamage){
				d.damage();
				hp--;
				if(hp<=0){
					d.dead();
					d.setVisible(false);
					d=null;
					break;
				}
				setMove();
			}
			
			if(isFuck){
				d.fuck();
				setMove();
			}
			
			if(isDead){
				d.dead();
				d.setVisible(false);
				d=null;
				break;
			}
			
		}
	}

	
}
