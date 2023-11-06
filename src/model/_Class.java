package model;

public class _Class {
	private String id;
	private String adviser;
	private String major;
	private String note;
	
	public _Class(String id, String adviser, String major, String note) {
		super();
		this.id = id;
		this.adviser = adviser;
		this.major = major;
		this.note = note;
	}
	
	public _Class() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAdviser() {
		return adviser;
	}
	
	public void setAdviser(String adviser) {
		this.adviser = adviser;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "_Class [id=" + id + ", adviser=" + adviser + ", major=" + major + "]";
	}
}
