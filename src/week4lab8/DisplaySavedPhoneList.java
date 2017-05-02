
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class DisplaySavedPhoneList
{
	public static void main(String[] args)
	{
		Path fileName = Paths.get("PhoneBook.txt");
		Path file = fileName.toAbsolutePath();

		final String delimiter = ",";

		String s = "";

		try
		{
			InputStream inputFile = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));

			s = reader.readLine();

			while(s != null)
			{
				String[] contact = s.split(delimiter);
				prettyPrint(contact);

				s = reader.readLine();
			}

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