package past;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowGraph extends Frame{
		
	JPanel p;
	static int data1, data2, data3, data4;
	
	public ShowGraph(int data1, int data2, int data3, int data4){
		
	
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	
		p = new JPanel();
		p.setBackground(new Color(238, 224, 229));
		

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		add(new Graph(data1, data2, data3, data4),BorderLayout.CENTER );
		
		setBounds(200,100,700,360);
		//setResizable(false);
		setVisible(true);
		
	}

}
