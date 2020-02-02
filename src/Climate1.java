
//package turtle;
import java.applet.*; 
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument.Iterator;
//import java.util.concurrent.TimeUnit;

public class Climate1 extends Applet implements Runnable, KeyListener {
	private List<Target> targets = new ArrayList<>();
	private int x=20, y=300, xsp=130, ysp=350;
	
	static private Image background;
	private Image girl;
	private Image turtle;
	private	Image apple, bin, bottle, bulb, can, fish, tv;
	private Image waterrun;
	
	private int start=0, w=210,h=330, a=300, b=360;
	String welcome = "Welcome to Turtle Troopers!";
	String press="Press Space to Start!";
	Font font = new Font("Serif",Font.BOLD,40);
	Font font1 = new Font("Serif",Font.BOLD,30);

	static private int lives=3;
	static private String l = "Lives: " + lives;
	
	static JLabel life;
	static JFrame f=new JFrame();
	private int count=0;
	public void init() {
		setSize(1000,704);
		
		background = getImage(getCodeBase(),"seaimage.jpg");
		girl = getImage(getCodeBase(),"girl.png");
		turtle = getImage(getCodeBase(),"turtle.png");
		apple = getImage(getCodeBase(),"apple.png");
		bin = getImage(getCodeBase(),"bin.png");
		bottle = getImage(getCodeBase(),"bottle.png");
		bulb = getImage(getCodeBase(),"bulb.png");
		can = getImage(getCodeBase(),"can.png");
		fish = getImage(getCodeBase(),"fish.png");
		tv = getImage(getCodeBase(),"tv.png");
		waterrun = getImage(getCodeBase(), "waterrun.png");
		
		targets.add(new Target(80, 80, 780, 390, bin));
		targets.add(new Target(80, 80, 750, 150, bin));
		
		targets.add(new Target(80,50, 680, 510, bottle));
		targets.add(new Target(80,50, 800, 300, bottle));
		
		targets.add(new Target(80,50, 740, 250, bulb));
		targets.add(new Target(80,50, 950, 450, bulb));
		
		targets.add(new Target(80,50, 700, 200, can));
		targets.add(new Target(80,50, 800, 600, can));
		
		targets.add(new Target(80, 80, 820, 460, apple));
		targets.add(new Target(80, 80, 920, 300, apple));
		
		targets.add(new Target(80, 80, 700, 420, fish));
		targets.add(new Target(80, 80, 880, 110, fish));
		
		targets.add(new Target(80, 80, 700, 340, tv));
		targets.add(new Target(80, 80, 850, 270, tv));
		
		targets.sort((d1, d2) -> {
			return d1.x - d2.x; 
		});
		
		addKeyListener(this);
	}
	

	public void paint(Graphics g) {
		
		super.paint(g);
	
		 g.drawImage(background,0, 0,this);
		 g.drawImage(girl,this.x,this.y,150,150,this);
		 g.drawImage(waterrun, this.xsp, this.ysp, 170, 40, this);
		 g.drawImage(turtle,830,150,120,120,this); 
		 g.drawImage(turtle,860,350,120,120,this);
		 g.drawImage(turtle,730,500,120,120,this);
		 
		 g.setFont(font);
		 g.setColor(Color.WHITE);
		 g.drawString(welcome,this.w,this.h);
		 g.setFont(font1);
		 g.drawString(press,this.a,this.b);


		 targets.forEach((item) -> {
			 g.drawImage(item.img, item.x, item.y, item.width, item.height, this);
		 });
		 
		 if(targets.size() == 0)
		  {
				String winner = "Congratulations you saved all the turtles!!";  
				g.setFont(font);
				g.setColor(Color.WHITE);
				g.drawString(winner, 180, 350);
		  }
		  
		 }
	

	  public void keyPressed (KeyEvent e)
	  {
		  int code =e.getKeyCode();
		 
		  if (code == KeyEvent.VK_SPACE)
		    {
			  if(start==0) {
				  this.w=0;
				  this.h=0;
				  this.a=0;
				  this.b=0;
				  start+=1;
			  }
			  else {
			  java.util.Iterator<Target> it = targets.iterator();
			  int i = 0;
			  while(it.hasNext()) {
				  Target target = it.next();
				  if (this.ysp > target.y && this.ysp < (target.y + target.height)) {
					  targets.remove(i);
					  break;
				  }
				  i++;
			  	}
			  
			  this.xsp = 130;
			  this.ysp = this.y+50;  
			  
			  repaint();
			  }
			  
	//		  }
		    
	  
		//	  else {
				 /// life = "Opps no lives left try again";
		//.out.println("stop");
	//			  repaint();
	//		  }
		//
		///	  repaint();
			   
		    }
			  
		    
		  else if (code == KeyEvent.VK_UP) 
		    {
			  if(this.y > 100 ) {
				  this.y = this.y-5;
				  this.ysp = this.ysp -5;
			  }
		    }
		  
		  else if (code == KeyEvent.VK_DOWN) 
		    {
			  if(this.y > 95 && this.y<570) {
				  this.y = this.y+5;
				  this.ysp = this.ysp + 5;
			  }
		    }
		  repaint();
	  }


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

	public static void main(String args[]) {
		Climate t = new Climate();
	//	t.setSize(1000,704);
		t.setVisible(true);
		//t.pack();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

