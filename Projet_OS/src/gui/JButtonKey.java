package gui;

import javax.swing.*;

@SuppressWarnings("serial")

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
