package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.dto.AdminDto;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.entities.Admin;
import kosmok.teamlebimbe.ecommerce.repository.IAdminRepository;
import kosmok.teamlebimbe.ecommerce.service.AdminRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register-new-admin")
public class RegisterNewAdmin {


    @Autowired
    AdminRegistrationService adminRegistrationService;

    @Autowired
    private IAdminRepository iAdminRepository;

    @RoleSecurity(value = "admin")
    @PostMapping
    public BaseResponse createAdmin(@RequestBody AdminDto payload){

        adminRegistrationService.registerAdmin(payload);
        return new BaseResponse(null,"the admin has been successfully created");

    }
}
