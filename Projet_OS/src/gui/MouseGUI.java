package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MouseGUI {

	private JPanel panmouse = new JPanel();
	//adding a button to turn on the screen because there is some room left in this panel
	private JButton startstop =new JButton("Start");
	
	private JButton up =new JButton("/\\");
	private JButton left =new JButton("<");
	private JButton click =new JButton("click");
	private JButton right =new JButton(">");
	private JButton down =new JButton("\\/");
	
	public MouseGUI() {
		panmouse.setBorder(BorderFactory.createTitledBorder("Mouse"));
		
		//gridbaglayout to get the display i wanted
		panmouse.setLayout(new GridBagLayout());
		GridBagConstraints gcmouse= new GridBagConstraints();
		gcmouse.gridheight=1;
		gcmouse.gridwidth=1;
		gcmouse.fill=GridBagConstraints.BOTH;
		
		//adding the buttons: arrows + click
		
		gcmouse.weightx=1;
		gcmouse.weighty=1;
		gcmouse.gridx=0;
		gcmouse.gridy=0;
		panmouse.add(startstop, gcmouse);
		gcmouse.gridx=1;
		gcmouse.gridy=0;
		gcmouse.gridwidth=2;
		gcmouse.gridheight=1;
		panmouse.add(up, gcmouse);
		gcmouse.gridwidth=1;
		gcmouse.gridheight=2;
		gcmouse.gridx=0;
		gcmouse.gridy=1;
		panmouse.add(left, gcmouse);
		gcmouse.gridwidth=2;
		gcmouse.gridx=1;
		gcmouse.gridy=1;
		panmouse.add(click, gcmouse);
		gcmouse.gridwidth=1;
		gcmouse.gridx=3;
		gcmouse.gridy=1;
		panmouse.add(right, gcmouse);
		gcmouse.gridwidth=2;
		gcmouse.gridheight=1;
		gcmouse.gridx=1;
		gcmouse.gridy=3;
		panmouse.add(down, gcmouse);
		
	}
	
	public JPanel getPanel() {
		return panmouse;
	}

	public JButton getUp() {
		return up;
	}

	public JButton getLeft() {
		return left;
	}

	public JButton getClick() {
		return click;
	}

	public JButton getRight() {
		return right;
	}

	public JButton getDown() {
		return down;
	}

	public JButton getStartstop() {
		return startstop;
	}
	
	
}
