package projekt_lu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {
	Bank b;

	@BeforeEach
	void setUp() throws Exception {
		b = new Bank();
	}

	@Test
	void addAccount_test() {
		b.addAccount("Demouser1", 1);
		b.addAccount("Demouser2", 2);
	}

	@Test
	void addAccount_duplicate_test() {
		b.addAccount("Demouser1", 1);
		b.addAccount("Demouser1", 1);
		assert(b.getAllAccounts().size() == 1);
	}

	@Test
	void findHolder_test_exist() {
		b.addAccount("Alan", 3232);
		assert(b.findHolder(3232).getName().equals("Alan"));
	}

	@Test
	void findHolder_test_nonexist() {
		assertNull(b.findHolder(3232));
	}

	@Test
	void removeAccount_test() {
		b.addAccount("Alan", 123);
		int acc_nbr = b.findAccountsForHolder(123).get(0).getAccountNumber();
		b.removeAccount(acc_nbr);
		assert(b.accounts.isEmpty());
	}

	@Test
	void getAllAccounts_test() {
		b.addAccount("One", 0);
		b.addAccount("Two", 1);
		b.addAccount("Three", 2);
		assert(b.getAllAccounts().size() == 3);
	}
	
	@Test
	void findByNumber_test() {
		b.addAccount("LempelZiv", 77);
		int acc_nbr = b.findAccountsForHolder(77).get(0).getAccountNumber();
		assert(b.findByNumber(acc_nbr).getHolder().getName().equals("LempelZiv"));
	}

	@Test
	void findAccountsByHolder_test() {
		b.addAccount("LempelZiv", 77);
		b.addAccount("LempelZuv", 78);
		b.addAccount("LempelZav", 79);
		int acc_nbr = b.findAccountsForHolder(77).get(0).getAccountNumber();
		assert(b.findByNumber(acc_nbr).getHolder().getName().equals("LempelZiv"));
	}

	@Test
	void findByPartOfName_test() {
		b.addAccount("LempelZiv", 77);
		b.addAccount("LempelZuv", 78);
		b.addAccount("LempelZav", 79);
		b.addAccount("King", 100);
		b.addAccount("Kong", 101);
		b.addAccount("Mario", 102);
		assert(b.findByPartofName("pelz").size() == 3);
	}
}