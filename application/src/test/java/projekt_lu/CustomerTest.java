package projekt_lu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	Customer c;

	@BeforeEach
	void setUp() throws Exception {
		c = new Customer("testname", 100);
	}

	@Test
	void getName_test() {
		assertEquals(c.getName(), "testname");
	}

	@Test
	void getIdNr_test() {
		assertEquals(c.getIdNr(), 100);
	}

	@Test
	void getCustomerNr_test_default_initialized() {
		assertEquals(c.getCustomerNr(), 0); // Defaults to zero
	}

	@Test
	void getCustomerNr_test() {
		c.cNr = 10;
		assertEquals(c.getCustomerNr(), 10);
	}

	@Test
	void equals_test() {
		Customer a = new Customer("ASDF", 1234);
		Customer b = new Customer("ASDF", 1234);
		assertEquals(a, b);
	}
}
