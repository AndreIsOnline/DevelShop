package kosmok.teamlebimbe.ecommerce.repository;

import kosmok.teamlebimbe.ecommerce.controller.dto.RegistrationRequest;
import kosmok.teamlebimbe.ecommerce.entities.RegistrationCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface IRegistrationCustomerRepository extends JpaRepository<RegistrationCustomer,Long> {

    public Optional<RegistrationCustomer> findByUsername(String username);

    RegistrationCustomer findByEmail(String email);
}
