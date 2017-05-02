
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DisplaySelectedNumbers
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userInput = "";

		ArrayList<String> matches = new ArrayList<String>();

		Path fileName = Paths.get("PhoneBook.txt");
		Path file = fileName.toAbsolutePath();

		final String delimiter = ",";

		int matchFound = 0;

		System.out.print("Search for >> ");
		userInput = input.nextLine();

		try
		{
			InputStream inputFile = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));

			String s = reader.readLine();

			while(s != null)
			{
				String[] contact = s.split(delimiter);

				userInput = userInput.trim(); // making sure there are no errant spaces
				String lowerSearch = userInput.toLowerCase();

				String lowerFirstName = contact[0].toLowerCase();
				if(lowerFirstName.equals(lowerSearch))
				{
					prettyPrint(contact);
					matchFound++;
				}

				/*
				 * This allows for seaching ANY keyword including
				 * partial names or sections of the phone number.
				 */
				/*
				for(String cs : contact)
				{
					cs = cs.toLowerCase();
					if(cs.indexOf(lowerSearch) > -1)
					{
						prettyPrint(contact);
						matchFound++;
					}
				}
				*/

				s = reader.readLine();
			}

			if(matchFound > 0)
				System.out.println("Found " + matchFound + ".");
			else
				System.out.println("No matches found.");

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}

	public static void prettyPrint(String[] c)
	{
		StringBuilder sb = new StringBuilder();

		for(String s : c)
			sb.append(s + " ");

		System.out.println(sb.toString());
	}
}