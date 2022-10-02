package kosmok.teamlebimbe.ecommerce.repository;

import kosmok.teamlebimbe.ecommerce.controller.RegisterNewCustomer;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.entities.RegistrationCustomer;
import kosmok.teamlebimbe.ecommerce.entities.ShoppingKart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface IShoppingKart extends JpaRepository<ShoppingKart,Long> {


}
