package kosmok.teamlebimbe.ecommerce.repository;

import kosmok.teamlebimbe.ecommerce.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ISellerRepository extends JpaRepository<Seller,Long> {
    Optional<Seller> findByStoreName(String storename);
}
