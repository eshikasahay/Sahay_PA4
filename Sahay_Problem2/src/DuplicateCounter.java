import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map.Entry;


public class DuplicateCounter 
{
	HashMap<String, Integer> wordCounter;
	
	public void count(String dataFile)
	{
		try {
		Scanner sc = new Scanner(new File(dataFile));
		wordCounter = new HashMap<String, Integer>();
	    while(sc.hasNext())
	    {
	       	String s = sc.next();
	       	if(wordCounter.containsKey(s))
	       		wordCounter.put(s, wordCounter.get(s)+1);
	       	else
	       		wordCounter.put(s, 1);
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
			writer = new FileWriter(output, true);
		else
		{
			output.createNewFile();
			writer = new FileWriter(output);
		}
		
		Iterator<Entry<String, Integer>> i = wordCounter.entrySet().iterator();
		while (i.hasNext()) 
		{			
			HashMap.Entry<String, Integer> pair = (HashMap.Entry<String, Integer>) i.next();
			writer.write(pair.getKey()+" "+pair.getValue()+"\n"); 		
		}
		writer.close();
	}
}
