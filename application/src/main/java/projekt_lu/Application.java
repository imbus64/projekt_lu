package projekt_lu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
	static Scanner scanner = new Scanner(System.in);
	static public void print_choices(String... c_list) {
		int index = 1;
		for(String item : c_list) {
			System.out.println(String.format("%d. %s", index, item));
			index++;
		}
	}
	
	static int query_user_select(String query_prompt) {
		System.out.print(query_prompt);
		int select = 0;
		while(true) {
			String input = scanner.next();
			try {
				select = Integer.parseInt(input);
				break;
			}
		    catch (NumberFormatException e) { 
		    	System.out.println("Input is not a number, try again.");
		    }
		}
		return select;
	}
	
	static void print_menu() {
		System.out.println("--------------------------------------------- "
		+"1. Hitta konton utifrån kontoinnehavare."
		+"2. Sök kontoinnehavere på (del av) namn."
		+"3. Sätta in pengar."
		+"4. Ta ut pengar."
		+"5. Överföring mellan konton."
		+"6. Skapa nyttt konto."
		+"7. Ta bort konto."
		+"8. Skriv ut bankens alla konton."
		+"9. Avsluta."
		+" "
		+"--------------------------------------------- "
		+"Välj nummer och tryck enter: ");
	}

    public static void main(String[] args) {

    	print_choices(
		"Hitta konton utifrån kontoinnehavare.",
		"Sök kontoinnehavere på (del av) namn.",
		"Sätta in pengar.",
		"Ta ut pengar.",
		"Överföring mellan konton.",
		"Skapa nyttt konto.",
		"Ta bort konto.",
		"Skriv ut bankens alla konton.",
		"Avsluta."
		);
    	query_user_select("Val: ");
    	

//    	while(true) {
//    	
//    	}
    }
}
