package projekt_lu;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Bank {
	ArrayList<BankAccount> accounts;
	int account_count;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		this.accounts = new ArrayList<BankAccount>();
	}

	/**
	* Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
	* med de givna uppgifterna ska inte en ny Customer skapas, utan istället
	* den befintliga användas. Det nya kontonumret returneras.
	*/
	int addAccount(String holderName, long idNr) {
		if(!this.accounts.stream().anyMatch(e -> e.getHolder().getIdNr() == idNr)) {
			this.accounts.add(new BankAccount(new Customer(holderName, idNr)));
			return 0;
		}
		return 1;
	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	Customer findHolder(long idNr) {
		BankAccount b = this.accounts.stream().filter(acc -> acc.getHolder().getIdNr() == idNr).findAny().orElse(null);
		return b != null ? b.getHolder() : null;
	}

	/**
	 * Tar bort konto med nummer 'number' från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	boolean removeAccount(int number) {
		return this.accounts.removeIf(acc -> acc.getAccountNumber() == number);
	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	ArrayList<BankAccount> getAllAccounts() {
		return this.accounts;
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	 * Returnerar null om inget sådant konto finns.
	 */
	BankAccount findByNumber(int accountNumber) {
		return this.accounts.stream().filter(acc -> acc.getAccountNumber() == accountNumber).findAny().orElse(null);
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		return this.accounts.stream().filter(acc -> acc.getHolder().getIdNr() == idNr).collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen 'namePart' inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> c_list = new ArrayList<Customer>();
		this.accounts.stream().filter(acc -> acc.getHolder().getName().toLowerCase().contains(namePart.toLowerCase())).forEach(acc -> c_list.add(acc.getHolder()));
		return c_list;
	}
}
