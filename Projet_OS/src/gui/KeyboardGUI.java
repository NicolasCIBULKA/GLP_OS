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
	 * 
	 * 
	 * @author redouane
	 * 
	 */
	private JPanel pankeybrd = new JPanel();

	private JButtonKey button0 = new JButtonKey("48","0");
	private JButtonKey button1= new JButtonKey("49","1");
	private JButtonKey button2= new JButtonKey("50","2");
	private JButtonKey button3= new JButtonKey("51","3");
	private JButtonKey button4= new JButtonKey("52","4");
	private JButtonKey button5= new JButtonKey("53","5");
	private JButtonKey button6= new JButtonKey("54","6");
	private JButtonKey button7= new JButtonKey("55","7");
	private JButtonKey button8= new JButtonKey("56","8");
	private JButtonKey button9 = new JButtonKey("57","9");
	private JButtonKey a = new JButtonKey("97","a");
	private JButtonKey z = new JButtonKey("122","z");
	private JButtonKey e= new JButtonKey("101","e");
	private JButtonKey r= new JButtonKey("114","r");
	private JButtonKey t= new JButtonKey("116","t");
	private JButtonKey y= new JButtonKey("121","y");
	private JButtonKey u= new JButtonKey("117","u");
	private JButtonKey i= new JButtonKey("105","i");
	private JButtonKey o= new JButtonKey("111","o");
	private JButtonKey p= new JButtonKey("112","p");
	private JButtonKey q= new JButtonKey("113","q");
	private JButtonKey s= new JButtonKey("115","s");
	private JButtonKey d= new JButtonKey("100","d");
	private JButtonKey f= new JButtonKey("102","f");
	private JButtonKey g= new JButtonKey("103","g");
	private JButtonKey h= new JButtonKey("104","h");
	private JButtonKey j= new JButtonKey("106","j");
	private JButtonKey k= new JButtonKey("107","k");
	private JButtonKey l= new JButtonKey("108","l");
	private JButtonKey m= new JButtonKey("109","m");
	private JButtonKey w= new JButtonKey("119","w");
	private JButtonKey x= new JButtonKey("120","x");
	private JButtonKey c= new JButtonKey("99","c");
	private JButtonKey v= new JButtonKey("118","v");
	private JButtonKey b= new JButtonKey("98","b");
	private JButtonKey n= new JButtonKey("110","n");
	private JButtonKey coma= new JButtonKey("44",",");
	private JButtonKey semicolon = new JButtonKey("59",";");
	private JButtonKey colon= new JButtonKey("58",":");
	private JButtonKey exclapoint= new JButtonKey("33","!");
	private JButtonKey space= new JButtonKey("32","space");
	private JButtonKey enter = new JButtonKey("enterKey","Enter");
	private JButtonKey substractKey = new JButtonKey("45","-");
	private JButtonKey divideKey = new JButtonKey("47","/");
	private JButtonKey addKey = new JButtonKey("43","+");
	private JButtonKey equalSign = new JButtonKey("61","=");
	private JButtonKey multiplyKey = new JButtonKey("42","*");
	
	
	
	//used to position the key and add the action listeners via a loop
	private JButtonKey[] row1= {button0,button1,button2,button3,button4,button5,button6,button7,button8,button9};
	private JButtonKey[] row2= {a,z,e,r,t,y,u,i,o,p};
	private JButtonKey[] row3= {q,s,d,f,g,h,j,k,l,m};
	private JButtonKey[] row4= {w,x,c,v,b,n,coma, semicolon,colon, exclapoint};
	private JButtonKey[][]rows= {row1,row2,row3,row4};
	
	
	//--------------------------------------
	//methods
	//--------------------------------------
	
	public KeyboardGUI() {
		pankeybrd.setPreferredSize(new Dimension(800,400));
		pankeybrd.setBorder(BorderFactory.createTitledBorder("keyboard"));
		GridBagLayout gridkey = new GridBagLayout();
		GridBagConstraints keyConstraint = new GridBagConstraints();
		pankeybrd.setLayout(gridkey);
		keyConstraint.fill=GridBagConstraints.BOTH;
			
		//regular keys
		
		
		
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
		
		//last row of the keyboard, not handled in the loop because of the spacebar and enter key 
		keyConstraint.gridy=5;
		keyConstraint.gridx=0;
		pankeybrd.add(substractKey,keyConstraint);
		keyConstraint.gridx=1;
		pankeybrd.add(divideKey,keyConstraint);
		keyConstraint.gridx=2;
		keyConstraint.gridwidth=3;
		keyConstraint.weightx=1;
		pankeybrd.add(space,keyConstraint);
		keyConstraint.gridwidth=1;
		keyConstraint.weightx=0;
		keyConstraint.gridx=5;
		pankeybrd.add(addKey,keyConstraint);
		keyConstraint.gridx=6;
		pankeybrd.add(equalSign,keyConstraint);
		keyConstraint.gridx=7;
		pankeybrd.add(multiplyKey,keyConstraint);
		keyConstraint.gridwidth=2;
		keyConstraint.gridx=8;
		keyConstraint.weightx=1;
		pankeybrd.add(enter ,keyConstraint);
	}
	
	
	
	//getters
	



	public JPanel getPanel() {
		return pankeybrd;
	}



	public JButtonKey getSubstractKey() {
		return substractKey;
	}



	public JButtonKey getDivideKey() {
		return divideKey;
	}



	public JButtonKey getAddKey() {
		return addKey;
	}



	public JButtonKey getEqualSign() {
		return equalSign;
	}



	public JButtonKey getMultiplyKey() {
		return multiplyKey;
	}



	public JPanel getPankeybrd() {
		return pankeybrd;
	}



	public JButtonKey getButton0() {
		return button0;
	}



	public JButtonKey getButton1() {
		return button1;
	}



	public JButtonKey getButton2() {
		return button2;
	}



	public JButtonKey getButton3() {
		return button3;
	}



	public JButtonKey getButton4() {
		return button4;
	}



	public JButtonKey getButton5() {
		return button5;
	}



	public JButtonKey getButton6() {
		return button6;
	}



	public JButtonKey getButton7() {
		return button7;
	}



	public JButtonKey getButton8() {
		return button8;
	}



	public JButtonKey getButton9() {
		return button9;
	}



	public JButtonKey getA() {
		return a;
	}



	public JButtonKey getZ() {
		return z;
	}



	public JButtonKey getE() {
		return e;
	}



	public JButtonKey getR() {
		return r;
	}



	public JButtonKey getT() {
		return t;
	}



	public JButtonKey getY() {
		return y;
	}



	public JButtonKey getU() {
		return u;
	}



	public JButtonKey getI() {
		return i;
	}



	public JButtonKey getO() {
		return o;
	}



	public JButtonKey getP() {
		return p;
	}



	public JButtonKey getQ() {
		return q;
	}



	public JButtonKey getS() {
		return s;
	}



	public JButtonKey getD() {
		return d;
	}



	public JButtonKey getF() {
		return f;
	}



	public JButtonKey getG() {
		return g;
	}



	public JButtonKey getH() {
		return h;
	}



	public JButtonKey getJ() {
		return j;
	}



	public JButtonKey getK() {
		return k;
	}



	public JButtonKey getL() {
		return l;
	}



	public JButtonKey getM() {
		return m;
	}



	public JButtonKey getW() {
		return w;
	}



	public JButtonKey getX() {
		return x;
	}



	public JButtonKey getC() {
		return c;
	}



	public JButtonKey getV() {
		return v;
	}



	public JButtonKey getB() {
		return b;
	}



	public JButtonKey getN() {
		return n;
	}



	public JButtonKey getComa() {
		return coma;
	}



	public JButtonKey getSemicolon() {
		return semicolon;
	}



	public JButtonKey getColon() {
		return colon;
	}



	public JButtonKey getExclapoint() {
		return exclapoint;
	}



	public JButtonKey getSpace() {
		return space;
	}
	public JButtonKey getEnter() {
		return enter;
	}



	public JButtonKey[] getRow1() {
		return row1;
	}



	public JButtonKey[] getRow2() {
		return row2;
	}



	public JButtonKey[] getRow3() {
		return row3;
	}



	public JButtonKey[] getRow4() {
		return row4;
	}



	public JButtonKey[][] getRows() {
		return rows;
	}
	
}

