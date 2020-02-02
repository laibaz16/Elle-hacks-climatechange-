//package Climate;

import java.applet.*; 
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
//import java.util.concurrent.TimeUnit;

public class Climate extends Applet implements Runnable, KeyListener   {
	private int x=20, y=300, xsp=130, ysp=350, tvx1=80, tvy1=80, tvx2=80, tvy2=80, fx1=80, fy1=80, fx2=80, fy2=80, applex2=80, appley2=80, applex1=80, appley1=80, canx1=50, cany1=80, canx2=50, cany2=80;
	private int bulbx1=50 , bulby1=80, bulbx2=50 , bulby2=80, binx1 =80, biny1=80, binx2=80, biny2=80, botx1=50, boty1=80, botx2=50, boty2=80;
	
	static private Image background;
	private Image girl;
	private Image turtle;
	private	Image apple, bin, bottle, bulb, can, fish, tv;

	private Image waterrun;
	
	static private int lives=3;
	static private String l = "Lives: " + lives;
	
	static JLabel life;
	static JFrame f=new JFrame();
	private int count=0;
	public void init() {
		setSize(1000,704);
		background= getImage(getCodeBase(),"seaimage.jpg");
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
		addKeyListener(this);
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		//life.setForgrount(color WHITE);
		
		 g.drawImage(background,0, 0,this);
		 
		 g.drawImage(girl,this.x,this.y,150,150,this);
		 
		 
		 g.drawImage(turtle,830,150,120,120,this);
		 g.drawImage(turtle,860,350,120,120,this);
		 g.drawImage(turtle,730,500,120,120,this);
		 

		 g.drawImage(bin,780,390, this.binx1, this.biny1, this);
		 g.drawImage(bin,750,150, this.binx2, this.biny2, this);
		 
		 g.drawImage(bottle,800,300, this.botx1, this.boty1, this);
		 g.drawImage(bottle,680,510, this.botx2, this.boty2, this);
		 
		 g.drawImage(bulb,740,250,this.bulbx1, this.bulby1, this);
		 g.drawImage(bulb,950,450, this.bulbx2, this.bulby2, this);

		 g.drawImage(can,800,600, this.canx1, this.cany1, this);
		 g.drawImage(can,700,200, this.canx2, this.cany2, this);
		 
		 g.drawImage(apple,920,300, this.applex1, this.appley1, this);
		 g.drawImage(apple,820,460, this.applex2, this.appley2, this);
		 
		 g.drawImage(fish,700,420, this.fx2, this.fy2, this);
		 g.drawImage(fish,880,110, this.fx1, this.fy1, this);
		 

		 g.drawImage(tv,850,270, this.tvx2, this.tvy2, this);
		 g.drawImage(tv,700,340, this.tvx1, this.tvy1, this);

		 g.drawImage(waterrun,this.xsp,this.ysp, 170, 10, this);
		 }
	

	  public void keyPressed (KeyEvent e)
	  {
		  int code =e.getKeyCode();
		  
		 
		  if (code == KeyEvent.VK_SPACE)
		    {
			  
			  for(int i= 0; i< 900; i++ )
			  {
					  this.xsp = this.xsp+1;
					  	
					      if(this.xsp + 130 >= 700 && this.xsp <=700+ this.tvx1 && this.ysp > 340 && this.ysp < 340 + this.tvy1)
						  {
							this.tvx1 =0 ;
							this.tvy1 = 0;
							this.count = this.count+1;
						
						  }
					      else if(this.xsp +130>= 850 && this.xsp <= 850 +this.tvx2 && this.ysp > 270 && this.ysp < 270 + this.tvy2)
						  {
							this.tvx2 =0 ;
							this.tvy2 = 0;
							this.count = this.count+1;
						  }
					      else if(this.xsp >= 700 && this.xsp<= 700 + this.fx2 && this.ysp >= 420 && this.ysp< 420+this.fy2)
					      {
					    	  this.fy2 =0;
					    	  this.fx2 =0;
					    	  this.count = this.count+1;
					      }
					      else if (this.xsp >= 880 && this.xsp<=880+this.fx1 && this.ysp >= 110 && this.ysp< 110+this.fy1)
					      {
					    	  this.fy1 =0;
					    	  this.fx1 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 920 && this.xsp<=920+this.applex1 && this.ysp >= 300 && this.ysp <= 300 + this.appley1)
					      {
					    	  this.appley1 =0;
					    	  this.applex1 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 820 && this.xsp<=820+this.applex2 && this.ysp >= 460 && this.ysp <= 460 + this.appley2)
					      {
					    	  this.appley2 =0;
					    	  this.applex2 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 800 && this.xsp<=800+this.canx1 && this.ysp >= 600 && this.ysp<=600+cany1 )
					      {
					    	  this.cany1 =0;
					    	  this.canx1 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 700 && this.xsp<=700+this.canx2 && this.ysp >= 200 && this.ysp<=200+cany2 )
					      {
					    	  this.cany2 =0;
					    	  this.canx2 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 950 && this.xsp <= 950+bulbx2 && this.ysp >= 450 && this.ysp<=450+bulby2 )
					      {
					    	  this.bulby2 =0;
					    	  this.bulbx2 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 740 && this.xsp<= 740 +this.bulbx1 && this.ysp >= 250 && this.ysp<=250+bulby1 )
					      {
					    	  this.bulby1 =0;
					    	  this.bulbx1 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 800 && this.xsp <= this.botx1 + 800 && this.ysp >= 300 && this.ysp<=300+boty1 )
					      {
					    	  this.botx1 =0;
					    	  this.boty1 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 680 && this.xsp<=680+botx2&& this.ysp >= 510 && this.ysp<=510+boty2 )
					      {
					    	  this.botx2 =0;
					    	  this.boty2 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 780 && this.xsp<= this.xsp+780 && this.ysp >= 390 && this.ysp<=390+biny1 )
					      {
					    	  this.binx1 =0;
					    	  this.biny1 =0;
					    	  this.count = this.count+1;
					      }
					      else if(this.xsp>= 750 && this.xsp <= this.binx2 + 750 && this.ysp >= 150 && this.ysp<=150+biny2 )
					      {
					    	  this.binx2 =0;
					    	  this.biny2 =0;
					    	  this.count = this.count+1;
					      }
					      else if((this.xsp >= 830 && this.ysp >= 150 && this.ysp <= 270) || (this.xsp+170>= 860 && this.ysp >= 350 && this.ysp <= 470) || (this.xsp +170>= 730 && this.ysp >= 500 && this.ysp<=620))
					      {
					    	//  this.lives = this.lives-1;
					      }
					     
			  }
			  
			  if(this.count == 14)
			  {

					String winner = "Congratulations you saved all the turtles";  
			  }
			  
			  this.xsp = 130;
			  this.ysp = this.y+50;  
			  
			  repaint();
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

	  public void keyReleased (KeyEvent e){}   
	  
	  public void keyTyped(KeyEvent e){}  

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

	public static void main(String args[]) {
		
	//	life = new JLabel(l);
		
		f.add(life);
//		f.setVisible(true);
		 Font font = new Font("Verdana", Font.BOLD, 40);
	//	   g.setFont(font);
		 System.out.println("working");
		 
		life = new JLabel(l);
	//	background.add(life);
		life.add(new JTextField(l));
		//life.setBounds(700, 50, 100, 80);
		life.setForeground(Color.RED);
		life.setFont(font);
		life.setBackground(Color.BLACK);
		Climate t = new Climate();
	//	t.setSize(1000,704);
		t.setVisible(true);
		//t.pack();
	}

	
		
}
