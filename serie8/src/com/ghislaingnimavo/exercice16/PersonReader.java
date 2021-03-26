package com.ghislaingnimavo.exercice16;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
	
	public List<Person> readBinaryFields(String fileName){
		 List<Person> people = new ArrayList<Person>();
		 int i=0;
		 int nbPeople;
		 
	      try(FileInputStream fis = new FileInputStream(fileName); DataInputStream dis= new DataInputStream(fis))
	      {
	    	  nbPeople=dis.read();
	    	  for(i=0;i<nbPeople;i++){
	    	    int age = dis.readInt();
	    		String lastName = dis.readUTF();
	    		String firstName =dis.readUTF();
	    		Person p = new Person(lastName,firstName,age);    		
	    		people.add(p);
	       }
	      }
	      catch(IOException e)
	      {
	    	
	      }	
	     return people;
	    }

}