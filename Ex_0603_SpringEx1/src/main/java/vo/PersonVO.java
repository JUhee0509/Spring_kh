package vo;

public class PersonVO {
	private String name;
	private int age;
	private String tel;
	
	public PersonVO() {
		System.out.println("--PersonVO의 기본생성자--");
	}
	
	public PersonVO(String name, int age, String tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		
		System.out.println("--PersonVO의 파라미터를 받는 생성자--");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("--setName()호출됨 : " + name + "--");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
