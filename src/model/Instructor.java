package model;

public class Instructor {
	private String id;
	private String name;
	private String level;
	private String nationality;
	private String gender;
	private String major;
	
	public Instructor() {
	}

	public Instructor(String id, String name, String level, String nationality, String gender, String major) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.nationality = nationality;
		this.gender = gender;
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", level=" + level + ", nationality=" + nationality
				+ ", gender=" + gender + ", major=" + major + "]";
	}
}