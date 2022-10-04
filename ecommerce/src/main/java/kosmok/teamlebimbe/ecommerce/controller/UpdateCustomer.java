package kosmok.teamlebimbe.ecommerce.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.entities.RegistrationCustomer;
import kosmok.teamlebimbe.ecommerce.repository.IRegistrationCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCustomer {

    @Autowired
    private IRegistrationCustomerRepository iRegistrationCustomerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PatchMapping("/change-customer/{id}")
    @RoleSecurity(value = {"customer"})
    @JsonBackReference
    public BaseResponse updateCustomer(@RequestBody @NotNull RegistrationCustomer customer){
           RegistrationCustomer newCustomer = iRegistrationCustomerRepository.getReferenceById(AuthenticationContext.get().getUserId());
           newCustomer.setEmail(customer.getEmail());
           newCustomer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
           newCustomer.setUsername(customer.getUsername());
           iRegistrationCustomerRepository.save(newCustomer);
           return new BaseResponse();
    }
}
