package com.atguigu.service;

import com.atguigu.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService ibookService;
    @Test
    void testGetById(){
        System.out.println(ibookService.getById(4));
    }

    @Test
    void tetsUpdate(){
        Book book = new Book();
        book.setId(52);
        book.setName("hahahaha");
        ibookService.updateById(book);
    }

    @Test
    void testDelete(){
        System.out.println(ibookService.removeById(52));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("Hellen");
        book.setType("dfahks");
        book.setDescription("hjkafsodipf");
        Boolean save = ibookService.save(book);
        System.out.println(book.getId());
    }

    @Test
    void testGetAll(){
        System.out.println(ibookService.list());
    }

    @Test
    void testGetPage(){
        IPage<Book> Page = new Page<>(1,3);
        IPage<Book> page = ibookService.page(Page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());

    }

}
