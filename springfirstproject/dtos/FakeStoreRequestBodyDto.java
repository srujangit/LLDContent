package dev.srujan.springfirstproject.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreRequestBodyDto {
    String title;
    double price;

    String description;
    String image;

    String category;

}
