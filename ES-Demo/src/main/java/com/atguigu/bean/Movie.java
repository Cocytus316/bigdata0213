package com.atguigu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Ding Han
 * @Description
 * @create 2020-07-11 11:22
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String movie_id;
    private String movie_name;
}
