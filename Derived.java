package mainTest;

public class Derived extends Base {
	public String name = "Derived";
	
	public Derived() {
		tellName();
	}
	
	public void tellName() {
		System.out.println("derived name is " + name);
	}
	
	public static void main(String[] args) {
		new Derived();
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
