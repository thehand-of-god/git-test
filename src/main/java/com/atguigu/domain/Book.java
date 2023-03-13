package com.atguigu.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@TableName("tbl_book")
@Data
public class Book {
//    @TableId("id")
    private Integer id;
    private String type;
    private String name;
    private String description;

}
