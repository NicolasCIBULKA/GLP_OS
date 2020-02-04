package data;
import data.Interaction;

public class MouseDriver extends Driver{

	/*
	 * the driver is supposed to tell that the mouse is moving,
	 * tell where the mouse is,
	 * and not moving it if the bound of the screen is reached.
	 * the constant value MAXVALUE represents the format of the screen,
	 * it's value might change in other version.
	 * 
	 * the constant value MAXVALUE may be moved in a constant repository later.
	 * it is used here for testing purpose.
	 * 
	 * @version 1.0
	 */
	final int MAXVALUE=100;
	final int MINVALUE=-MAXVALUE;
	
	private Mouse mouse;

	
	public MouseDriver(String driverID, Interaction authorization, String linkperipheral, Mouse mouse) {
		super(driverID, authorization, linkperipheral);
		this.mouse=mouse;
	}
	
	
	public void move(int abs, int ord){
		if((mouse.getPosition().getAbscisse()>=MINVALUE)&&(mouse.getPosition().getAbscisse()<=MAXVALUE)) {
			mouse.getPosition().move(abs, 0);
			if((mouse.getPosition().getOrdonnee()>=MINVALUE)&&(mouse.getPosition().getOrdonnee()<=MAXVALUE)) {
				mouse.getPosition().move(0, ord);
			}
		}
		else if((mouse.getPosition().getOrdonnee()>=MINVALUE)&&(mouse.getPosition().getOrdonnee()<=MAXVALUE)) {
			mouse.getPosition().move(0, ord);
		}
	}
}
