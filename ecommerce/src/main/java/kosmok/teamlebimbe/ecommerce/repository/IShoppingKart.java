package kosmok.teamlebimbe.ecommerce.repository;

import kosmok.teamlebimbe.ecommerce.entities.ShoppingKart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface IShoppingKart extends JpaRepository<ShoppingKart, Long> {


}
