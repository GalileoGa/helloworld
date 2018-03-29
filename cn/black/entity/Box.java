package cn.black.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/** 装东西的箱子 */
public abstract class Box<T> {
	private T t;

	public T outOfBox() {
		return t;
	}

	// 构造器，完成箱子中东西的实例化
	public Box() {
		// 构造子类箱子对象
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		// cn.black.test.Box<cn.black.entity.Book>

		// 获取泛型的第一个参数
		// 强转成parameterizedType以获取实际参数
		ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		Type actualType = actualTypeArguments[0];
		// cn.black.entity.Book

		// 强转成class对象以构建子类泛型对象
		@SuppressWarnings("unchecked")
		Class<T> actualClass = (Class<T>) actualType;
		try {
			t = actualClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
