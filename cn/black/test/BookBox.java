package cn.black.test;

import org.junit.Test;

import cn.black.entity.Book;

public class BookBox extends Box<Book> {
	
	@Test
	public void testBox() {
		BookBox box = new BookBox();
		Book book = box.outOfBox();
		System.out.println(book);
		// Book [bookId=0, number=0, name=null]
		// 初始化对象成功
	}

}
