package projekt_lu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
	BankAccount bankacc;

	@BeforeEach
	void setUp() throws Exception {
		bankacc = new BankAccount(new Customer("Test", 123));
	}

	@Test
	void constructorCustomer() {
		BankAccount b = new BankAccount(new Customer("Test", 123));
		assertNotNull(b);
	}

	@Test
	void constructorNameId() {
		BankAccount b = new BankAccount("Demo", 321);
		assertNotNull(b);
	}

	@Test
	void deposit_test() {
		bankacc.deposit(100);
		assertEquals(bankacc.getAmount(), 100); // WARNING FLOATING POINT COMPARISON
	}

	@Test
	void withdraw_test() {
		bankacc.withdraw(100);
		assertEquals(bankacc.getAmount(), -100); // WARNING FLOATING POINT COMPARISON
	}

	@Test
	void getHolder_test() {
		assertEquals(bankacc.getHolder(), new Customer("Test", 123));
	}

	@Test
	void getAccountNbr_test() {
		bankacc.getAccountNumber(); // Should be a random integer
	}
	
	@Test
	void getBalance_test() {
		bankacc.deposit(5);
		assertEquals(bankacc.getAmount(), 5);
	}
	
	// TODO: Implement a toString format check
	@Test
	void toString_implemended() {
		assertNotNull(bankacc.toString());
	}
}
