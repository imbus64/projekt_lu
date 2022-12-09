package projekt_lu;

import java.util.Scanner;

public class Application {
	static Scanner scanner = new Scanner(System.in);

	static public void print_choices(String... c_list) {
		int index = 1;
		for (String item : c_list) {
			System.out.println(String.format("%d. %s", index, item));
			index++;
		}
	}

	static int query_user_select(String query_prompt) {
		System.out.print(query_prompt);
		int select = 0;
		while (true) {
			String input = scanner.next();
			try {
				select = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Input is not a number, try again.");
			}
		}
		return select;
	}

	public static void main(String[] args) {
		Bank b = new Bank();
		while (true) {
			print_choices("Hitta konton utifrån kontoinnehavare.", "Sök kontoinnehavere på (del av) namn.",
					"Sätta in pengar.", "Ta ut pengar.", "Överföring mellan konton.", "Skapa nyttt konto.",
					"Ta bort konto.", "Skriv ut bankens alla konton.", "Avsluta.");

			int selection = query_user_select("Val: ");
			switch(selection) {
			case 1:
				int accnr = query_user_select("Kontonummer: ");
				b.findAccountsForHolder(accnr);
			}
		}
	}
}
