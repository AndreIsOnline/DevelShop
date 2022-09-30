package kosmok.teamlebimbe.ecommerce.repository;

import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.entities.ShoppingKart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IShoppingKart extends JpaRepository<ShoppingKart,Long> {


 //List<Item> saveById(long id);

}
