package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.domain.Book;
import com.atguigu.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return bookDao.selectPage(page, null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isEmpty(book.getDescription()), Book::getDescription, book.getDescription());


        IPage page = new Page(currentPage, pageSize);
        return bookDao.selectPage(page, null);
    }
}
