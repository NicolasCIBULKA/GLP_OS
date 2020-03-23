package process.visitor;

import data.drivers.ScreenDriver;
import data.primitive.Clear;
import data.primitive.Delete;
import data.primitive.Exit;
import data.primitive.Ioctl;
import data.primitive.Kill;
import data.primitive.Nice;
import data.primitive.Pause;
import data.primitive.Primitive;
import data.primitive.Read;
import data.primitive.Write;

public class PrimitiveVisitor implements OSPrimitiveVisitor<Primitive>{
	
	/*
	 * This class can execute all the primitives
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	@Override
	public Primitive visit(Clear node) {
		// This primitive clear the content of the Screen
		ScreenDriver scdriver = (ScreenDriver) node.getDriver();
		scdriver.setScreencontent("");
		return null;
	}

	@Override
	public Primitive visit(Ioctl node) {
		// This primitive add a processus to Round Robin to execute it
		
		return null;
	}

	@Override
	public Primitive visit(Exit node) {
		// This primitive take a processsus in Parameter and pull it off the Round robin to stop it
		return null;
	}

	@Override
	public Primitive visit(Kill node) {
		// This primitive allow us to stop, pause or start again the processus
		return null;
	}

	@Override
	public Primitive visit(Nice node) {
		// This primitive allow us to modify the priority of thd Processus
		return null;
	}

	@Override
	public Primitive visit(Pause node) {
		// This primitive allow us to Pause temporaly a processus
		return null;
	}

	@Override
	public Primitive visit(Read node) {
		// This primitive shows us the content of a HardDisk slot
		return null;
	}

	@Override
	public Primitive visit(Write node) {
		// This primitive allow us to Write on a HardDisk slot
		return null;
	}

	@Override
	public Primitive visit(Delete node) {
		// This primitive allow us to delete a line in a hardDisk slot or to wipe it
		
		
		return null;
	}
	
	

}
