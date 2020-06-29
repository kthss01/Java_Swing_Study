package exampleProject;

public class Customer2 {
	private String name;
	private String phone;
	private String gender;
	private String age;
	private String note;

//	public Customer2(String name, String phone, String gender, String age, String note) {
//		super();
//		this.name = name;
//		this.phone = phone;
//		this.gender = gender;
//		this.age = age;
//		this.note = note;
//	}

	public String[] getCustomer() {
		String[] arr = new String[] { name, phone, gender, age, note };
		return arr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Customer2 [name=" + name + ", phone=" + phone + ", gender=" + gender + ", age=" + age + ", note=" + note
				+ "]";
	}

}
