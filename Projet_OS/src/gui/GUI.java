package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * work in progress:
 * mouse can be improved, gridbaglayout to get a better display,
 * other keys to be added to the keyboard
 * 
 * 
 * @author redouane
 * 
 *@version 1.0
 */

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//four major parts
	private JPanel panel = new JPanel();
	private JPanel pankeybrd = new JPanel();
	private JPanel panprocess = new JPanel();
	private JPanel panmouse = new JPanel();
	
	//elements to display info on screen and for processes display (top of the gridlayout)
	
	private JTextArea affichécran = new JTextArea();
	private JTextArea affichprocess= new JTextArea();
	private JScrollPane scroll = new JScrollPane(affichécran,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	


	
	public GUI() {
		this.setTitle("OS Simulation");
		init();
	}
	public void init() {
		
		// Main window
		
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(2,2));
		contentPane.add(panel);
		contentPane.add(panprocess);
		contentPane.add(pankeybrd);
		contentPane.add(panmouse);
		
		
		//screen
		
		panel.add(scroll, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(1,1));	
		panel.setPreferredSize(new Dimension(800,800));
		scroll.setPreferredSize(new Dimension(800,800));
		scroll.setBorder(BorderFactory.createTitledBorder("Screen"));
		

		//pan process
		
		affichprocess.setEditable(false);
		panprocess.add(new JScrollPane(affichprocess,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		panprocess.setBorder(BorderFactory.createTitledBorder("Processus"));
		panprocess.setLayout(new GridLayout(1,1));
		//pan keyboard
		
		pankeybrd.setPreferredSize(new Dimension(800,400));
		pankeybrd.setBorder(BorderFactory.createTitledBorder("keyboard"));
		GridLayout gridkey = new GridLayout(4,10);
		pankeybrd.setLayout(gridkey);
		
		//regular keys
		String row1="1234567890";
		String row2="azertyuiop";
		String row3="qsdfghjklm";
		String row4="wxcvbn,;:!";
		String[]rows= {row1,row2,row3,row4};
		
		for(int i=0;i<rows.length;i++) {
		
			char[]keys=rows[i].toCharArray();
				for(int j=0; j<keys.length;j++) {
					
					pankeybrd.add(new JButton(Character.toString(keys[j])));
				}
		}
		//we can add others keys (change size ? +grid layout pb ?)
		
		//pan Mouse
		
		panmouse.setSize(400, 400);
		panmouse.setBorder(BorderFactory.createTitledBorder("Mouse"));
		panmouse.setLayout(new GridBagLayout());
		GridBagConstraints gcmouse= new GridBagConstraints();
		gcmouse.gridheight=1;
		gcmouse.gridwidth=1;
		gcmouse.fill=GridBagConstraints.NONE;
		
		//ajout des fleches
		gcmouse.gridx=1;
		gcmouse.gridy=0;
		panmouse.add(new JButton("/\\"), gcmouse);
		gcmouse.gridx=0;
		gcmouse.gridy=1;
		panmouse.add(new JButton("<"), gcmouse);
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
