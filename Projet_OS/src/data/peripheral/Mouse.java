package data.peripheral;

public class Mouse {
	
	
	private Point position;
	
	
	
	public Mouse(Point position) {
		this.position=position;
	}
	
	public Mouse() {
		this.position=new Point();
	}

	
	/*
	 * getters, setters, and toString methods
	 */
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	
	@Override
	public String toString() {
		return "Mouse [position=" + position + "]";
	}

	
	/*
	 * methods to move the mouse using the Point class methods
	 * check Point class for more info.
	 * 
	 *  @author rédouane débart
	 */
	public void move(int abs, int ord) {
		position.move(abs, ord);
	}
	
	public void moveUp() {
		position.moveUp();
	}
	
	public void moveDown() {
		position.moveDown();
	}
	
	
	public void moveRight() {
		position.moveRight();
	}
	
	public void moveLeft() {
		position.moveLeft();
	}
	
	
}
