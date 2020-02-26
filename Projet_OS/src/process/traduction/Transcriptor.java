package process.traduction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import data.arithmeticaloperation.*;
import data.functions.Print;
import data.functions.Sleep;
import data.iftest.Ifelsetest;
import data.loop.ForLoop;
import data.processus.Operation;
import data.processus.Processus;
import data.variable.*;

public class Transcriptor {
	/*
	 *  This is the class that will translate a pseudo coded programm into a Processus
	 *  
	 *  @Author Nicolas CIBULKA
	 */
	
	
	// --------------------------------------
	// Constants
	// --------------------------------------
	
	private static int identifier_loop_test_function_allocate_POSITION = 0;
	private static int identifier_arithmetical_POSITION = 3;
	
	// --------------------------------------
	// Attributs
	// --------------------------------------

	private HashMap<String, Intvariable> intvariablelist;
	private HashMap<String, Stringvariable> stringvariablelist;
	// --------------------------------------
	// Methods
	// --------------------------------------
	public Transcriptor() {
		intvariablelist = new HashMap<String, Intvariable>();
		stringvariablelist = new HashMap<String, Stringvariable>();
	}
	
	// getters and setters
	
	public void resetlists() {
		intvariablelist.clear();
		stringvariablelist.clear();
	}
	
	// Transcriptor

	public Processus transcription(String filename) {
		//Processus proc = new Processus();
		try {
			/*
			 * Definition of the different attributs
			 */
			
			Processus proc = new Processus();
			BufferedReader procfile = new BufferedReader(new FileReader(filename));
			String line;
			String[] splittedline;
			String identifier_loop_test_function_allocate;
			int currentline = 1;

			/*
			 * Traduction
			 */
			
			while((line = procfile.readLine()) != null) {
				// Split of the line & definition of the place of the identifier
				splittedline = line.split(" ");
				identifier_loop_test_function_allocate = splittedline[identifier_loop_test_function_allocate_POSITION];
				// Test of the first line to set the processusname
				if(identifier_loop_test_function_allocate == "PROCESSUSNAME") {
					proc.setProcessusname(splittedline[1]);
				}
				// Test if the line create a Forloop Processus
				else if(identifier_loop_test_function_allocate == "FOR") {
					if(splittedline.length == 7) {
						Processus forproc = new Processus();
						String var = splittedline[1];
						if(intvariablelist.containsKey(var)) {
							int i = Integer.parseInt(splittedline[3]);
							int limit = Integer.parseInt(splittedline[5]);
							ForLoop forloop = new ForLoop(forproc, intvariablelist.get(var) , i, limit);
							while(!line.contains("}")) {
								Operation loopoperation = operationfinder(line, currentline);
								forloop.getOperations().addOperation(loopoperation);
								line = procfile.readLine();
								currentline++;
							}
							proc.addOperation(forloop);
						}
						else {
							Operation error = new Print("Error on line " + currentline + " : Int variable in for loop does not exists : " + line + "\n");
							proc.addOperation(error);
						}
					}
					else {
						Operation error = new Print("Error on line " + currentline + " : Invalid number of arguments in for loop : " + line + "\n");
						proc.addOperation(error);
					}
				}
				// Test if the line create a Ifelsetest
				else if(identifier_loop_test_function_allocate == "IF") {
					if(splittedline.length == 5) {
						Processus ifproc = new Processus();
						Processus elseproc = new Processus();
						String nb1 = splittedline[1];
						String comparator = splittedline[2];
						String nb2 = splittedline[3];
						Intvariable result = new Intvariable("result",0);
						if((intvariablelist.containsKey(nb1)) && (intvariablelist.containsKey(nb2))) {
							Comparaison comparaison = new Comparaison(intvariablelist.get(nb1), intvariablelist.get(nb2), result, comparator);
							while(!line.contains("}")) {
								Operation ifoperation = operationfinder(line, currentline);
								ifproc.addOperation(ifoperation);
								line = procfile.readLine();
								currentline++;
							}
							line = procfile.readLine();
							if(line.contains("ELSE")){
								while(!line.contains("}")) {
									Operation elseoperation = operationfinder(line, currentline);
									elseproc.addOperation(elseoperation);
									line = procfile.readLine();
									currentline++;
								}
								Ifelsetest ifelse = new Ifelsetest(ifproc, elseproc, comparaison);
								proc.addOperation(ifelse);
							}
						}
						else {
							Operation error = new Print("Error on line " + currentline + " : Else element in Elseif does not exists : " + line + "\n");
							proc.addOperation(error);
						}
					}
					else {
						Operation error = new Print("Error on line " + currentline + " : Invalid number of arguments in Ifelse test : " + line + "\n");
						proc.addOperation(error);
					}
				}
				// Going there means that the line means create a parameter, or using a function
				else {
					Operation operation = operationfinder(line, currentline);
					proc.addOperation(operation);
				}
				currentline++;
			}
			procfile.close();
			resetlists();
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		return null;
	}
	
	
	/*
	 * Methods that identify the Operation with the line
	 */
	
	public Operation operationfinder(String analysedline, int linenumber) {
		
		String[] splittedline;
		splittedline = analysedline.split(" ");
		String identifier_loop_test_function_allocate = splittedline[identifier_loop_test_function_allocate_POSITION];
		String identifier_arithmetical = splittedline[identifier_arithmetical_POSITION];
		if(identifier_arithmetical.equals("+")) {
			if(splittedline.length == 5) {
				String op1 = splittedline[2];
				String op2 = splittedline[4];
				String sol = splittedline[0];
				if((intvariablelist.containsKey(op1)) && (intvariablelist.containsKey(op2)) && (intvariablelist.containsKey(sol))) {
					Operation operation = new Addition(intvariablelist.get(op1), intvariablelist.get(op2), intvariablelist.get(sol));
					return operation;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Addition with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
			}
		}
		
		else if(identifier_arithmetical.equals("-")) {
			if(splittedline.length == 5) {
				String op1 = splittedline[2];
				String op2 = splittedline[4];
				String sol = splittedline[0];
				if((intvariablelist.containsKey(op1)) && (intvariablelist.containsKey(op2)) && (intvariablelist.containsKey(sol))) {
					Operation operation = new Substraction(intvariablelist.get(op1), intvariablelist.get(op2), intvariablelist.get(sol));
					return operation;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Substraction with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
		
			}
		}
		
		else if(identifier_arithmetical.equals("*")) {
			if(splittedline.length == 5) {
				String op1 = splittedline[2];
				String op2 = splittedline[4];
				String sol = splittedline[0];
				if((intvariablelist.containsKey(op1)) && (intvariablelist.containsKey(op2)) && (intvariablelist.containsKey(sol))) {
					Operation operation = new Multiplication(intvariablelist.get(op1), intvariablelist.get(op2), intvariablelist.get(sol));
					return operation;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Multiplication with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
			}
		}				
			
		/*
		 * Tests if the line do an function 
		 */
		
		// test of the Sleep function
		else if(identifier_loop_test_function_allocate.equals("SLEEP")) {
			if(analysedline.length() == 2) {
				int time = Integer.parseInt(splittedline[1]);
				Operation operation = new Sleep(time);
				return operation;
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Sleep function with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
			}
		}
		// Test of the Print function
		else if(identifier_loop_test_function_allocate.equals("PRINT")) {
			if(analysedline.length() == 2) {
				if(stringvariablelist.containsKey(splittedline[1])) {
					Operation operation = new Print(stringvariablelist.get(splittedline[1]));
					return operation;
				}
				else {
					Operation error = new Print("Error on line " + linenumber + " : String variable on Print function does not exist : " + analysedline + "\n");
					return error;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Print function with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
			}
		}
		/*
		 * Tests if the line do an allocation
		 */
		
		// Test for a int allocation
		else if(identifier_loop_test_function_allocate.equals("INT")) {
			if(analysedline.length() == 4) {
				if(stringvariablelist.containsKey(splittedline[1])) {
					Operation error = new Print("Error on line " + linenumber + " : Int variable allocation already exists as a String variable : " + analysedline + "\n");
					return error;
				}
				else if(intvariablelist.containsKey(splittedline[1])) {
					int value = Integer.parseInt(splittedline[3]);
					intvariablelist.get(splittedline[1]).setContent(value);
				}
				else {
					int value = Integer.parseInt(splittedline[3]);
					Operation operation = new Intvariable(splittedline[1], value);
					return operation;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Int variable allocation has an incorrect number of parameter : " + analysedline + "\n");
				return error;
			}
		}
		// Test for a String allocation
		else if(identifier_loop_test_function_allocate.equals("STRING")) {
			if(splittedline[2] == "=") {
				String result = " ";
				for(int i = 3; i < splittedline.length; i++) {
					result += splittedline[i];
				}
				result = result.replaceAll(result, "\"");
				Operation operation = new Stringvariable(splittedline[1], result);
				return operation;
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : String variable allocation has an incorrect synthax : " + analysedline + "\n");
				return error;
			}
		}
		/*
		 * If we go in else, that means that the command haven't been recognized and we have to stop the interpretation
		*/
		Operation error = new Print("Error on line " + linenumber + " : Operation not recognized : " + analysedline + "\n");
		return error;
	}
	
}


