package vo;

public class UserVO {
	private int idx, age;
	private String uname;
	
	public UserVO(int idx, String uname, int age) {
		this.idx = idx;
		this.uname = uname;
		this.age = age;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
