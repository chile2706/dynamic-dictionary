// written by le000422

import java.util.Comparator;
public class DictionaryEntry implements Comparable<Object> {

    // instance variables
    private String wordOrPhrase;
	private String definition;

    // constructors
    //public DictionaryEntry() {}

    public DictionaryEntry(String wop, String def) {
        this.wordOrPhrase = wop;
		this.definition = def;
    }

	// You are free to implement other constructors as you see fit

    // You should implement at least the getters and setters below
	
	// returns a String array with the wordOrPhrase at location zero and definition 
	// at location 1
    public String [] getData() {
    	String [] data = new String []{this.wordOrPhrase, this.definition};
    	return data;
    }

	// accepts a String array with the wordOrPhrase at location zero and the definition
	// of the wordOrPhrase at location 1 and sets the variables accordingly
    public void setData(String [] data) {
    	this.wordOrPhrase = data[0];
    	this.definition = data[1];
    }

    @Override
    public String toString(){
        return wordOrPhrase + " - " + definition;
    }
	
	// Define a Comparator method that can be used to sort an ArrayList of Nodes in Lexically
	// Ascending order - that is, from A to Z, according to the wordOrPhrase
	// Note that you must keep the exact method signature provided here

	@Override
	public int compareTo(Object o) {
		DictionaryEntry temp = (DictionaryEntry) o;
		return this.wordOrPhrase.compareToIgnoreCase(temp.getData()[0]);
    }
  

}