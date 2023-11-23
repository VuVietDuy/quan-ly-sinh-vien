package model;

public class Student implements Comparable<Student>{
    private String maSV;
    private String name;
    private String birthday;
    private Gender gender;
    private String address;
    private String major;
    private String _class;
    
	public Student() {
	}
	
	public Student(String maSV, String name, String birthday, Gender gender, String address, String major,
			String _class) {
		this.maSV = maSV;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.major = major;
		this._class = _class;
	}
	
	public String getMaSV() {
		return maSV;
	}
	
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String get_class() {
		return _class;
	}
	
	public void set_class(String _class) {
		this._class = _class;
	}

	@Override
	public String toString() {
		return "Student [maSV=" + maSV + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender
				+ ", address=" + address + ", major=" + major + ", _class=" + _class + "]";
	}
	
	public String getFirstName() {
		String[] words = name.split("\\s+");

        if (words.length > 0) {
            return words[words.length - 1];
        } else {
            return "";
        }
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.getFirstName().compareTo(o.getFirstName());
	}
}
