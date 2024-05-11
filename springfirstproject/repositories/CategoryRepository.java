package dev.srujan.springfirstproject.repositories;

import dev.srujan.springfirstproject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoriesByTitle(String title);

    Category save(Category category);
    Category findById(long id);
}
