package dev.srujan.springfirstproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel{

    private String title;
    private String description;

    private double price;

    private String imageUrl;
    @ManyToOne(cascade = CascadeType.PERSIST) //m:1
    private Category category;
/*
 alt+insert - will show to generate setters and getters, instead we can use annotation @Setter, @Getter, lombok module will take care of this setters and getters
 */
}
