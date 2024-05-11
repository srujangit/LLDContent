package dev.srujan.springfirstproject.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // when ever new product added automatically id value will be incremented
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;

    private boolean isDeleted;
}
