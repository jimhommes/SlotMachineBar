package dsb.consumptiondisplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardRttN extends JPanel {
	
	private ConsumptionDisplayModel model;
	private boolean init = false;
	private String path = "C:/Users/Jim/Desktop/SubJava/";
	
	public BoardRttN(ConsumptionDisplayModel m) {
		model = m;
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		//Rendering hints (make it smooth) 
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(rh);
		
		
		//Init
		if(!init) {
			//Draw background
			g2.setColor(Color.cyan);
			for(int i = 0; i < 1920; i++){
				g2.drawLine(i,0,i,1080);
			}
			
			
			g2.setColor(Color.black);
			
			/*//Draw route
			//PART1
			//y = 0.1x^2 - 150 in 700 steps ( -700 till 0 )
			for(double i = -70; i < 0; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (0.1 * i * i);
				
				g2.drawOval(x + 130, y + 50, 5, 5);
			}
			
			//PART2
			// y = 1
			for(double i = 0; i < 200; i = i + 0.1) {
				int x = (int) i;
				int y = 0;
				
				g2.drawOval(x + 130, y + 50, 5, 5);
			}
			
			//PART3
			// y = (-6x)^0.5
			for(double i = -200; i < 0; i = i + 0.1) {
				int x = (int) i;
				int y = (int) -(Math.pow(-6*x, 0.5));
				
				g2.drawOval(x + 530, y + 84, 5, 5);
			}
			
			//PART4
			// y = x
			for(double i = 0; i < 150; i = i + 0.1) {
				int x = (int) i;
				int y = (int) i;
				
				g2.drawOval(x + 530, y + 84, 5, 5);
			}
			
			//PART5
			// y = -(-10x)^0.5
			for(double i = 0; i > -200; i = i - 0.1) {
				int x = (int) i;
				int y = (int) Math.pow(-10*x, 0.5);
				
				g2.drawOval(x + 680, y + 234,5,5);
			}
			
			//PART6
			// y = -0.01x^2
			
			for(double i = -125; i < 0; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (-0.01 * i * i);
				
				g2.drawOval(x + 480, y + 278, 5, 5);
			}
			
			//PART7
			// y = 0
			for(double i = -100; i < 0; i = i + 0.1) {
				int x = (int) i;
				int y = 0;
				
				g2.drawOval(x + 355, y + 120, 5, 5);
			}
			
			//PART8
			// y = 2x
			for(double i = -100; i < 0; i = i + 0.1) {
				int x = (int) i;
				int y = (int) -2*x;
				
				g2.drawOval(x + 255,y + 120,5,5);
			}
			
			//PART9
			// y = 20x^0.5
			for(double i = 0; i < 200; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (0.001 * Math.pow(i, 2));
				
				g2.drawOval(x + 155, y + 320, 5, 5);
			}
			
			//PART10
			// y = -20x^0.5
			for(double i = 0; i < 200; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (-0.001 * Math.pow(i, 2));
				
				g2.drawOval(x + 155, y + 400, 5, 5);
			}
			
			//PART11
			// y = 5x
			for(double i = 0; i < 120; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (.4*i);
				
				g2.drawOval(x + 155, y + 400, 5,5);
			}
			
			//PART12
			// y = 2.5x^0.5
			for(double i = 100; i > 0; i = i - 0.1) {
				int x = (int) i;
				int y = (int) (-2.5 * Math.pow(i, 0.5));
				
				g2.drawOval(x + 175, y + 472, 5, 5);
			}
			
			//PART13
			// y = -2.5x^0.5
			for(double i = 0; i < 400; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (2.5 * Math.pow(i, 0.5));
				
				g2.drawOval(x + 175, y + 472, 5, 5);
			}
			
			//PART13
			// y = 0
			for(double i = 0; i < 100; i = i + 0.1) {
				int x = (int) i;
				int y = 0;
				
				g2.drawOval(x + 575, y + 521, 5, 5);
			}
			
			//PART14
			// y = 2x
			for(double i = 200; i > 0; i = i - 0.1) {
				int x = (int) i;
				int y = (int) (i);
				
				g2.drawOval(x + 475, y + 321, 5, 5);
			}
			
			//PART15
			// y = 2.5x^0.5
			for(double i = 0; i < 200; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (2.5*Math.pow(i, 0.5));
				
				g2.drawOval(x + 475, y + 321, 5, 5);
			}
			
			//PART16
			// y = -x^2
			for(double i = 0; i < 75; i = i + 0.1) {
				int x = (int) i;
				int y = (int) -(0.05 * i * i);
				
				g2.drawOval(x + 675, y + 355, 5, 5);
			}*/
			
			//////////////////////////shortcuts
			
			/*g2.setColor(Color.blue);
			//Shortcut  Skip: part 4 and 5
			// y = - 0.77x
			for(double i = 0; i > -60; i = i - 0.1) {
				int x = (int) i;
				int y = (int) (-3.2 * i);
				
				g2.drawOval(x + 530, y + 84, 5, 5);
			}
			
			//Shortcut  Skip: 9 en 10
			// x = 0
			for(double i = 0; i < 80; i = i + 0.1) {
				int x = 0;
				int y = (int) i;
				
				g2.drawOval(x + 155, y + 320, 5, 5);
			}
			
			//Shortcut  Skip: 12 en 13
			// y = 6.66x
			for(double i = 0; i < 400; i = i + 0.1) {
				int x = (int) i;
				int y = (int) (0.19 * i);
				
				g2.drawOval(x + 273, y + 447, 5, 5);
			}*/
			
			
			
			/////////////////////////Draw the background over the route
			BufferedImage bg = null;
			BufferedImage kader = null;
			BufferedImage kader2 = null;
			
			try {
				bg = ImageIO.read(new File(path+"Achtergrond-Nobel.png"));
				kader = ImageIO.read(new File(path+"Achtergrond-NobelKader.png"));
				kader2 = ImageIO.read(new File(path+"Achtergrond-NobelKader2.png"));
			}catch(IOException e){
				System.out.println("PAUPERS!");
			}
			
			g2.drawImage(bg, 0, 0, null);
			//drawing the overflow
//			int colorblue = 255 - 100 / Kern.getTemp() * 255;
//			int colorred = 100 / Kern.getTemp() * 255;
			int colorblue = 0;
			int colorred = 0;
			
			if(colorblue > 255)
				colorblue = 255;
			if(colorblue < 0)
				colorblue = 0;
			if(colorred > 255)
				colorred = 255;
			if(colorred < 0)
				colorred = 0;
			
			g2.setColor(new Color(colorred, 0, colorblue));
			for(int i = 0; i < getWidth(); i++) {
				//g2.drawLine(i,0,i,Kern.getTemp());
//				g2.drawLine(i,getHeight(),i,getHeight() - Kern.getTemp());
			}
			g2.drawImage(kader, 0, 0, null);
			g2.drawImage(kader2, 0, 0, null);
			//draw amount torpedos
			/*
			g2.setColor(Color.white);
			for(int i = 0; i < model.getTotalAmountOfConsumers(); i++){
				g2.drawString(model.getConsumer(i).getName() + ": " + model.getConsumer(i).getSubmarine().getTorpedo(), 0 + i * 57, 10);
			}*/
			
		}
		
		//drawSubs(g);
		
		g2.dispose();
		g.dispose();
		
	}
	
	public void drawSubs(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		
		for(int i = 0; i < model.getTotalAmountOfConsumers(); i++) {
			
			//System.out.println(model.getConsumer(i).getSubmarine().getDistance());
			int x = 0;
			int y = 0;
			
			Consumer consumer = model.getConsumer(i);
			double distance = consumer.getSubmarine().getDistance();
			double input = distance;
			
			//SET WHEN SHORTCUTS
			//bluemountain
			if(distance >= 1290 && distance < 1450 && consumer.getSubmarine().Splitsing("bluemountain")) {
				consumer.getSubmarine().setDistance(1450);
			}
			if(distance >= 1845 && distance < 2175 && consumer.getSubmarine().Splitsing("smirnoff")) {
				consumer.getSubmarine().setDistance(2175);
			}
			if(distance >= 2685 && distance < 2795 && consumer.getSubmarine().Splitsing("ketel5")) {
				consumer.getSubmarine().setDistance(2895);
			}
			
			
			//PART1
			if(0 <= distance && distance < 700) {	
				input = input * 0.1 - 70;
				x = (int) input + 130 ;
				y = (int) (0.1 * input * input + 50);
			} else
			//PART2
			if(700 <= distance && distance < 900) {
				input = input - 700;
				x = (int) input + 130;
				y = 0 + 50;
			} else
			//PART3 
			if(900 <= distance && distance < 1100) {
				input = input - 900 - 200;
				x = (int) input + 530;
				y = (int) -(Math.pow(-6*input, 0.5)) + 84;
			} else
			//PART4
			if(1100 <= distance && distance < 1250 && !consumer.getSubmarine().Splitsing("bluemountain")) {
				if(consumer.getSubmarine().getTorpedoIndex() != 1)
					consumer.getSubmarine().AddTorpedo(1);
				input = input - 1100;
				x = (int)input + 530;
				y = (int)input + 84;
			} else
			//PART5
			if(1250 <= distance && distance < 1450 && !consumer.getSubmarine().Splitsing("bluemountain")) {
				input = 1250 - input;
				x = (int) input + 680;
				y = (int) Math.pow(-10*input, 0.5) + 234;
			} else
			//SHORTCUT: Part 4 & 5
			if(1100 <= distance && distance < 1300 && consumer.getSubmarine().Splitsing("bluemountain")) {
				input = (1100 - input) / 3;
				x = (int) input + 530;
				y = (int) (-3.2 * input) + 84;
			} else				
			//PART6
			if(1450 <= distance && distance < 1575) {
				input = 1450 - input;
				x = (int)input + 480;
				y = (int) (-0.01 *input*input) + 278;
			} else
			//PART7 
			if(1575 <= distance && distance < 1675) {
				input = 1575 - input;
				x = (int)input + 355;
				y = 0 + 120;
			} else
			//PART8 
			if(1675 <= distance && distance < 1775) {
				input = 1675 - input;
				x = (int)input+ 255;
				y = (int) (-2*input) + 120;
			} else
			//PART9
			if(1775 <= distance && distance < 1975 && !consumer.getSubmarine().Splitsing("smirnoff")) {
				if(consumer.getSubmarine().getTorpedoIndex() != 2)
					consumer.getSubmarine().AddTorpedo(2);
				input = input - 1775;
				x = (int)input+ 155;
				y = (int) (0.001 * Math.pow(input, 2)) + 320;
			} else
			//PART10 
			if(1975 <= distance && distance < 2175 && !consumer.getSubmarine().Splitsing("smirnoff")) {
				input = 1975 - input + 200;
				x = (int) input + 155;
				y = (int) (-0.001 * Math.pow(input, 2)) + 400;
			} else
			//SHORTCUT skip 9 en 10
			if(1775 <= distance && distance < 1855 && consumer.getSubmarine().Splitsing("smirnoff")) {
				input = input - 1775;
				x = 0 + 155;
				y = (int) input + 320;
				
			} else
			//PART11
			if(2175 <= distance && distance < 2295) {
				input = input - 2175;
				x = (int)input+ 155;
				y = (int) (.4*input) + 400;
			} else
			//PART12 
			if(2295 <= distance && distance < 2395 && !consumer.getSubmarine().Splitsing("ketel5")) {
				input = 2295 - input + 100;
				x = (int) input+ 175;
				y = (int) (-2.5 * Math.pow(input, 0.5)) + 472;
			} else
			//PART13.1 
			if(2395 <= distance && distance < 2795 && !consumer.getSubmarine().Splitsing("ketel5")	) {
				input = input - 2395;
				x = (int) input+ 175;
				y = (int) (2.5 * Math.pow(input, 0.5)) + 472;
			} 
			if(2295 <= distance && distance < 2695 && consumer.getSubmarine().Splitsing("ketel5")) {
				input = input - 2295;
				x = (int) input + 273;
				y = (int) (0.19 * input) + 447;
			} else
			//PART13.2
			if(2795 <= distance && distance < 2895) {
				input = input - 2795;
				x = (int)input+575;
				y = 0 + 521;
			} else
			//PART14
			if(2895 <= distance && distance < 3095) {
				if(consumer.getSubmarine().getTorpedoIndex() != 3)
					consumer.getSubmarine().AddTorpedo(3);
				input = 2895 - input + 200;
				x = (int) input + 475;
				y = (int) (input) + 321;
			} else
			//PART15
			if(3095 <= distance && distance < 3295) {
				input = input - 3095;
				x = (int)input+ 475;
				y = (int) (2.5*Math.pow(input, 0.5)) + 321;
			} else
			//PART16
			if(3295 <= distance && distance < 3370) {
				input = input - 3295;
				x = (int)input+ 675;
				y = (int) -(0.05 *input* input) + 355;
			}
			
			BufferedImage img = null;
			try {
				if(consumer.getSubmarine().getSubBroken())
					img = ImageIO.read(new File(path+"duikbootbroken.png"));
				else
					img = ImageIO.read(new File(path+"duikboot2.png"));
			}catch(IOException e){
				System.out.println("PAUPERS!");
			}
			
			g2.drawRect(x, y, 10,10);
			g2.drawImage(img, x - 40, y - 40, null);
			
			switch(i){
			case 1:	g2.setColor(Color.black);
					break;
			case 2:	g2.setColor(Color.white);
			break;
			case 3:	g2.setColor(Color.yellow);
			break;
			case 4:	g2.setColor(Color.red);
			break;
			case 5:	g2.setColor(Color.green);
			break;
			case 6:	g2.setColor(Color.blue);
			break;
			case 7:	g2.setColor(Color.pink);
			break;
			case 8: g2.setColor(Color.gray);
			break;
			case 9:	g2.setColor(Color.black);
			break;
			case 10:	g2.setColor(Color.yellow);
			break;
			case 11:	g2.setColor(Color.blue);
			break;
			case 12:	g2.setColor(Color.orange);
			break;
			case 13:	g2.setColor(Color.magenta);
			break;
			case 14:	g2.setColor(Color.white);
			break;
			}
		
			g2.drawString(model.getConsumer(i).getName(), x + 100 - i * 5, y);
			
		}
	}
}
