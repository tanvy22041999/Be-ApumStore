package com.spring.ecomerce.dtos.clone;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class ColorProductDTO {
    @Field("colorId")
    private String id;
    private int amount;
    private Double price;
    private Double realPrice;
    private String image;
    private String nameVn;
    private String imageLink;
}
