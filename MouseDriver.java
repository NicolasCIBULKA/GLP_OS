package data.drivers;
import data.peripheral.*;

public class MouseDriver extends Driver{

	/*
	 * the driver is supposed to tell where the mouse is. Constant values might be used
	 * in this class. A constant values repository will be created later but
	 * some values will be defined here for testing purpose on early versions
	 * 
	 * 
	 * @version 1.0
	 */
	
	
	private Mouse mouse;

	
	public MouseDriver(String driverID, Interaction authorization, Mouse mouse) {
		super(driverID, authorization);
		this.mouse=mouse;
	}
	
	
	/*
	 * move methods: up, down, left, right
	 * might add a click method later
	 * 
	 * @author rédouane débart
	 */
	
	public void moveUp() {
		mouse.moveUp();
	}
	
	public void moveDown() {
		mouse.moveDown();
	}
	
	public void moveLeft() {
		mouse.moveLeft();
	}
	
	public void moveRight(){
		mouse.moveRight();
	}
	public Point clic() {
		return mouse.getPosition();
	}
}

