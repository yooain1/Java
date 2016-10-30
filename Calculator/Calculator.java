import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;

public class Calculator extends JFrame implements ActionListener{
	
	public String operand, operand2;
	public static double result;
	public static int isop;
	public static double converted, converted2;
	public Container calcont;
	public JPanel calPanel;
	public JTextArea display;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}
	
	public Calculator(){
		
		operand = new String();
		operand2 = new String();
		
		calcont = getContentPane();
		setTitle("Calculator");
		
		calcont.setLayout(new BorderLayout());
		calPanel = new JPanel();
		calPanel.setBackground(Color.ORANGE);
		
		display = new JTextArea("0",2,23);
		display.setEditable(false);
		display.setBounds(5, 5, 100, 30);
		calPanel.add(display,"North");
		
		JPanel Number = new JPanel();
		calPanel.add(Number,"South");
		Number.setLayout(new GridLayout(4,3,3,5));
		Number.setBackground(Color.ORANGE);
		JButton[] b = new JButton[20];
		String[] num = new String[] 
				{"7","8","9","/","C",
				"4","5","6","*","%",
				"1","2","3","-","¡î",
				"0",".","|x|","+","="};
				
		int i = 0;
		for(i=0; i<num.length;i++){
			b[i] = new JButton(num[i]);
			b[i].setBackground(Color.WHITE);
			Number.add(b[i]);
			b[i].addActionListener(this);
		}
		
		calcont.add(calPanel);
		setSize(500,250);
		setLocation(500,100);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		int i = 0;
		
		if(actionCommand.equals("+")){
			if(isop != 0)
				converted = result;
			else
				converted = Double.parseDouble(operand);
			isop = 1;
		}
		else if(actionCommand.equals("-")){
			if(isop != 0)
				converted = result;
			else
				converted = Double.parseDouble(operand);
			isop = 2;
		}
		else if(actionCommand.equals("/")){
			if(isop != 0)
				converted = result;
			else
				converted = Double.parseDouble(operand);
			isop = 3;
		}
		else if(actionCommand.equals("*")){
			if(isop != 0)
				converted = result;
			else
				converted = Double.parseDouble(operand);
			isop = 4;
		}
		else if(actionCommand.equals("%")){
			if(isop != 0)
				converted = result;
			else
				converted = Double.parseDouble(operand);
			isop = 5;
		}
		else if(actionCommand.equals("=")){
			if(isop == 1){
				converted2 = Double.parseDouble(operand2);
				result = converted + converted2;
				if(Double.toString(result).contains(".0"))
					display.setText(Integer.toString((int)result));
				else
					display.setText(Double.toString(result));
				operand = "";
				operand2 = "";
				}
			else if(isop == 2){
				converted2 = Double.parseDouble(operand2);
				result = converted - converted2;
				if(Double.toString(result).contains(".0"))
					display.setText(Integer.toString((int)result));
				else
					display.setText(Double.toString(result));
				operand = "";
				operand2 = "";
			}
			else if(isop == 3){
				converted2 = Double.parseDouble(operand2);
				result = converted / converted2;
				if(Double.toString(result).contains(".0"))
					display.setText(Integer.toString((int)result));
				else
					display.setText(Double.toString(result));
				operand = "";
				operand2 = "";
			}
			else if(isop == 4){
				converted2 = Double.parseDouble(operand2);
				result = converted * converted2;
				if(Double.toString(result).contains(".0"))
					display.setText(Integer.toString((int)result));
				else
					display.setText(Double.toString(result));
				operand = "";
				operand2 = "";
			}
			else if(isop == 5){
				converted2 = Double.parseDouble(operand2);
				result = converted % converted2;
				if(Double.toString(result).contains(".0"))
					display.setText(Integer.toString((int)result));
				else
					display.setText(Double.toString(result));
				operand = "";
				operand2 = "";
			}
		}
		
		else if(actionCommand.equals("C")){
			display.setText("0");
			isop = 0;
			operand = "";
			operand2 = "";
			converted = 0;
			converted2 = 0;
		}
		
		else if(actionCommand.equals("¡î")){
			converted = Double.parseDouble(operand);
			result = Math.sqrt(converted);
			display.setText(Double.toString(result));
		}
		
		else if(actionCommand.equals("|x|")){
			if(isop != 0)
				converted = result;
			else
				converted = Double.parseDouble(operand);
			result = Math.abs(converted);
			display.setText(Integer.toString((int)result));
		}
		else{
			if(isop == 0){
				operand = operand.concat(actionCommand);
				display.setText(operand);
			}
			else{
				operand2 = operand2.concat(actionCommand); 
				display.setText(operand2);
			}
		}
	}
}




