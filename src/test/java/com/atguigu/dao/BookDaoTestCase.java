package com.atguigu.dao;

import com.atguigu.domain.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;
    @Test
    public void testBook(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    public void testInsert(){
        Book book = new Book();
        book.setName("计网123");
        book.setType("123");
        book.setDescription("1231af");
        System.out.println(book);
        bookDao.insert(book);
    }

    @Test
    public void testGetPage(){
        IPage page = new Page(1,5);
        IPage iPage = bookDao.selectPage(page, null);

    }


    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        //if(name != null) lqw.like(Book::getName,name);		//方式一：JAVA代码控制
        lqw.like(name != null,Book::getName,name);				//方式二：API接口提供控制开关
        bookDao.selectList(lqw);
    }


}
