package process.traduction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import data.arithmeticaloperation.*;
import data.functions.Decrement;
import data.functions.Increment;
import data.functions.Print;
import data.functions.Sleep;
import data.iftest.Ifelsetest;
import data.loop.ForLoop;
import data.loop.WhileLoop;
import data.processus.Operation;
import data.processus.Processus;
import data.variable.*;
import process.exception.DivisionException;
import process.exception.ImbricationException;

public class Transcriptor {
	/*
	 *  This is the class that will translate a pseudo coded programm into a Processus
	 *  
	 *  @author Nicolas CIBULKA
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
	
	}
	
	// getters and setters

	// Transcriptor

	public void transcription(Processus proc, String filename) {
		try {
			/*
			 * Definition of the different attributs
			 */
			intvariablelist = proc.getVarbuffer().getIntvariablelist();
			stringvariablelist = proc.getVarbuffer().getStringvariablelist();
			BufferedReader procfile = new BufferedReader(new FileReader(filename));
			String line;
			String[] splittedline;
			int currentline = 1;

			/*
			 * Traduction
			 */
			
			while((line = procfile.readLine()) != null) {
				// Split of the line & definition of the place of the identifier
				splittedline = line.split("\\s+");
				// Test of the first line to set the processusname
				if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("PROCESSUSNAME")) {
					proc.setProcessusname(splittedline[1]);
				}
				// Test if the line create a Forloop Processus
				else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("FOR") ) {
					Processus forproc = new Processus();
					String var = splittedline[1];
					if(intvariablelist.containsKey(var)) {
						if(splittedline.length == 7) {
							int i = Integer.parseInt(splittedline[3]);
							int limit = Integer.parseInt(splittedline[5]);
							intvariablelist.get(var).setContent(i);
							ForLoop forloop = new ForLoop(forproc, intvariablelist.get(var) , i, limit);
							line = procfile.readLine();
							while(line.contains("DONE") == false) {
								// We test the case if a ifelse test is called in the loop
								splittedline = line.split(" ");
								if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("IF")) {
									//System.out.println("oui");
									if(splittedline.length == 5) {
										Processus ifproc = new Processus();
										Processus elseproc = new Processus();
										String nb1 = splittedline[1];
										String comparator = splittedline[2];
										String nb2 = splittedline[3];
										Intvariable result = new Intvariable("result",0);
										if((intvariablelist.containsKey(nb1)) && (intvariablelist.containsKey(nb2))) {
											Comparaison comparaison = new Comparaison(intvariablelist.get(nb1), intvariablelist.get(nb2), result, comparator);
											line = procfile.readLine();
											currentline++;
											while(!line.contains("ENDIF")) {
												Operation ifoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
												ifproc.addOperation(ifoperation);
												line = procfile.readLine();
												currentline++;
											}
											line = procfile.readLine();
											currentline++;
											if(line.contains("ELSE")){
												line = procfile.readLine();
												currentline++;
												while(!line.contains("ENDELSE")) {
													Operation elseoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
													elseproc.addOperation(elseoperation);
													line = procfile.readLine();
													currentline++;
												}
												Ifelsetest ifelse = new Ifelsetest(ifproc, elseproc, comparaison);
												forloop.getOperations().addOperation(ifelse);
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
								else {
									Operation loopoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
									//System.out.println( "loopoperation " + loopoperation);
									forloop.getOperations().addOperation(loopoperation);
									
								}
								line = procfile.readLine();
								currentline++;
							}
						currentline++;
						//System.out.println(forloop.getOperations().getOplist());
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
				
				// Test if the line create a Whileloop
				
				else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("WHILE")){
					if(splittedline.length == 5) {
						Processus whileproc = new Processus();
						String nb1 = splittedline[1];
						String comparator = splittedline[2];
						String nb2 = splittedline[3];
						Intvariable result = new Intvariable("result",0);
						if((intvariablelist.containsKey(nb1)) && (intvariablelist.containsKey(nb2))) {
							Comparaison comparaison = new Comparaison(intvariablelist.get(nb1), intvariablelist.get(nb2), result, comparator);
							line = procfile.readLine();
							currentline++;
							while(!line.contains("ENDWHILE")) {
								// We test the case if a ifelse test is called in the loop
								splittedline = line.split(" ");
								if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("IF")) {
									//System.out.println("oui");
									if(splittedline.length == 5) {
										Processus ifproc = new Processus();
										Processus elseproc = new Processus();
										String nb1_ifelse= splittedline[1];
										String comparator_ifelse = splittedline[2];
										String nb2_ifelse = splittedline[3];
										Intvariable result_ifelse = new Intvariable("result",0);
										if((intvariablelist.containsKey(nb1_ifelse)) && (intvariablelist.containsKey(nb2_ifelse))) {
											Comparaison comparaison_ifelse = new Comparaison(intvariablelist.get(nb1_ifelse), intvariablelist.get(nb2_ifelse), result_ifelse, comparator_ifelse);
											line = procfile.readLine();
											currentline++;
											while(!line.contains("ENDIF")) {
												Operation ifoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
												ifproc.addOperation(ifoperation);
												line = procfile.readLine();
												currentline++;
											}
											line = procfile.readLine();
											currentline++;
											if(line.contains("ELSE")){
												line = procfile.readLine();
												currentline++;
												while(!line.contains("ENDELSE")) {
													Operation elseoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
													elseproc.addOperation(elseoperation);
													line = procfile.readLine();
													currentline++;
												}
												Ifelsetest ifelse = new Ifelsetest(ifproc, elseproc, comparaison_ifelse);
												whileproc.addOperation(ifelse);
											}
										}
										else {
											Operation error = new Print("Error on line " + currentline + " : Else element in Elseif does not exists : " + line + "\n");
											proc.addOperation(error);
										}
									}
								}
								else {
									Operation whileoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
									whileproc.addOperation(whileoperation);
								}
								line = procfile.readLine();
								currentline++;
							}
							currentline++;
							WhileLoop whloop = new WhileLoop(whileproc, comparaison);
							proc.addOperation(whloop);
						}
						else {
							Operation error = new Print("Error on line " + currentline + " : Int variable in while loop does not exists : " + line + "\n");
							proc.addOperation(error);
						}
					}
					else {
						Operation error = new Print("Error on line " + currentline + " : Invalid number of arguments in Whileloop : " + line + "\n");
						proc.addOperation(error);
					}
				}
				
				// Test if the line create a Ifelsetest
				else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("IF")) {
					if(splittedline.length == 5) {
						Processus ifproc = new Processus();
						Processus elseproc = new Processus();
						String nb1 = splittedline[1];
						String comparator = splittedline[2];
						String nb2 = splittedline[3];
						Intvariable result = new Intvariable("result",0);
						if((intvariablelist.containsKey(nb1)) && (intvariablelist.containsKey(nb2))) {
							Comparaison comparaison = new Comparaison(intvariablelist.get(nb1), intvariablelist.get(nb2), result, comparator);
							line = procfile.readLine();
							currentline++;
							while(!line.contains("ENDIF")) {
								Operation ifoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
								ifproc.addOperation(ifoperation);
								line = procfile.readLine();
								currentline++;
							}
							line = procfile.readLine();
							currentline++;
							if(line.contains("ELSE")){
								line = procfile.readLine();
								currentline++;
								while(!line.contains("ENDELSE")) {
									Operation elseoperation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
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
					Operation operation = operationfinder(line, currentline, intvariablelist, stringvariablelist);
					if(operation != null) {
						proc.addOperation(operation);
						//System.out.println(proc.getOplist());
					}
				}
				currentline++;
			}
			procfile.close();
			//System.out.println(this.intvariablelist);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ImbricationException e) {
			System.out.println("ERROR : Imbrication of loops in the programm which is impossible, please resolve the error");
		}	
		catch (DivisionException e) {
			System.out.println("ERROR : Tried to divide by 0");
		}	
		
	}
	
	
	/*
	 * Methods that identify the Operation with the line
	 */
	
	public Operation operationfinder(String analysedline, int linenumber,HashMap<String, Intvariable> intvariablelist, HashMap<String, Stringvariable> stringvariablelist) throws ImbricationException, DivisionException {
		String[] splittedline;
		splittedline = analysedline.split(" ");
		// Test if the line is a commentary
		if(splittedline[0].contains("#")) {
			return null;
		}
		// Operation haven't been recognized
		else if(splittedline.length == 5) {
			//System.out.println("addition" + splittedline[3]);
			if(splittedline[identifier_arithmetical_POSITION].contains("+")) {
				//System.out.println("addition" + linenumber);
				String op1 = splittedline[2];
				String op2 = splittedline[4];
				String sol = splittedline[0];
				if((intvariablelist.containsKey(op1)) && (intvariablelist.containsKey(op2)) && (intvariablelist.containsKey(sol))) {
					Addition operation = new Addition(intvariablelist.get(op1), intvariablelist.get(op2), intvariablelist.get(sol));
					return operation;
				}
				
				else {
					Print error = new Print("Error on line " + linenumber + " : Addition with an incorrect number of Parameter : " + analysedline + "\n");
					return error;
				}
			}	
			else if(splittedline[identifier_arithmetical_POSITION].contains("-")) {
				String op1 = splittedline[2];
				String op2 = splittedline[4];
				String sol = splittedline[0];
				if((intvariablelist.containsKey(op1)) && (intvariablelist.containsKey(op2)) && (intvariablelist.containsKey(sol))) {
					Operation operation = new Substraction(intvariablelist.get(op1), intvariablelist.get(op2), intvariablelist.get(sol));
					return operation;
				}
				else {
					Operation error = new Print("Error on line " + linenumber + " : Substraction with an incorrect number of Parameter : " + analysedline + "\n");
					return error;
				}
			}
			else if(splittedline[identifier_arithmetical_POSITION].contains("%")) {
				String op1 = splittedline[2];
				String op2 = splittedline[4];
				String sol = splittedline[0];
				if((intvariablelist.containsKey(op1)) && (intvariablelist.containsKey(op2)) && (intvariablelist.containsKey(sol))) {
					Operation operation = new Modulo(intvariablelist.get(op1), intvariablelist.get(op2), intvariablelist.get(sol));
					return operation;
				}
				else {
					Operation error = new Print("Error on line " + linenumber + " : Modulo with an incorrect number of parameter : " + analysedline + "\n");
					return error;
				}
			}
			else if(splittedline[identifier_arithmetical_POSITION].contains("/")) {
				String op1 = splittedline[2];
				String op2 = splittedline[4];
				String sol = splittedline[0];
				if(! (op2 == "0")) {
					if((intvariablelist.containsKey(op1)) && (intvariablelist.containsKey(op2)) && (intvariablelist.containsKey(sol))) {
						Operation operation = new Division(intvariablelist.get(op1), intvariablelist.get(op2), intvariablelist.get(sol));
						return operation;
					}
					else {
						Operation error = new Print("Error on line " + linenumber + " : Substraction with an incorrect number of Parameter : " + analysedline + "\n");
						return error;
					}
				}
				else {
					throw new DivisionException();
				}
			}
			
			else if(splittedline[identifier_arithmetical_POSITION].contains("*")) {
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
			
		}
		
		/*
		 * Tests if the line do an function 
		 */
		
		// test of the Sleep function
		else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("SLEEP")) {
			if(splittedline.length == 2) {
				int time = Integer.parseInt(splittedline[1]);
				Sleep operation = new Sleep(time);
				return operation;
			}
			else {
				Print error = new Print("Error on line " + linenumber + " : Sleep function with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
			}
		}
		// Test of the Print function
		else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("PRINT")) {
			if(splittedline.length == 2) {
				if(stringvariablelist.containsKey(splittedline[1])) {
					//System.out.println(splittedline[1]);
					Print operation = new Print(stringvariablelist.get(splittedline[1]));
					//System.out.println("operation avant passage " + operation.getPrintop());
					return operation;
				}
				else if(intvariablelist.containsKey(splittedline[1])) {
					Print operation = new Print(intvariablelist.get(splittedline[1]));
					return operation;
				}
				else {
					Print error = new Print("Error on line " + linenumber + " : String variable on Print function does not exist : " + analysedline + "\n");
					return error;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Print function with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
			}
		}
		// test for increment function 
		else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("INCREMENT")) {
			if(splittedline.length == 2) {
				if(intvariablelist.containsKey(splittedline[1])) {
					Increment operation = new Increment(intvariablelist.get(splittedline[1]));
					return operation;
				}
				else {
					Operation error = new Print("Error on line " + linenumber + " : Int variable on Increment function does not exist : " + analysedline + "\n");
					return error;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Increment function with an incorrect number of Parameter : " + analysedline + "\n");
				return error;
			}
		}
		
		// test for decrement function 
				else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("DECREMENT")) {
					if(splittedline.length == 2) {
						if(intvariablelist.containsKey(splittedline[1])) {
							Decrement operation = new Decrement(intvariablelist.get(splittedline[1]));
							return operation;
						}
						else {
							Operation error = new Print("Error on line " + linenumber + " : Int variable on Increment function does not exist : " + analysedline + "\n");
							return error;
						}
					}
					else {
						Operation error = new Print("Error on line " + linenumber + " : Increment function with an incorrect number of Parameter : " + analysedline + "\n");
						return error;
					}
				}
		/*
		 * Tests if the line do an allocation
		 */
		
		// Test for a int allocation
		else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("INT")) {
			if(splittedline.length == 4) {
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
					intvariablelist.put(splittedline[1], (Intvariable) operation);
					return operation;
				}
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : Int variable allocation has an incorrect number of parameter : " + analysedline + "\n");
				return error;
			}
		}
		// Test for a String allocation
		
		else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("STRING")) {
			if(splittedline[2].contentEquals("=")) {
				String result = "";
				for(int i = 3; i < splittedline.length; i++) {
					result += splittedline[i]  + " ";
				}
				//String finalresult = result.replaceAll(result, "\"");
				Stringvariable operation = new Stringvariable(splittedline[1], result);
				stringvariablelist.put(splittedline[1], operation);
				return operation;
			}
			else {
				Operation error = new Print("Error on line " + linenumber + " : String variable allocation has an incorrect synthax : " + analysedline + "\n");
				return error;
			}
		}
		else if(splittedline[identifier_loop_test_function_allocate_POSITION].contains("FOR") || splittedline[identifier_loop_test_function_allocate_POSITION].contains("WHILE")) {
			throw new ImbricationException();
		}
		/*
		 * If we go in else, that means that the command haven't been recognized and we have to stop the interpretation
		*/		
		else {
			Operation error = new Print("Error on line " + linenumber + " : Operation not recognized : " + analysedline + "\n");
			return error;
		}
		return null;
	}
	
}


