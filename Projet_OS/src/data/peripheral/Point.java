package data.peripheral;

public class Point {
	
	private final int BASICMOVEVALUE=1;
	
	private int abscisse;
	private int ordonnee;
	
	Point(int abs, int ord){
		this.abscisse=abs;
		this.ordonnee=ord;
	}
	
	Point(){
		abscisse=0;
		ordonnee=0;
	}
	
	public boolean equals(Point p) {
		if((p.getAbscisse()==this.abscisse)&&(p.getOrdonnee()==this.ordonnee)){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * method using a vector coordinates to move the point
	 * @author rédouane débart
	 */
	
	void move(int abs, int ord){
		abscisse+=abs;
		ordonnee+=ord;
	}
	
	
	/*
	 * methods that move the point by incrementing one coordinate.
	 * it will be used if the simulated mouse is moved with a cross to move in
	 * only one direction at a time.
	 * added basic move value
	 * @author rédouane débart
	 */
	
	void moveUp() {
		ordonnee+=BASICMOVEVALUE;
	}
	
	void moveDown() {
		ordonnee-=BASICMOVEVALUE;
	}
	
	void moveRight(){
		abscisse+=BASICMOVEVALUE;
	}
	
	void moveLeft() {
		abscisse-=BASICMOVEVALUE;
	}

	
	/*
	 * getters, setters, and toString method
	 */
	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	@Override
	public String toString() {
		return "Point [abscisse=" + abscisse + ", ordonnee=" + ordonnee + "]";
	}
	
	
	
}
