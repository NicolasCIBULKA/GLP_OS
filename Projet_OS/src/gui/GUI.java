package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

import data.peripheral.*;
import data.drivers.*;


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
	
	//----------------------
	//peripherals and drivers
	//----------------------
	//keyboard
	private Interaction authKbd = new Interaction();
	private Keyboard keyboard = new Keyboard("kbd1");
	private KeyboardDriver keyboardDriver = new KeyboardDriver("kbdDriver", authKbd, keyboard);
	
	//mouse
	private Interaction authMouse = new Interaction();
	private Mouse mouse = new Mouse();
	MouseDriver mouseDriver = new MouseDriver("mouseDriver", authMouse, mouse);
	
	//Screen
	private Interaction authScreen = new Interaction();
	private Screen screen= new Screen("screen");
	private ScreenDriver screenDriver = new ScreenDriver("screenDriver", authScreen, screen);
	
	
	
	//-------------------------
	//five major parts of the GUI
	//--------------------------
	private JPanel panel = new JPanel();
	private JPanel panprocess = new JPanel();
	private JPanel pandisk = new JPanel();
	private JPanel panmouse = new JPanel();
	private KeyboardGUI keyboardgui =new KeyboardGUI();
	
	//elements to display info on screen and for processes/hdd display (top of the gridlayout)
	
	private JTextArea affichécran = new JTextArea();
	private JTextArea invitecomm = new JTextArea();
	private JTextArea affichprocess= new JTextArea();
	private JTextArea affichdisk= new JTextArea();
	
	//scroll for the process display
	private JScrollPane scrollprocess = new JScrollPane(affichprocess,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//scroll for the disk
	private JScrollPane scrolldisk = new JScrollPane(affichdisk,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//scroll for the screen
	private JScrollPane scroll = new JScrollPane(affichécran,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	//scroll invite cmd
	private JScrollPane scrollcmd = new JScrollPane(invitecomm,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	


	/*
	 * methods
	 */
	
	public GUI() {
		this.setTitle("OS Simulation");
		init();
	}
	
	
	//-------------
	//init method 
	//-----------
	
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
		contentPane.add(keyboardgui.getPankeybrd(), gridcons);
		
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
		affichécran.setEditable(false);
		scroll.setAutoscrolls(true);

		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gcscreen= new GridBagConstraints();
		
		
		panel.setBorder(BorderFactory.createTitledBorder("Screen"));
		invitecomm.setBorder(BorderFactory.createTitledBorder("type here"));

		gcscreen.fill=GridBagConstraints.BOTH;
		gcscreen.gridx=0;
		gcscreen.gridy=0;
		gcscreen.weighty=1;
		gcscreen.weightx=1;
		gcscreen.gridheight=10;
		gcscreen.gridwidth=10;
		panel.add(scroll, gcscreen);
		gcscreen.weighty=0;
		gcscreen.gridx=0;
		gcscreen.gridy=10;
		gcscreen.gridheight=GridBagConstraints.REMAINDER;
		gcscreen.gridwidth=10;
		panel.add(invitecomm, gcscreen);
		
		
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
		
		//now handled in keyboardgui class
		
		
			
		
				
		//pan Mouse
		
		panmouse.setSize(400, 400);
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
		gcmouse.gridx=1;
		gcmouse.gridy=0;
		gcmouse.gridwidth=2;
		gcmouse.gridheight=1;
		panmouse.add(new JButton("/\\"), gcmouse);
		gcmouse.gridwidth=1;
		gcmouse.gridheight=2;
		gcmouse.gridx=0;
		gcmouse.gridy=1;
		panmouse.add(new JButton("<"), gcmouse);
		gcmouse.gridwidth=2;
		gcmouse.gridx=1;
		gcmouse.gridy=1;
		panmouse.add(new JButton("click"), gcmouse);
		gcmouse.gridwidth=1;
		gcmouse.gridx=3;
		gcmouse.gridy=1;
		panmouse.add(new JButton(">"), gcmouse);
		gcmouse.gridwidth=2;
		gcmouse.gridheight=1;
		gcmouse.gridx=1;
		gcmouse.gridy=3;
		panmouse.add(new JButton("\\/"), gcmouse);
		
		//action listeners
		
		keyboardgui.getEnter().addActionListener(new EnterAction());
		for(int i=0; i<4;i++) {
			for(int j=0; j<10;j++) {
				JButtonKey[][] temp = keyboardgui.getRows();
				temp[i][j].addActionListener(new KeyLetter());
			}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
	}
	
	}
	private class EnterAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			affichécran.setText(affichécran.getText() + "\n" + invitecomm.getText());
			keyboard.resetContent();
			invitecomm.setText(null);
		}
	}

	private class KeyLetter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String tmp =((JButtonKey)e.getSource()).getNum();
			keyboard.keyinput(tmp);
			invitecomm.setText(keyboardDriver.translate());
			
		}
	}
	
	//idée pour souris//
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.setColor(Color.BLUE);
		g.fillOval(10, 10, 10, 10);
	}
	

}

