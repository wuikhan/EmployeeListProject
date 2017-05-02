
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class WritePhoneList
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userInput;

		// I develop on Linux so this means it will work either way
		Path fileName = Paths.get("PhoneBook.txt");
		Path file = fileName.toAbsolutePath();
		OutputStream outputFile = null;

		final String QUIT = "QUIT";
		final String delimiter = ",";

		System.out.print("Enter contact's first name or " + QUIT + " >> ");
		userInput = input.nextLine();

		try
		{
			outputFile = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputFile));

			while(!(userInput.equals(QUIT)))
			{
				StringBuilder contact = new StringBuilder(userInput);

				System.out.print("Enter contact's last name >> ");
				userInput = input.nextLine();
				contact.append(delimiter + userInput.trim());

				System.out.print("Enter contact's phone number >> ");
				userInput = input.nextLine();
				contact.append(delimiter + userInput.trim());

				contact.append(System.getProperty("line.separator"));
				String s = contact.toString();

				writer.write(s);

				System.out.print("\nEnter contact's first name or " + QUIT + " >> ");
				userInput = input.nextLine();
			}

			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}
}