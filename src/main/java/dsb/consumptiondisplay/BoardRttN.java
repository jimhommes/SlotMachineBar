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

		try {
			BufferedImage bg = ImageIO.read(new File("src/main/java/dsb/consumptiondisplay/FrontSlotMachine.png"));
			BufferedImage fruit1 = ImageIO.read(new File("src/main/java/dsb/consumptiondisplay/fruit1.png"));
			BufferedImage fruit3 = ImageIO.read(new File("src/main/java/dsb/consumptiondisplay/fruit3.png"));
			g2.drawImage(fruit3, 1255, 0, null);
			g2.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			System.out.println("geen plaatju gevonden");
		}


		g2.dispose();
		g.dispose();
		
	}

}
