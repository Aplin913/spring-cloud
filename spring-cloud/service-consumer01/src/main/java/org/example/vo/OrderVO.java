package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.po.User;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO implements Serializable {
    private Integer id;
    private User user;
    private String productName;
    private Double price;
}
