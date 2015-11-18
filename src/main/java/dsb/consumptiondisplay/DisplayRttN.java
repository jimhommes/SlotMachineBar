package dsb.consumptiondisplay;

import javafx.animation.AnimationTimer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class DisplayRttN extends JFrame {
	
	static BoardRttN board;
	int width = 1920;
	int height = 1080;

	AnimationTimer timer1;
	AnimationTimer timer2;
	AnimationTimer timer3;

	ArrayList<Logo> logos1;
	ArrayList<Logo> logos2;
	ArrayList<Logo> logos3;
	
	public DisplayRttN(ConsumptionDisplayModel model) {
		//Creating a window
		board = new BoardRttN(model);
		add(board);									//adding the panel

		setTitle("Slotmachine");			//Setting the title
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//Default close = exit
		setSize(width, height);						//Set size
		setLocationRelativeTo(null);				//start top left
		setUndecorated(true);
		setVisible(true);							//Make it visible
		setResizable(true);						//Not resizable

		createTimers();
		createLogos();
	}

	private void createTimers() {
		timer1 = new AnimationTimer() {
			@Override
			public void handle(long t) {

			}
		};
	}

	private void createLogos() {
		logos1 = new ArrayList<>();
		logos2 = new ArrayList<>();
		logos3 = new ArrayList<>();

		try {
			logos1.add(new Logo(ImageIO.read(new File("src/main/java/dsb/consumptiondisplay/fruit1.png")), 1256, 0, this));
			//TODO: Add all logos
			//TODO: Change BoardRttN to observer instead of DisplayRttN
			//TODO: 3 different arrays here for Logos, then AnimationTimers for reeling
			//TODO: Random selection
			//TODO: Photoshop all logos
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void refresh() {
		board.repaint();
	}

	public void roll() {

	}

	public BoardRttN getBoard() {
		return board;
	}
}
