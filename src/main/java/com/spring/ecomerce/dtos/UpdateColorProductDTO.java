package com.spring.ecomerce.dtos;

import com.spring.ecomerce.entities.clone.ImageEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class UpdateColorProductDTO {
    @Field("colorId")
    private String id;
    private int amount;
    private Double price;
    private Double realPrice;
    private ImageEntity image;
    private String nameVn;
    private String imageLink;
}
