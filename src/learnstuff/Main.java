package learnstuff;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	JLabel tempLabel, outLabel;
	JTextField textField;
	String[] temps;
	JList list;
	int tempIndex;
	JButton button;
	
	static double convert(int temp, String scale){
		if(scale.equals("Celsius to Fahrenheit")){
			return (temp- 32.0) * (5.0/9.0);
		}
		else{
			return temp * (9.0/5.0) + 32;
		}
	}

	public Main(){
		tempLabel = new JLabel("Temperature: ");
		outLabel = new JLabel("");
		textField = new JTextField(5);
		button = new JButton("Convert");
		temps = new String[]{"Celsius to Fahrenheit","Fahrenheit to Celsius"};
		list = new JList(temps);
		JFrame frame = new JFrame("Temperature Converter:");
		frame.setLayout(new GridLayout(3,2));
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		list.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent le) {
				tempIndex = list.getSelectedIndex();
				}
		});
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
				int temp = Integer.parseInt(textField.getText());
				String scale = temps[tempIndex];
				outLabel.setText(Double.toString(convert(temp, scale)));
				}catch(Exception e)
				{
					JFrame error = new JFrame("error");
					JLabel errorLabel = new JLabel("Please enter a valid input");
					error.setSize(300, 100);
					error.setVisible(true);
					error.setResizable(false);
					error.add(errorLabel);
				}
			}
		});
		frame.add(tempLabel);
		frame.add(textField);
		frame.add(list);
		frame.add(button);
		frame.add(outLabel);
		frame.setVisible(true);
		frame.setResizable(false);
		 
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Main();
			}
		});
	}
		
}
