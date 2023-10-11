// written by le000422

import java.io.*;
import java.util.*;
public class Dictionary{
	private static ArrayList<DictionaryEntry> dictionary = new ArrayList<DictionaryEntry>();
	public static void getInput(Scanner scan) throws IOException{
		int countDictionaryInput = 0;
		String respond;
		boolean validFile;
		do{
			validFile = false;
			while(!validFile){
				try{
					System.out.print("Name of a dictionary file: ");
					String nameFileInput = scan.next();
					File f = new File(nameFileInput);
					Scanner readFile = new Scanner(f);
					validFile = true;
					populateDictionary(readFile, countDictionaryInput);
					countDictionaryInput += 1;
				}
				catch(FileNotFoundException e){
					System.out.println("File not found error. Try again!");
				}
			}
			System.out.print("Do you want to add another file?(y/n) ");
			respond = scan.next();
		} while(respond.compareToIgnoreCase("y") == 0);

		System.out.println("The dictionary is ready!");
	}
	public static void populateDictionary(Scanner readFile, int countDictionaryInput){
		String [] temp; 
		DictionaryEntry temp1;

		if (countDictionaryInput == 0){
			while (readFile.hasNextLine()){
				temp = readFile.nextLine().split(" - ");
				temp1 = new DictionaryEntry(temp[0],temp[1]);
				dictionary.add(temp1);
			}
		}
		else{
			while (readFile.hasNextLine()){
				temp = readFile.nextLine().split(" - ");
				temp1 = new DictionaryEntry(temp[0],temp[1]);
				boolean exist = false;
				for (int i = 0; i < dictionary.size(); i++){
					if (dictionary.get(i).getData()[0].compareTo(temp[0])==0){
						dictionary.set(i, temp1);
						exist = true;
						break;
					}
				}
				if (!exist){
					dictionary.add(temp1);
				}
			}
			Collections.sort(dictionary);
		}
		readFile.close();
	}
	public static void search (Scanner scan){
		String string;
		System.out.print("Search: ");
		do{
			string = scan.nextLine();
		}while(string.length() == 0);

		int count = 0;
		for (DictionaryEntry phrase: dictionary){
			if (phrase.getData()[0].length() >= string.length()){
				if (phrase.getData()[0].substring(0,string.length()).compareToIgnoreCase(string) == 0){
					count += 1;
					System.out.println(phrase.toString());
				}
			}
		}
		if (count == 0){
			System.out.println("There is no match!");
		}
	
	}
	public static void delete (Scanner scan){
		String string;
		System.out.print("Delete: ");
		do{
			string = scan.nextLine();
		}while(string.length() == 0);
		int count = 0;
		for (int i = 0; i < dictionary.size(); i++){
			if (dictionary.get(i).getData()[0].length() >= string.length()){
				if(dictionary.get(i).getData()[0].substring(0, string.length()).compareToIgnoreCase(string) == 0){
					count += 1;
				}
			}
			if (count == 2){
				break;
			}
		}

		switch (count){
			case 0:
				System.out.println("There is no match!");
				break;
			case 1:
				for (int i = 0; i < dictionary.size(); i++){
					if (dictionary.get(i).getData()[0].length() >= string.length()){
						if(dictionary.get(i).getData()[0].substring(0, string.length()).compareToIgnoreCase(string) == 0){
							dictionary.remove(i);
							break;
						}
					}
				}
				System.out.println("Word/ Phrase " + "\"" + string + "\"" + " has been successfully removed!");
				break;
			case 2:
				System.out.println("There are several matches!");
				for (int i = 0; i < dictionary.size(); i++){
					if (dictionary.get(i).getData()[0].length() >= string.length()){
						if(dictionary.get(i).getData()[0].substring(0, string.length()).compareToIgnoreCase(string) == 0){
							System.out.println(dictionary.get(i).getData()[0]);
						}
					}
				}

				System.out.print("\nDo you want to try again?(y/n) ");
				String ans = scan.nextLine();
				if (ans.compareTo("y") == 0){
					delete(scan);
				}

		}

	}
	public static void add (Scanner scan){
		String string;
		String def;
		System.out.print("Word/Phrase: ");
		do{
			string = scan.nextLine();
		}while(string.length() == 0);

		System.out.print("Definition: ");
		do{
			def = scan.nextLine();
		}while(def.length() == 0);

		int count = 0;
		for (int i = 0; i < dictionary.size(); i++){
			if (dictionary.get(i).getData()[0].compareToIgnoreCase(string) == 0){
				count = 1;
				System.out.println("The word/phrase already exists.");
				break;
			}
		}
		if (count == 0){
			DictionaryEntry woP = new DictionaryEntry(string, def);
			dictionary.add(woP);
			Collections.sort(dictionary);
			System.out.println("The word/phrase has been added successfully!");
		}
	}
	public static void update(Scanner scan){
		String string;
		String def;

		System.out.print("Word/Phrase: ");
		do{
			string = scan.nextLine();
		}while(string.length() == 0);

		System.out.print("Definition: ");
		do{
			def = scan.nextLine();
		}while(def.length() == 0);

		int count = 0;
		for (int i = 0; i < dictionary.size(); i++){
			if (dictionary.get(i).getData()[0].compareToIgnoreCase(string) == 0){
				count = 1;
				dictionary.set(i, new DictionaryEntry(string, def));
				break;
			}
		}
		if (count == 0){
			System.out.println("There is no an exact match!");
		}
		else{
			System.out.println("Update successfully!");
		}
	}
	public static void close(Scanner scan) throws IOException{
		System.out.print("Name of the output file: ");
		String nameFile = scan.next();
		BufferedWriter output = new BufferedWriter(new FileWriter(nameFile, true));
		for (DictionaryEntry woP: dictionary){
			output.write(woP + "\n");
		}
		output.close();
		System.out.println("The dictionary has been closed!");

	}
	public static void main(String [] args) throws IOException{
		String command = "\nWhat do you want to do?\n\t(s) search\n\t(d) delete\n\t(a) add\n\t(u) update\n\t(c) close";
		Scanner scan = new Scanner(System.in);
		getInput(scan);
		String respond;

		do{
			System.out.println(command);
			respond = scan.next();
			while(respond.length() != 1){
				System.out.print("Wrong command!");
				System.out.println(command);
				respond = scan.next();
			}
			switch(respond.toLowerCase().charAt(0)){
				case 's':
					search(scan);
					break;
				case 'd':
					delete(scan);
					break;
				case 'a':
					add(scan);
					break;
				case 'u':
					update(scan);
					break;
				case 'c':
					close(scan);
					break;
				default:
					System.out.println("Wrong command. Try again.");
			}
		}while(respond.compareToIgnoreCase("c") != 0);
	}
}