import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MyCanvas extends Frame implements ActionListener {

	public static Point first_point, last_point, old_point;

	String str = "Pen";
	String clr = "b";
	boolean f = false;
	boolean b = false;
	JButton text, pen, line, rectangular, circle, clear, eraser;
	JButton black, white, red, orange, yellow, green, blue, pink, magenta;
	JCheckBox isFill, isBold;
	String txt;

	public MyCanvas() {
		super("Canvas");

		Panel tool = new Panel();
		tool.setBackground(Color.LIGHT_GRAY);

		/* Figure Panel */
		pen = new JButton("Pen");
		pen.setBackground(Color.WHITE);
		tool.add(pen);

		line = new JButton("Line");
		line.setBackground(Color.WHITE);
		tool.add(line);

		rectangular = new JButton("Rectangle");
		rectangular.setBackground(Color.WHITE);
		tool.add(rectangular);

		circle = new JButton("Circle");
		circle.setBackground(Color.WHITE);
		tool.add(circle);
		
		text = new JButton("Text");
		text.setBackground(Color.WHITE);
		tool.add(text);

		eraser = new JButton("Eraser");
		eraser.setBackground(Color.WHITE);
		tool.add(eraser);

		clear = new JButton("Clear");
		clear.setBackground(Color.WHITE);
		tool.add(clear);

		isFill = new JCheckBox("Fill");
		isFill.setBackground(Color.LIGHT_GRAY);
		tool.add(isFill);

		isBold = new JCheckBox("Bold");
		isBold.setBackground(Color.LIGHT_GRAY);
		tool.add(isBold);

		/* Color Palet Panel */
		add(tool, BorderLayout.NORTH);
		Panel palet = new Panel();
		palet.setBackground(Color.LIGHT_GRAY);

		black = new JButton("b");
		black.setForeground(Color.BLACK);
		black.setBackground(Color.BLACK);

		white = new JButton("w");
		white.setForeground(Color.WHITE);
		white.setBackground(Color.WHITE);

		red = new JButton("r");
		red.setForeground(Color.RED);
		red.setBackground(Color.RED);

		orange = new JButton("o");
		orange.setForeground(Color.ORANGE);
		orange.setBackground(Color.ORANGE);

		yellow = new JButton("y");
		yellow.setForeground(Color.YELLOW);
		yellow.setBackground(Color.YELLOW);

		green = new JButton("g");
		green.setForeground(Color.GREEN);
		green.setBackground(Color.GREEN);

		blue = new JButton("e");
		blue.setForeground(Color.BLUE);
		blue.setBackground(Color.BLUE);

		pink = new JButton("p");
		pink.setForeground(Color.PINK);
		pink.setBackground(Color.PINK);

		magenta = new JButton("m");
		magenta.setForeground(Color.MAGENTA);
		magenta.setBackground(Color.MAGENTA);

		palet.add(black);
		palet.add(white);
		palet.add(red);
		palet.add(orange);
		palet.add(yellow);
		palet.add(green);
		palet.add(blue);
		palet.add(pink);
		palet.add(magenta);

		add(palet, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		add(new GrimPanCanvas(), BorderLayout.CENTER);
		setBackground(Color.WHITE);
		setBounds(300, 100, 800, 600);
		setVisible(true);
		setResizable(false);

		/* Figure Action */
		pen.addActionListener(this);
		line.addActionListener(this);
		rectangular.addActionListener(this);
		circle.addActionListener(this);
		text.addActionListener(this);
		clear.addActionListener(this);
		eraser.addActionListener(this);
		isFill.addActionListener(this);
		isBold.addActionListener(this);

		/* Color Action */
		black.addActionListener(this);
		white.addActionListener(this);
		red.addActionListener(this);
		orange.addActionListener(this);
		yellow.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		pink.addActionListener(this);
		magenta.addActionListener(this);

	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		// MenuItem selected_menu = (MenuItem)ae.getSource();
		String actionCommand = ae.getActionCommand();

		if (actionCommand.equals("Pen")) {
			str = "Pen";
		} else if (actionCommand.equals("Line")) {
			str = "Line";
		} else if (actionCommand.equals("Rectangle")) {
			str = "Rectangular";
		} else if (actionCommand.equals("Circle")) {
			str = "Circle";
		} else if (actionCommand.equals("b")) {
			clr = black.getLabel();
		} else if (actionCommand.equals("w")) {
			clr = white.getLabel();
		} else if (actionCommand.equals("r")) {
			clr = red.getLabel();
		} else if (actionCommand.equals("o")) {
			clr = orange.getLabel();
		} else if (actionCommand.equals("y")) {
			clr = yellow.getLabel();
		} else if (actionCommand.equals("g")) {
			clr = green.getLabel();
		} else if (actionCommand.equals("e")) {
			clr = blue.getLabel();
		} else if (actionCommand.equals("p")) {
			clr = pink.getLabel();
		} else if (actionCommand.equals("m")) {
			clr = magenta.getLabel();
		} else if (actionCommand.equals("Fill")) {
			if (isFill.isSelected() == true)
				f = true;
			else
				f = false;
		} else if (actionCommand.equals("Clear")) {
			str = clear.getLabel();
		} else if (actionCommand.equals("Bold")) {
			if (isBold.isSelected() == true)
				b = true;
			else
				b = false;
		} else if (actionCommand.equals("Eraser")) {
			str = "Eraser";
		} else if (actionCommand.equals("Text")) {
			txt = JOptionPane.showInputDialog(this,"Text",null);
			str = "Text";
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyCanvas();
	}

	class GrimPanCanvas extends Canvas implements MouseMotionListener,
			MouseListener {

		Graphics2D bp;

		public GrimPanCanvas() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		public void mouseClicked(MouseEvent me) {
		}

		public void mouseEntered(MouseEvent me) {
			if (str.equals("Clear"))
				repaint();
		}

		public void mouseExited(MouseEvent me) {
		}

		public void mousePressed(MouseEvent me) {
			first_point = me.getPoint();
			old_point = me.getPoint();
		}

		public void mouseReleased(MouseEvent me) {
			last_point = me.getPoint();
			repaint();
		}

		public void mouseDragged(MouseEvent me) {
			last_point = me.getPoint();
			if (str.equals("Pen") || str.equals("Eraser"))
				repaint();
		}

		public void mouseMoved(MouseEvent me) {
		}

		public void update(Graphics g) {
			paint(g);
		}

		public void paint(Graphics g) {
			if (first_point != null && last_point != null) {

				if (str.equals("Pen")) {

					if (b == true) {
						if (clr.equals("b")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.BLACK);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("w")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.WHITE);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("r")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.RED);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("o")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.ORANGE);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("y")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.YELLOW);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("g")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.GREEN);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("e")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.BLUE);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("p")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.PINK);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("m")) {
							bp = (Graphics2D) g;
							bp.setStroke(new BasicStroke(10));
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.setColor(Color.MAGENTA);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}
					} else {
						if (clr.equals("b")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.BLACK);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("w")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.WHITE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("r")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.RED);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("o")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.ORANGE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("y")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.YELLOW);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("g")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.GREEN);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("e")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.BLUE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("p")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.BLUE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}

						else if (clr.equals("m")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.MAGENTA);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawLine(first_point.x, first_point.y,
									last_point.x, last_point.y);
							first_point = last_point;
							return;
						}
					}
				} else if (str.equals("Line")) {
					if (clr.equals("b")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.BLACK);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("w")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.WHITE);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("r")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.RED);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("o")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.ORANGE);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("y")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.YELLOW);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("g")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.GREEN);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("e")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.BLUE);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("p")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.PINK);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					} else if (clr.equals("m")) {
						bp = (Graphics2D) g;
						bp.setColor(Color.MAGENTA);
						bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						bp.drawLine(first_point.x, first_point.y, last_point.x,
								last_point.y);
					}
				}

				else if (str.equals("Circle")) {
					if (f == true) {
						if (clr.equals("b")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.BLACK);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("w")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.WHITE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("r")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.RED);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("o")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.ORANGE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("y")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.YELLOW);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("g")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.GREEN);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("e")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.BLUE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("p")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.PINK);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("m")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.MAGENTA);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.fillOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						}
					} else {
						if (clr.equals("b")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.BLACK);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("w")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.WHITE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("r")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.RED);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("o")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.ORANGE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("y")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.YELLOW);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("g")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.GREEN);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("e")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.BLUE);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("p")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.PINK);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("m")) {
							bp = (Graphics2D) g;
							bp.setColor(Color.MAGENTA);
							bp.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							bp.drawOval(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						}
					}
				}

				else if (str.equals("Rectangular")) {
					if (f == true) {
						if (clr.equals("b")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.BLACK);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("w")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("r")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.RED);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("o")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.ORANGE);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("y")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.YELLOW);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("g")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.GREEN);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("e")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.BLUE);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("p")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.PINK);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("m")) {
							g.setColor(Color.WHITE);
							g.fillRect(first_point.x, first_point.y,
									old_point.x - first_point.x, old_point.y
											- first_point.y);
							g.setColor(Color.MAGENTA);
							g.fillRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						}
					} else {
						if (clr.equals("b")) {
							g.setColor(Color.BLACK);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("w")) {
							g.setColor(Color.WHITE);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("r")) {
							g.setColor(Color.RED);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("o")) {
							g.setColor(Color.ORANGE);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("y")) {
							g.setColor(Color.YELLOW);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("g")) {
							g.setColor(Color.GREEN);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("e")) {
							g.setColor(Color.BLUE);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("p")) {
							g.setColor(Color.PINK);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						} else if (clr.equals("m")) {
							g.setColor(Color.MAGENTA);
							g.drawRect(first_point.x, first_point.y,
									last_point.x - first_point.x, last_point.y
											- first_point.y);
						}
					}
				} else if (str.equals("Clear")) {
					g.setColor(Color.WHITE);
					g.fillRect(0, 0, 800, 600);
				} else if (str.equals("Eraser")) {
					bp = (Graphics2D) g;
					bp.setStroke(new BasicStroke(15));
					bp.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
					bp.setColor(Color.WHITE);
					bp.drawLine(first_point.x, first_point.y, last_point.x,
							last_point.y);
					first_point = last_point;
					return;
				} else if (str.equals("Text")){
					g.drawString(txt, last_point.x, last_point.y);
					txt = "";
				}

				old_point = last_point;
			}
		}
	}
}