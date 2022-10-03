package kosmok.teamlebimbe.ecommerce.repository;

import kosmok.teamlebimbe.ecommerce.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findByName(String name);


}

