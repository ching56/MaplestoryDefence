import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Warrior extends JLabel implements Runnable{
	static final int Y_STAGE = 300;
	static final int X_STAGE_LEFT = 20;
	static final int X_STAGE_RIGHT = 1000;
	
	protected ImageIcon moveIconRight;
	protected ImageIcon deadIconRight;
	protected ImageIcon fuckIconRight;
	protected ImageIcon damageIconRight;
	protected ImageIcon standIconRight;
	protected ImageIcon moveIconLeft;
	protected ImageIcon deadIconLeft;
	protected ImageIcon fuckIconLeft;
	protected ImageIcon damageIconLeft;
	protected ImageIcon standIconLeft;
	
	protected int standTime;
	protected int deadTime;
	protected int fuckTime;
	protected int damageTime;
	
	public ImageIcon warriorIcon;
	
	public int Xposition;
	public int Yposition;
	
	public String direction;
	public int fkDistance;
	public int hp;
	public int speed;//per 500 ms
	public String state;
	
	
	protected boolean isMove;
	protected boolean isFuck;
	protected boolean isDamage;
	protected boolean isDead;
	
	
	public Warrior(String direction) {
		this.direction = direction;
		setBounds(1280, 720, 400, 250);
		if(direction.equals("right"))
			Xposition = X_STAGE_LEFT;
		else if (direction.equals("left"))
			Xposition = X_STAGE_RIGHT;
		else 
			System.out.println("Illegal direction.");
		Yposition=Y_STAGE;
		this.setLocation(Xposition,Yposition);
	}
	
	public void summon(){
		if(direction.equals("left")){
			setIcon(standIconLeft);
		}
		else{
			setIcon(standIconRight);
		}
		state = "stand";
		try {
			Thread.sleep(standTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void move(){
		try {
			//System.out.println("I'm fking moving");
			state = "move";
			if(direction.equals("left")){
				setIcon(moveIconLeft);
			}
			else{
				setIcon(moveIconRight);
			}
				Thread.sleep(150);//moveTime/moveFrame 150/5
				
				if(direction.equals("right")){
						Xposition = Xposition + speed;
				}else{
						Xposition = Xposition - speed;
					
				}
				if(Xposition<0)
					Xposition = 1000;
				if(Xposition>1280)
					Xposition=0;
				setLocation(Xposition, Yposition);
				//System.out.println(direction+" "+this.location());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	public void fuck(){
		try {
			
			state = "fuck";
			if(direction.equals("left")){
				setIcon(fuckIconLeft);
			}
			else{
				setIcon(fuckIconRight);
			}
			//System.out.println("*");
			Thread.sleep(fuckTime);
			//System.out.print("*");
			state = "move";

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	public void damage(){
		try {
			state = "damage";
			if(direction.equals("left")){
				setIcon(damageIconLeft);
			}
			else{
				setIcon(damageIconRight);
			}
			
			Thread.sleep(damageTime);
			state = "move";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	public void dead() {
		try {
			state = "dead";
			if(direction.equals("left")){
				setIcon(deadIconLeft);
			}
			else{
				setIcon(deadIconRight);
			}
			
			Thread.sleep(deadTime);
			state = "dead";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void setMove(){
		isMove = true;
		isDamage = false;
		isFuck = false;
		isDead = false;
	}
	
	public void setFuck(){
		isMove = false;
		isDamage = false;
		isFuck = true;
		isDead = false;
	}
	
	public void setDamage(){
		isMove = false;
		isDamage = true;
		isFuck = false;
		isDead = false;
	}
	
	public void setDead(){
		isMove = false;
		isDamage = false;
		isFuck = false;
		isDead = true;
	}
	
	public void run(){

	}
	
}
