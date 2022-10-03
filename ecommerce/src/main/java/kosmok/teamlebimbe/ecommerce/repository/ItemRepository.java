package kosmok.teamlebimbe.ecommerce.repository;

import kosmok.teamlebimbe.ecommerce.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> e894229a1b70d010868b67bb0b65c6d545e3c544

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findByName(String name);
<<<<<<< HEAD
=======


>>>>>>> e894229a1b70d010868b67bb0b65c6d545e3c544
}

