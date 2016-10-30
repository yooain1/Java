package past;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

class Graph2 extends Canvas implements ActionListener{
	static int data;
	static int i, j;

	public Graph2(int data) {
		this.data = data;
		setBackground(new Color(238, 224, 229));
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		for(i = 0; i<data; i++)
			animateLine(g);
	}
	
	public void animateLine(Graphics g){
		g.drawLine(80, 200, 100, 200-i);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}