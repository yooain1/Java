package past;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.geom.*;

public class Graph extends Canvas {

	static int data1, data2, data3, data4;
	static int i, j;

	public Graph(int data1, int data2, int data3, int data4) {

		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;

		setBackground(new Color(238, 224, 229));
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {

		g.drawString("200", 35, 50);
		g.drawString("150", 35, 100);
		g.drawString("100", 35, 150);
		g.drawString("50", 35, 200);
		g.drawString("0", 35, 250);
		g.drawLine(70, 50, 70, 250);
		g.setColor(Color.BLACK);
		g.drawString("Data1", 95, 270);
		g.setColor(Color.BLACK);
		g.drawString("Data2", 145, 270);
		g.setColor(Color.BLACK);
		g.drawString("Data3", 195, 270);
		g.setColor(Color.BLACK);
		g.drawString("Data4", 245, 270);
		for (i = 0; i < data1; i++) {
			g.setColor(new Color(191, 62, 255));
			g.fillRect(100, 250 - i, 20, i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					e.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		g.drawString(Integer.toString(data1), 105, 250 - data1);

		for (i = 0; i < data2; i++) {
			g.setColor(new Color(191, 62, 255));
			g.fillRect(150, 250 - i, 20, i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					e.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		g.drawString(Integer.toString(data2), 155, 250 - data2);

		for (i = 0; i < data3; i++) {
			g.setColor(new Color(191, 62, 255));
			g.fillRect(200, 250 - i, 20, i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					e.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		g.drawString(Integer.toString(data3), 205, 250 - data3);

		for (i = 0; i < data4; i++) {
			g.setColor(new Color(191, 62, 255));
			g.fillRect(250, 250 - i, 20, i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					e.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		g.drawString(Integer.toString(data4), 255, 250 - data4);

		g.setColor(Color.BLACK);
		g.drawString("200", 400, 50);
		g.drawString("150", 400, 100);
		g.drawString("100", 400, 150);
		g.drawString("50", 400, 200);
		g.drawString("0", 400, 250);
		g.drawLine(435, 50, 435, 250);
		g.setColor(Color.BLACK);
		g.drawString("Data1", 460, 270);
		g.setColor(Color.BLACK);
		g.drawString("Data2", 510, 270);
		g.setColor(Color.BLACK);
		g.drawString("Data3", 560, 270);
		g.setColor(Color.BLACK);
		g.drawString("Data4", 610, 270);

		g.setColor(new Color(191, 62, 255));
		g.drawLine(460, 250 - data1, 510, 250 - data2);
		g.drawLine(510, 250 - data2, 560, 250 - data3);
		g.drawLine(560, 250 - data3, 610, 250 - data4);
		g.setColor(Color.GRAY);
		g.drawString(Integer.toString(data1), 465, 250 - data1);
		g.drawString(Integer.toString(data2), 515, 250 - data2);
		g.drawString(Integer.toString(data3), 565, 250 - data3);
		g.drawString(Integer.toString(data4), 615, 250 - data4);

	}

	/*
	 * for (i = 0; i < data; i++) { g.drawLine(55, 200, 55+i, 200 - i);
	 * 
	 * try { Thread.sleep(40); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); try { e.wait(); } catch
	 * (InterruptedException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } } }
	 */

}
