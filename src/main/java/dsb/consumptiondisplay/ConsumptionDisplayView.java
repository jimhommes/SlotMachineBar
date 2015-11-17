package dsb.consumptiondisplay;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConsumptionDisplayView extends JFrame {

	ConsumptionDisplayModel model;
	ArrayList<JLabel> labels;

	public ConsumptionDisplayView(ConsumptionDisplayModel model) {
		super("Test");
		this.model = model;
		this.setupView();
	}

	public void setupView() {
		Integer size = model.getTotalAmountOfConsumers();
		boolean evenNumberOfConsumers = size % 2 == 0;
		if (evenNumberOfConsumers)
			this.setLayout(new GridLayout((size / 2), 2));
		else
			this.setLayout(new GridLayout(((size + 1) / 2), 2));

		labels = new ArrayList<JLabel>(size);

		for (int i = 0; i < size; i++) {

			JLabel label = new JLabel(model.getConsumer(i).toString());

			label.setFont(new Font(label.getText(), Font.PLAIN, 60));
			labels.add(label);
			this.add(label);
		}
		if (!evenNumberOfConsumers) {
			this.add(new JLabel("Gemaakt door Norberhuis"));
		}

		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) (tk.getScreenSize().getWidth()) / 2);
		int ySize = ((int) tk.getScreenSize().getHeight());
		this.setSize(xSize, ySize);

		this.show();

	}

	public void updateConsumer(int indexOfConsumer) {
		model.updateConsumer(indexOfConsumer);
		labels.get(indexOfConsumer).setText(model.getConsumer(indexOfConsumer).toString());
	}
	
	public void fastUpdateConsumer(int indexOfConsumer){
		model.fastupdateConsumer(indexOfConsumer);
	}

	public void orderByConsumption() {
		model.orderByConsumption();
		Integer size = model.getTotalAmountOfConsumers();
		for (int indexOfConsumer = 0; indexOfConsumer < size; indexOfConsumer++) {
			labels.get(indexOfConsumer).setText(model.getConsumer(indexOfConsumer).toString());
		}

	}
}
