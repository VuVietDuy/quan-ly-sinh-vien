package model;

public class Major {
	private String id;
	private String name;
	private String khoiNganh;
	private String note;
	
	public Major() {
	}
	
	public Major(String id, String name, String khoiNganh, String note) {
		this.id = id;
		this.name = name;
		this.khoiNganh = khoiNganh;
		this.note = note;
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
	public String getKhoiNganh() {
		return khoiNganh;
	}
	public void setKhoiNganh(String khoiNganh) {
		this.khoiNganh = khoiNganh;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + ", khoiNganh=" + khoiNganh + "]";
	}
}
