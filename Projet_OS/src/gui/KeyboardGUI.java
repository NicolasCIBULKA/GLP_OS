package gui;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class KeyboardGUI {



	/**
	 * Class for the keyboard part of the gui
	 * there is the inner class of the action listener
	 * 
	 * @author redouane
	 * 
	 */
	private JPanel pankeybrd = new JPanel();

	private JButton button0 = new JButton("0");
	private JButton button1= new JButton("1");
	private JButton button2= new JButton("2");
	private JButton button3= new JButton("3");
	private JButton button4= new JButton("4");
	private JButton button5= new JButton("5");
	private JButton button6= new JButton("6");
	private JButton button7= new JButton("7");
	private JButton button8= new JButton("8");
	private JButton button9 = new JButton("9");
	private JButton a = new JButton("a");
	private JButton z = new JButton("z");
	private JButton e= new JButton("e");
	private JButton r= new JButton("r");
	private JButton t= new JButton("t");
	private JButton y= new JButton("y");
	private JButton u= new JButton("u");
	private JButton i= new JButton("i");
	private JButton o= new JButton("o");
	private JButton p= new JButton("p");
	private JButton q= new JButton("q");
	private JButton s= new JButton("s");
	private JButton d= new JButton("d");
	private JButton f= new JButton("f");
	private JButton g= new JButton("g");
	private JButton h= new JButton("h");
	private JButton j= new JButton("j");
	private JButton k= new JButton("k");
	private JButton l= new JButton("l");
	private JButton m= new JButton("m");
	private JButton w= new JButton("w");
	private JButton x= new JButton("x");
	private JButton c= new JButton("c");
	private JButton v= new JButton("v");
	private JButton b= new JButton("b");
	private JButton n= new JButton("n");
	private JButton coma= new JButton(",");
	private JButton semicolon = new JButton(";");
	private JButton colon= new JButton(":");
	private JButton exclapoint= new JButton("!");
	private JButton space= new JButton("space");
	private JButton enter= new JButton("enter");
	
	public KeyboardGUI() {
		pankeybrd.setPreferredSize(new Dimension(800,400));
		pankeybrd.setBorder(BorderFactory.createTitledBorder("keyboard"));
		GridBagLayout gridkey = new GridBagLayout();
		GridBagConstraints keyConstraint = new GridBagConstraints();
		pankeybrd.setLayout(gridkey);
		keyConstraint.fill=GridBagConstraints.BOTH;
			
		//regular keys
		JButton[] row1= {button0,button1,button2,button3,button4,button5,button6,button7,button8,button9};
		JButton[] row2= {a,z,e,r,t,y,u,i,o,p};
		JButton[] row3= {q,s,d,f,g,h,j,k,l,m};
		JButton[] row4= {w,x,c,v,b,n,coma, semicolon,colon, exclapoint};
		JButton[][]rows= {row1,row2,row3,row4};
		
		for(int i=0; i<4;i++) {
			for(int j=0; j<10;j++) {
					
					//position and specifics of regular keys
					
					keyConstraint.gridwidth=1;
					keyConstraint.gridheight=1;
					keyConstraint.weightx=1;
					keyConstraint.weighty=1;
					keyConstraint.gridx=j;
					keyConstraint.gridy=i;
					pankeybrd.add((rows[i][j]),keyConstraint);
				}
		}
		
		//to be modified
		keyConstraint.gridy=5;
				
		keyConstraint.gridx=0;
		pankeybrd.add(new JButton("ctrl"),keyConstraint);
		keyConstraint.gridx=1;
		pankeybrd.add(new JButton("alt"),keyConstraint);
		keyConstraint.gridx=2;
		keyConstraint.gridwidth=3;
		keyConstraint.weightx=1;
		pankeybrd.add(space,keyConstraint);
		keyConstraint.gridwidth=1;
		keyConstraint.weightx=0;
		keyConstraint.gridx=5;
		pankeybrd.add(new JButton("+"),keyConstraint);
		keyConstraint.gridx=6;
		pankeybrd.add(new JButton("="),keyConstraint);
		keyConstraint.gridx=7;
		pankeybrd.add(new JButton("*"),keyConstraint);
		keyConstraint.gridwidth=2;
		keyConstraint.gridx=8;
		keyConstraint.weightx=1;
		pankeybrd.add(enter,keyConstraint);
	}
	
	
	
	//getters
	
	public JPanel getPankeybrd() {
		return pankeybrd;
	}


	public JButton getButton0() {
		return button0;
	}


	public JButton getButton1() {
		return button1;
	}


	public JButton getButton2() {
		return button2;
	}


	public JButton getButton3() {
		return button3;
	}


	public JButton getButton4() {
		return button4;
	}


	public JButton getButton5() {
		return button5;
	}


	public JButton getButton6() {
		return button6;
	}


	public JButton getButton7() {
		return button7;
	}


	public JButton getButton8() {
		return button8;
	}


	public JButton getButton9() {
		return button9;
	}


	public JButton getA() {
		return a;
	}


	public JButton getZ() {
		return z;
	}


	public JButton getE() {
		return e;
	}


	public JButton getR() {
		return r;
	}


	public JButton getT() {
		return t;
	}


	public JButton getY() {
		return y;
	}


	public JButton getU() {
		return u;
	}


	public JButton getI() {
		return i;
	}


	public JButton getO() {
		return o;
	}


	public JButton getP() {
		return p;
	}


	public JButton getQ() {
		return q;
	}


	public JButton getS() {
		return s;
	}


	public JButton getD() {
		return d;
	}


	public JButton getF() {
		return f;
	}


	public JButton getG() {
		return g;
	}


	public JButton getH() {
		return h;
	}


	public JButton getJ() {
		return j;
	}


	public JButton getK() {
		return k;
	}


	public JButton getL() {
		return l;
	}


	public JButton getM() {
		return m;
	}


	public JButton getW() {
		return w;
	}


	public JButton getX() {
		return x;
	}


	public JButton getC() {
		return c;
	}


	public JButton getV() {
		return v;
	}


	public JButton getB() {
		return b;
	}


	public JButton getN() {
		return n;
	}


	public JButton getComa() {
		return coma;
	}


	public JButton getSemicolon() {
		return semicolon;
	}


	public JButton getColon() {
		return colon;
	}


	public JButton getExclapoint() {
		return exclapoint;
	}


	public JButton getSpace() {
		return space;
	}


	public JButton getEnter() {
		return enter;
	}


	public JPanel getPanel() {
		return pankeybrd;
	}
}

