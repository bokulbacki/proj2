import java.io.*;
import java.util.Scanner;
//Project 2: ASCII Reader
//This program reads a file specified by the user that contains one number per
//line. The program then converts the numberse to doubles and outputs them to
//a user specified file one per line, discarding repeat numbers. 
//The program then outputs the average of the numbers to the last line.
//Dalton Kohl - dkohl@sandiego.edu
//Bo Kulbacki - rkulbacki@sandiego.edu
//Date modified: 3-3-21


public class proj2 
{
	//set the state of the program to running
	static boolean running =true;
	public static void main(String[] args)
	{	
		while(running)
		{
		//scans and saves the names for the input and output files to
		//variables
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the name of an ASCII file that contains a sorted list of integer numbers, one per line: ");
		String fileName = kb.nextLine();
		System.out.println("Please enter the name of the output file that saves the result from the program: ");
		String fileOut = kb.nextLine();
		

		try
		{
			//initialize the variables used for the input file
			BufferedReader input;
			String inputLine;

			//initialize the variable used for the output file
			PrintWriter output;

			//create the output file
			output = new PrintWriter(new FileOutputStream(fileOut));
	
			//reads the input file
			input = new BufferedReader(new FileReader(fileName));
	
			//set variables
			boolean first = true;
			double sum = 0;
			double counter = 0; 
			double number = 0;
			String previous = "";
			
			//loop through each line of the file
			while ((inputLine = input.readLine()) != null)
			{
				//first line of the file
				if (first)
				{
					//System.out.print("FIRST"); Testing Purposes
					//changes the input to a double and saves to the output
					//file and the sum variable
					//incraments the counter variable
					number = Double.parseDouble(inputLine);
					sum += number;
					counter++;
					previous = inputLine;
					output.println(number);
					first=false;
				}
				else
					{
						//the current number is a repeat, nohting is done
						if(previous.equals(inputLine))
						{
							//System.out.println("NOT Adding "); Testing Purposes
						}
						//the current number is not a repeat	
						else
						{
							//changes the input to a double and saves to the output
							//file and the sum variable
							//incraments the counter variable
							number = Double.parseDouble(inputLine);
							output.println(number);
							//System.out.println("Adding : "+ number); Testing Purposes
							previous = inputLine;
							sum += number;
							counter++;
						}	

					}	
						
			}
			//outputs the average to the last line of the file
			output.printf("Average : %.2f%n", (sum/counter));

			//closes the files
			output.close();
			input.close();
		}
		//catches the FileNotFoundException, prints the message and closes
		//exits the program
		catch(FileNotFoundException f)
		{
			System.out.println(f.getMessage());
			System.exit(1);
		}
		//catches the IOException, prints the message and closes
		//exits the program		
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		//asks the user if they would like to run the program again, if no it
		//ends the program		
		System.out.println("Do you want to run the program again (y for yes and n for no): ");
		String runAgain = kb.nextLine();
		if(runAgain.equalsIgnoreCase("n") || runAgain.equalsIgnoreCase("no"))
		{
			running=false;
		}

		}
}
}
			
