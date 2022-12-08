package projekt_lu;

public class BankAccount {
	private Customer holder;
	private double balance = 0;
	private int accNbr =  0;
	/**
	* Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och
	* id 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
	* inledningsvis 0 kr.
	*/
	BankAccount(String holderName, long holderId)  {
		this(new Customer(holderName, holderId));
	}
	/**
	* Skapar ett nytt bankkonto med innehavare 'holder'. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	BankAccount(Customer holder) {
		this.holder = holder;
		this.accNbr = (int)(Math.random()*10);
	}
	/** Tar reda på kontots innehavare. */
	Customer getHolder() {
		return this.holder;
	}
	/** Tar reda på det kontonummer som identifierar detta konto. */
	int getAccountNumber() {
		return this.accNbr;
	}
	/** Tar reda på hur mycket pengar som finns på kontot. */
	double getAmount() {
		return this.balance;
	}
	/** Sätter in beloppet 'amount' på kontot. */
	void deposit(double amount) {
		this.balance += amount;
	}
	/**
	* Tar ut beloppet 'amount' från kontot. Om kontot saknar täckning
	* blir saldot negativt.
	*/
	void withdraw(double amount) {
		this.balance -= amount;
	}
	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return String.format("%f %s", this.balance, this.holder);
	}
}
