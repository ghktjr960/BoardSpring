package member.model;

import java.util.Date;

public class MemberVo {
	private int num;
	private String id;
	private String password;
	private Date birthday;
	private String name;
	private String gender;
	private String email;
	private Date regdate;

	public MemberVo(String id, String password, Date birthday, String name, String gender, String email, Date regdate) {
		this.id = id;
		this.password = password;
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", id=" + id + ", password=" + password + ", brithday=" + birthday + ", name="
				+ name + ", gender=" + gender + ", email=" + email + ", regdate=" + regdate + "]";
	}

	
	

}
