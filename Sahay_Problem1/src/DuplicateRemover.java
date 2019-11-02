import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class DuplicateRemover 
{
	
	public HashSet<String> uniqueWords;
	
	public void remove(String dataFile)
	{
		try {
		Scanner sc = new Scanner(new File(dataFile));
		uniqueWords = new HashSet<String>();
        while(sc.hasNext())
        {
        	uniqueWords.add(sc.next());
        }
        sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
	public void write(String outputFile)throws IOException
	{
		File output = new File(outputFile);
		FileWriter writer = null;
		if(output.exists()) 
			writer = new FileWriter(output, false);
		else
		{
			output.createNewFile();
			writer = new FileWriter(output);
		}
		Iterator<String> i = uniqueWords.iterator();
		while(i.hasNext())
		{
			writer.write((String)i.next()+"\n");     
		}
		writer.close();
	}

}
