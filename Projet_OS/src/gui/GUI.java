package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * work in progress:
 * mouse can be improved,
 * other keys to be added to the keyboard
 * 
 * v2 uses gridbaglayout to get more room for the virtual screen.
 * 
 * edit 2.1: panel for disk+ new keyboard w/ gridbaglayout
 * 
 * @author redouane
 * 
 *@version 2.1
 */

public class GUI extends JFrame {

	/*
	 * attributes
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	//five major parts
	private JPanel panel = new JPanel();
	private JPanel pankeybrd = new JPanel();
	private JPanel panprocess = new JPanel();
	private JPanel pandisk = new JPanel();
	private JPanel panmouse = new JPanel();
	
	//elements to display info on screen and for processes display (top of the gridlayout)
	
	private JTextArea affichécran = new JTextArea();
	private JTextArea affichprocess= new JTextArea();
	private JTextArea affichdisk= new JTextArea();
	//scroll for the process display
	private JScrollPane scrollprocess = new JScrollPane(affichprocess,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//scroll for the disk
	private JScrollPane scrolldisk = new JScrollPane(affichdisk,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//scroll for the screen
	private JScrollPane scroll = new JScrollPane(affichécran,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	


	/*
	 * methods
	 */
	
	public GUI() {
		this.setTitle("OS Simulation");
		init();
	}
	public void init() {
		
		// Main window
		
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gridcons = new GridBagConstraints();
		gridcons.fill=GridBagConstraints.BOTH;
		gridcons.insets = new Insets(5, 5, 5, 5);

		
		//adding the five parts to the frame
		
		//screen
		gridcons.weightx=2;
		gridcons.weighty=2;
		gridcons.gridx=0;
		gridcons.gridy=0;
		gridcons.gridheight=4;
		gridcons.gridwidth=2;
		contentPane.add(panel, gridcons);
		
		//disk
		gridcons.weightx=1;
		gridcons.weighty=1;
		gridcons.gridx=3;
		gridcons.gridy=0;
		gridcons.gridheight=4;
		gridcons.gridwidth=1;
		contentPane.add(pandisk, gridcons);
		
		//processes
		gridcons.gridx=4;
		gridcons.gridy=0;
		gridcons.gridheight=4;
		gridcons.gridwidth=1;
		contentPane.add(panprocess, gridcons);
		
		//keyboard
		gridcons.weightx=2;
		gridcons.weighty=1;
		gridcons.gridx=0;
		gridcons.gridy=4;
		gridcons.gridheight=2;
		gridcons.gridwidth=2;
		contentPane.add(pankeybrd, gridcons);
		
		//mouse
		gridcons.gridx=3;
		gridcons.gridy=4;
		gridcons.gridheight=2;
		gridcons.gridwidth=2;
		gridcons.weightx=2;
		gridcons.weighty=0;
		contentPane.add(panmouse, gridcons);
		
		
		//adjusting the panels of each five parts:
		
		//screen
		
		panel.add(scroll, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setPreferredSize(new Dimension(900,900));
		scroll.setPreferredSize(new Dimension(900,900));
		panel.setLayout(new GridLayout(1,1));
		scroll.setBorder(BorderFactory.createTitledBorder("Screen"));
		

		//pan process
		
		affichprocess.setEditable(false);
		panprocess.add(scrollprocess);
		panprocess.setBorder(BorderFactory.createTitledBorder("Processus"));
		panprocess.setLayout(new GridLayout(1,1));
		
		//pandisk
		
		affichdisk.setEditable(false);
		pandisk.add(scrolldisk);
		pandisk.setBorder(BorderFactory.createTitledBorder("HDD/memory"));
		pandisk.setLayout(new GridLayout(1,1));
		
		
		//pan keyboard
		//version 2, use of gridbaglayout
		
		
		pankeybrd.setPreferredSize(new Dimension(800,400));
		pankeybrd.setBorder(BorderFactory.createTitledBorder("keyboard"));
		GridBagLayout gridkey = new GridBagLayout();
		GridBagConstraints keyConstraint = new GridBagConstraints();
		pankeybrd.setLayout(gridkey);
		keyConstraint.fill=GridBagConstraints.BOTH;
			
		//regular keys
		String row1="1234567890";
		String row2="azertyuiop";
		String row3="qsdfghjklm";
		String row4="wxcvbn,;:!";
		String[]rows= {row1,row2,row3,row4};
		
		for(int i=0;i<rows.length;i++) {
		
			char[]keys=rows[i].toCharArray();
				for(int j=0; j<keys.length;j++) {
					keyConstraint.gridwidth=1;
					keyConstraint.gridheight=1;
					keyConstraint.weightx=1;
					keyConstraint.weighty=1;
					keyConstraint.gridx=j;
					keyConstraint.gridy=i;
					pankeybrd.add(new JButton(Character.toString(keys[j])),keyConstraint);
				}
		}
		//we can add others keys (change size ? +grid layout pb ?)
		keyConstraint.gridy=5;
				
		keyConstraint.gridx=0;
		pankeybrd.add(new JButton("ctrl"),keyConstraint);
		keyConstraint.gridx=1;
		pankeybrd.add(new JButton("alt"),keyConstraint);
		keyConstraint.gridx=2;
		keyConstraint.gridwidth=4;
		keyConstraint.weightx=1;
		pankeybrd.add(new JButton("space"),keyConstraint);
		keyConstraint.gridwidth=1;
		keyConstraint.gridx=4;
		keyConstraint.weightx=0;
		pankeybrd.add(new JButton("shift"),keyConstraint);
		keyConstraint.gridx=5;
		pankeybrd.add(new JButton("+"),keyConstraint);
		keyConstraint.gridx=6;
		pankeybrd.add(new JButton("="),keyConstraint);
		keyConstraint.gridx=7;
		pankeybrd.add(new JButton("*"),keyConstraint);
		keyConstraint.gridwidth=2;
		keyConstraint.gridx=8;
		keyConstraint.weightx=1;
		pankeybrd.add(new JButton("Enter"),keyConstraint);
				
		//pan Mouse
		
		panmouse.setSize(400, 400);
		panmouse.setBorder(BorderFactory.createTitledBorder("Mouse"));
		
		//gridbaglayout to get the display i wanted
		panmouse.setLayout(new GridBagLayout());
		GridBagConstraints gcmouse= new GridBagConstraints();
		gcmouse.gridheight=1;
		gcmouse.gridwidth=1;
		gcmouse.fill=GridBagConstraints.NONE;
		
		//adding the buttons: arrows + click
		
		gcmouse.gridx=1;
		gcmouse.gridy=0;
		panmouse.add(new JButton("/\\"), gcmouse);
		gcmouse.gridx=0;
		gcmouse.gridy=1;
		panmouse.add(new JButton("<"), gcmouse);
		gcmouse.gridx=1;
		gcmouse.gridy=1;
		panmouse.add(new JButton("click"), gcmouse);
		gcmouse.gridx=2;
		gcmouse.gridy=1;
		panmouse.add(new JButton(">"), gcmouse);
		gcmouse.gridx=1;
		gcmouse.gridy=2;
		panmouse.add(new JButton("\\/"), gcmouse);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
	}
	

}
