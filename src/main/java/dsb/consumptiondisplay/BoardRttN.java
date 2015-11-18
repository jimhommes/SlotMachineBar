package dsb.consumptiondisplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardRttN extends JPanel implements Observer {
	
	private ConsumptionDisplayModel model;
	private boolean init = false;
	ArrayList<Logo> logos = new ArrayList<>();

	Graphics2D g2;

	public BoardRttN(ConsumptionDisplayModel m) {
		model = m;
	}
	
	public void paint(Graphics g) {
		
		g2 = (Graphics2D) g;
		
		//Rendering hints (make it smooth) 
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(rh);

		try {
			logos.forEach(logo -> g2.drawImage(logo.getImage(), logo.getX(), logo.getY(), null));
			BufferedImage bg = ImageIO.read(new File("src/main/java/dsb/consumptiondisplay/FrontSlotMachine.png"));
			g2.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			System.out.println("geen plaatju gevonden");
		}
		
	}

	public void update(Observable o, Object arg) {
		Logo logo = (Logo) o;
		if(!logos.contains(logo)) {
			logos.add(logo);
		}
		repaint();
	}

}
