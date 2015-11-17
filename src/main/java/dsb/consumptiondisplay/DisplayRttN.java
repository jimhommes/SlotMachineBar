package dsb.consumptiondisplay;

import javax.swing.*;

public class DisplayRttN extends JFrame {
	
	static BoardRttN board;
	int width = 800;
	int height = 600;
	
	public DisplayRttN(ConsumptionDisplayModel model) {
		//Creating a window
		board = new BoardRttN(model);
		add(board);									//adding the panel

		setTitle("Nucleaire Troep Borrel Swag Jim is koel en Menno ook. Wij kunnen dingen.");			//Setting the title
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//Default close = exit
		setSize(width, height);						//Set size
		setLocationRelativeTo(null);				//start top left
		setUndecorated(true);
		setVisible(true);							//Make it visible
		setResizable(true);						//Not resizable
	}
	
	public void refresh() {
		board.repaint();
	}
	
}
