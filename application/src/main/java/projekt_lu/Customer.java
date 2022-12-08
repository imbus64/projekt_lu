package projekt_lu;

public class Customer {
	String name;
	long id;
	public int cNr;

	/**
	 * Skapar en kund (kontoinnehavare) med namnet 'name' och id-nummer 'idNr'.
	 * Kunden tilldelas också ett unikt kundnummer.
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.id = idNr;
		this.cNr = 0; // Initialize to zero just to be sure
	}

	/** Tar reda på kundens namn. */
	public String getName() {
		return this.name;
	}

	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return this.id;
	}

	/** Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return this.cNr;
	}

	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		return String.format("%d:%d %s", this.id, this.cNr, this.name);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		
		Customer c = (Customer) o;

		return (this.name == c.name && this.id == c.id && this.cNr == c.cNr);
	}
}
