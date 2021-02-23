import java.io.*;
import java.util.Scanner;
public class proj2 
{
	static boolean running =true;
	public static void main(String[] args)
	{	
		while(running)
		{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the name of an ASCII file that contains a sorted list of integer numbers, one per line: ");
		String fileName = kb.nextLine();
		System.out.println("Please enter the name of the output file that saves the result from the program: ");
		String fileOut = kb.nextLine();
		

	//	int sum =0; 
		try
		{
			BufferedReader input;
			String inputLine;

			PrintWriter output;
			output = new PrintWriter(new FileOutputStream(fileOut));
	
			String previous="";		
			input = new BufferedReader(new FileReader(fileName));
			boolean first = true;
			while ((inputLine = input.readLine()) != null)
			{
				if (first)
				{
					System.out.print("FIRST");
					previous = inputLine;
					output.println(previous);
					first=false;
				}
				else
					{
						if(previous.equals(inputLine))
						{
							System.out.println("NOT Adding ");					//nada
						}	
						else
						{
							output.println(inputLine);
							System.out.println("Adding : "+ inputLine);
							previous = inputLine;
						}	

					}	
						
			}
			output.close();
			input.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println(f.getMessage());
			System.exit(1);
		}		
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Do you want to run the program again (y for yes and n for no): ");
		String runAgain = kb.nextLine();
		if(runAgain.equalsIgnoreCase("n") || runAgain.equalsIgnoreCase("no"))
		{
			running=false;
		}

		}
}
}
			
