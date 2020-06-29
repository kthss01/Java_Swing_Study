package exampleProject;

public class CustomerBuilder {
	private Customer2 c;
	public CustomerBuilder(Customer2 c) {
		this.c = c;
	}
	
	public CustomerBuilder name(String name) {
		c.setName(name);
		return this;
	}
	public CustomerBuilder phone(String phone) {
		c.setPhone(phone);
		return this;
	}
	public CustomerBuilder gender(String gender) {
		c.setGender(gender);
		return this;
	}
	public CustomerBuilder age(String age) {
		c.setAge(age);
		return this;
	}
	public CustomerBuilder note(String note) {
		c.setNote(note);
		return this;
	}
	public Customer2 customer() {
		return c;
	}
}
