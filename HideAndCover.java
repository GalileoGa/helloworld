
/* 隐藏和覆盖的区别 */
public class HideAndCover {
    public static void main(String[] args) {
    	// 父类引用指向子类对象
        Father father = new Son();
        System.out.println(father.a);// 0
        System.out.println(father.b);// 0
        // 所有成员变量（静态变量和非静态变量）都只进行静态绑定
        father.c();// 0
        // 对于静态方法，jvm只进行静态绑定，结果就是直接掉用父类的中的静态方法，结果为0
        father.d();
        // 对于非静态方法，jvm进行动态类型检查，发现father的引用指向son类，进行动态绑定
        
        // 对于前两中情况，父类的属性和方法并没有被子类抹去，通过相应的引用可以访问到，但是在子类中不能显式的看到，这种情况叫隐藏
        // 对于第三种情况，父类的非静态方法被子类重写了，通过相应的引用也访问不到了，除非创建父类的对象来调用，这种情况叫覆盖
        
        // 父类的成员变量只会被隐藏，而且支持交叉隐藏（静态变量被非静态变量隐藏）
        // 父类的静态方法只会被隐藏静，不支持交叉隐藏
        // 父类的非静态方法会被覆盖，但是不能交叉覆盖
    }

}
//声明父类
class Father{
	// 静态变量
    static int a=0;
    // 非静态变量
    int b=0;
    // 静态方法
    static void c() {
        System.out.println(0);
    }
    // 非静态方法
    void d() {
        System.out.println(0);
    }
}
//声明子类
class Son extends Father{
    static int a=1;
    int b=1;
    static void c() {
        System.out.println(1);
    }
    void d() {
        System.out.println(1);
    }
}