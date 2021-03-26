package com.ghislaingnimavo.exercice17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
public class PersonWriter {

	/*Function<Person, byte[]> personToByteArray = person->{
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
		// TODO Auto-generated catch block
			 e.getMessage();
		    }
		 byteArray=baos.toByteArray();
		 return byteArray;
	};*/

	public void writeBinaryObject(List<Person> people, String fileName){
		int nbPeople = people.size();
		try(OutputStream os = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(os);)
		{
		 oos.writeInt(nbPeople);
         people.forEach(person->{
	      try
	      {
	    	oos.writeObject(person);//(personToByteArray.apply(person));
	    	oos.flush();
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
