package org.example.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_table")
public class Order implements Serializable {
    private Integer id;
    private Integer userId;
    private String productName;
    private Double price;
}
