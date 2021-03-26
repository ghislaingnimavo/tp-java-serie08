package com.ghislaingnimavo.exercice16;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Function;
public class PersonWriter {

	Function<Person, byte[]> personToByteArray = person->{
		byte[]byteArray=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream daos=new DataOutputStream(baos);
		try 
		{			
		 daos.writeInt(person.getAge());
		 daos.writeUTF(person.getLastName());
		 daos.writeUTF(person.getFirstName());
		}
		catch(IOException e)
		{
			 e.getMessage();
		    }
		 byteArray=baos.toByteArray();
		 return byteArray;
	};

	public void writeBinaryFields(List<Person> people, String fileName){
		int nbPeople = people.size();
		try(OutputStream os = new FileOutputStream(fileName))
		{
		 os.write(nbPeople);
         people.forEach(person->{
	      try
	      {
	    	os.write(personToByteArray.apply(person));
	    	os.flush();
	      }
	      catch(IOException e)
	      {
	       System.out.println(e.getMessage());
	      }
	     });
		}	     
	    catch(IOException e)
	    {
	     System.out.println(e.getMessage());
	    }
	   }	
}
