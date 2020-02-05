package data;
import data.Interaction;

public class MouseDriver extends Driver{

	/*
	 * the driver is supposed to tell where the mouse is. Constant values might be used
	 * in this class. A constant values repository will be created later but
	 * some values will be defined here for testing purpose on early versions
	 * 
	 * 
	 * @version 1.0
	 */
	
	private final int BASICMOVEVALUE=1;
	
	private Mouse mouse;
	private Point registeredPosition;

	
	public MouseDriver(String driverID, Interaction authorization, String linkperipheral, Mouse mouse) {
		super(driverID, authorization, linkperipheral);
		this.mouse=mouse;
		registeredPosition=mouse.getPosition();
	}
	/*
	 * test constructor
	 */
	public MouseDriver(Mouse mouse) {
		this.mouse=mouse;
		registeredPosition=mouse.getPosition();
	}
	
	
	/*
	 * move methods: up, down, left, right
	 * might add a click method later
	 * 
	 * @author rédouane débart
	 */
	
	public void moveUp() {
		registeredPosition.setOrdonnee(registeredPosition.getOrdonnee()+BASICMOVEVALUE);
	}
	
	public void moveDown() {
		registeredPosition.setOrdonnee(registeredPosition.getOrdonnee()-BASICMOVEVALUE);
	}
	
	public void moveLeft() {
		registeredPosition.setAbscisse(registeredPosition.getAbscisse()-BASICMOVEVALUE);
	}
	
	public void moveRight(){
		registeredPosition.setAbscisse(registeredPosition.getAbscisse()+BASICMOVEVALUE);
	}
	
	
	
}
