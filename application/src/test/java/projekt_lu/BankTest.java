package projekt_lu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {
	Bank b = new Bank();

	@Test
	void addAccount_test() {
		b.addAccount("Demouser1", 1);
		b.addAccount("Demouser2", 2);
	}

}
