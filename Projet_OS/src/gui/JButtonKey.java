package gui;

import javax.swing.*;

@SuppressWarnings("serial")
/**
 * this class is used in the GUI
 * 
 * the number is the ascii for the character of
 * 
 * the label of the button
 * 
 * 
 * @author redouane
 *
 */
public class JButtonKey extends JButton{
	
	private String num;
	private String label;
	
	public JButtonKey(String num, String label) {
		super(label);
		this.num=num;
	}
	
	public String getNum() {
		return num;
	}
	
	public String getLabel() {
		return label;
	}
}
