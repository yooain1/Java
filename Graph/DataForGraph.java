package past;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DataForGraph extends Frame implements ActionListener {

	JPanel p2;
	JLabel ed1, ed2, ed3, ed4;
	JTextField tf1, tf2, tf3, tf4;
	JButton enterButton;
	static int data1, data2, data3, data4;

	public DataForGraph() {

		p2 = new JPanel();
		p2.setBackground(new Color(238, 224, 229));

		ed1 = new JLabel("Data1");
		ed2 = new JLabel("Data2");
		ed3 = new JLabel("Data3");
		ed4 = new JLabel("Data4");
		
		ed1.setBounds(50, 70, 50, 30);
		ed2.setBounds(130, 70, 50, 30);
		ed3.setBounds(210, 70, 50, 30);
		ed4.setBounds(290, 70, 50, 30);

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		
		tf1.setBounds(50, 50, 70, 25);
		tf2.setBounds(130, 50, 70, 25);
		tf3.setBounds(210, 50, 70, 25);
		tf4.setBounds(290, 50, 70, 25);

		enterButton = new JButton("Enter");
		enterButton.setBounds(45, 120, 80, 30);
		enterButton.setBackground(new Color(255, 246, 143));

		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		
		add(ed1);
		add(ed2);
		add(ed3);
		add(ed4);
		add(enterButton);

		add(p2);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setBounds(200, 100, 600, 200);
		setResizable(false);
		setVisible(true);

		enterButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String str = tf1.getText();
		data1 = Integer.parseInt(str);
		str = tf2.getText();
		data2 = Integer.parseInt(str);
		str = tf3.getText();
		data3 = Integer.parseInt(str);
		str = tf4.getText();
		data4 = Integer.parseInt(str);
		new ShowGraph(data1, data2, data3, data4);
	}

}
