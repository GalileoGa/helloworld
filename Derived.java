
public class Derived extends Base {
	public String name = "Derived";
	
	public Derived() {
		tellName();
	}
	
	public void tellName() {
		System.out.println("derived name is " + name);
	}
	
	public static void main(String[] args) {
		Base base = new Derived();
		// derived name is null
		// derived name is derived
		
		base.tellName();
		
		// 动态绑定调用子类方法，此时子类成员变量没有初始化
		// 调用自己方法，此时对象已经创建，成员变量已经初始化
	}

}

class Base {
	public String name = "Base";
	
	public Base() {
		tellName();
	}

	public void tellName() {
		System.out.println("base name is " + name);
	}
}
