package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.service.RegistrationService;
import kosmok.teamlebimbe.ecommerce.controller.dto.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RestController
public class RegisterNewCustomer {

    @Autowired
    private RegistrationService registrationService;

    @CrossOrigin(origins = {"http://localhost:5500"})
    @PostMapping("/register")
    @PublicEndpoint
    public BaseResponse userRegistered(@Valid @RequestBody(required = true) RegistrationRequest payload){

    return registrationService.register(payload);

}

}
