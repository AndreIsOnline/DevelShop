package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.dto.RegistrationRequest;
import kosmok.teamlebimbe.ecommerce.controller.dto.UpdateCustomerDto;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.dao.UpdateInfoDao;
import kosmok.teamlebimbe.ecommerce.entities.RegistrationCustomer;
import kosmok.teamlebimbe.ecommerce.repository.IRegistrationCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/update-customer-info")

public class UpdateCustomerInformation{

    @Autowired
    IRegistrationCustomerRepository repository;
    @Autowired
    UpdateInfoDao updateInfoDao;

    @RoleSecurity(value = "customer")
    @PatchMapping
    private BaseResponse updateCustomer( @RequestBody UpdateCustomerDto customer){
        Long a = updateInfoDao.getIdByEmail(customer.getEmail());
        if(AuthenticationContext.get().getUserId() == a){
            updateInfoDao.UpdateCustomerInfo(customer);
            return new BaseResponse("your information have been updated");
        }
        return new BaseResponse("something went wrong");

    }

    
}


