package com.atguigu.controller;

import com.atguigu.controller.utils.R;
import com.atguigu.domain.Book;
import com.atguigu.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        System.out.println("test hot deploy....");
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        System.out.println("test hot deploy....");
        System.out.println("test hot deploy....");
        System.out.println("test hot deploy....");
        if(book.getName().equals("123"))
            throw new IOException();
        Boolean flag = bookService.save(book);

        return new R(flag? "添加成功！":"添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        Boolean flag = bookService.updateById(book);
        return new R(flag? "修改成功！":"修改失败");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        System.out.println("test hot deploy....");

        Boolean flag = bookService.removeById(id);
        return new R(flag? "删除成功":"删除失败");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){

        return new R(true, bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        if(currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//
//        return new R(true, page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }

        return new R(true, page);
    }


}
