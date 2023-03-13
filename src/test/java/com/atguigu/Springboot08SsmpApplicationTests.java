package com.atguigu;

import com.atguigu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot08SsmpApplicationTests {

    @Test
    void contextLoads() {
        Book book = new Book();
//        book.setName("计网123");
        book.setType("123");
        book.setDescription("1231af");
        System.out.println(book);
    }

}
