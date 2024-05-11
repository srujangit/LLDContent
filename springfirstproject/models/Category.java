package dev.srujan.springfirstproject.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    private String title;

    private String description;
}
