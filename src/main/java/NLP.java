package main.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NLP {

	private String[] processinTokens(String path) {
		Reader r = new Reader(path);
		String content = null;
		try {
			content = r.read();
		} catch (IOException e) {
			System.out.println("Cannot load the input file.");
			e.printStackTrace();
		}
		return content.split("[ \t]+");
	}

	private void menu() throws IOException {
		Scanner input = new Scanner(System.in);
		boolean mainLoop = true;
		String[] tokens;
		String path;
		NameFinder n = new NameFinder();
		String y_n;
		String result;
		Write2File w;

		int choice;
		while (true) {
			System.out.println("Natural Language Processing Menu\n");
			System.out.print("1.) Name Finder: Names \n");
			System.out.print("2.) Name Finder: Location.\n");
			System.out.print("3.) Name Finder: Organization.\n");
			System.out.print("4.) Name Finder: Date.\n");
			System.out.print("5.) Sentence Finder.\n");
			System.out.print("6.) Exit\n");
			System.out.print("\nEnter Your Menu Choice: ");
			
			choice = 10;
			try {
			choice = input.nextInt();
			}catch(Exception e) {
				System.out.println("Wrong option!");
			}

			switch (choice) {

			case 1:
				System.out.println("\nPlease Enter The File Path: ");
				path = input.next();
				tokens = processinTokens(path);
				System.out.println("Do you want the result as a sorted list of names? (y/n)");
				y_n = input.next();
				result = new String();
				if (y_n.equals("y") || y_n.equals("Y")) {
					System.out.println("Descending or Ascending order? (asc/desc)");
					String order = input.next();
					result = n.nameFinderOL(tokens, !order.contentEquals("desc"));
				} else {
					result = n.nameFinder(tokens);
				}
				System.out.println("\nPlease The Path To Save The Result: ");
				path = input.next();
				w = new Write2File(path);
				w.writeResult(result);
				break;

			case 2:
				System.out.println("\nPlease Enter The File Path: ");
				path = input.next();
				tokens = processinTokens(path);
				System.out.println("Do you want the result as a sorted list of places? (y/n)");
				y_n = input.next();
				if (y_n.equals("y") || y_n.equals("Y")) {
					System.out.println("Descending or Ascending order? (asc/desc)");
					String order = input.next();
					result = n.locationFinderOL(tokens, !order.contentEquals("desc"));
				} else {
					result = n.locationFinder(tokens);
				}
				System.out.println("\nPlease The Path To Save The Result: ");
				path = input.next();
				w = new Write2File(path);
				w.writeResult(result);
				break;

			case 3:
				System.out.println("\nPlease Enter The File Path: ");
				path = input.next();
				tokens = processinTokens(path);
				System.out.println("Do you want the result as a sorted list of organizations? (y/n)");
				y_n = input.next();
				if (y_n.equals("y") || y_n.equals("Y")) {
					System.out.println("Descending or Ascending order? (asc/desc)");
					String order = input.next();
					result = n.orgFinderOL(tokens, !order.contentEquals("desc"));
				} else {
					result = n.orgFinder(tokens);
				}
				System.out.println("\nPlease The Path To Save The Result: ");
				path = input.next();
				w = new Write2File(path);
				w.writeResult(result);
				break;

			case 4:
				System.out.println("\nPlease Enter The File Path: ");
				path = input.next();
				tokens = processinTokens(path);
				System.out.println("Do you want the result as a sorted list of dates? (y/n)");
				y_n = input.next();
				result = new String();
				if (y_n.equals("y") || y_n.equals("Y")) {
					System.out.println("Descending or Ascending order? (asc/desc)");
					String order = input.next();
					result = n.dateFinderOL(tokens, !order.contentEquals("desc"));
				} else {
					result = n.dateFinder(tokens);
				}
				System.out.println("\nPlease The Path To Save The Result: ");
				path = input.next();
				w = new Write2File(path);
				w.writeResult(result);
				break;

			case 5:
				System.out.println("\nPlease Enter The File Path: ");
				path = input.next();
				Reader r = new Reader(path);
				String content = r.read();
				SentenceFinder st = new SentenceFinder();
				result = st.sentenceDetect(content);
				System.out.println("\nPlease The Path To Save The Result: ");
				path = input.next();
				w = new Write2File(path);
				w.writeResult(result);
				break;

			case 6:
				System.out.println("Exiting Program...");
				System.exit(0);
				break;
			default:
				System.out.println("This is not a valid Menu Option! Please Select Another");
				break;

			}

		}

	}

	public static void main(String[] args) {
		NLP nlp = new NLP();
		try {
		PasswordChecker pC = new PasswordChecker();
		boolean loop = true;
		if(pC.getLoad()) {
			Scanner sc=new Scanner(System.in);
			do {
			System.out.println("Introduce your password : ");
			loop = !pC.checkPassword(sc.next());
			}while(loop);
			System.out.println("Correct password!");
		}else {
			System.out.println("Set the a password for the script : ");
			Scanner sc=new Scanner(System.in);
			pC.setPassword(sc.next());
			System.out.println("Password successfuly set!");
		}
		nlp.menu();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
