package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;

import kosmok.teamlebimbe.ecommerce.controller.dto.AdminDto;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.repository.IAdminRepository;
import kosmok.teamlebimbe.ecommerce.service.AdminRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/register-first-admin")
public class RegisterFirstAdmin {


        @Autowired
        private IAdminRepository iAdminRepository;
        @Autowired
        private AdminRegistrationService adminRegistrationService;

        @PublicEndpoint
        @PostMapping
        public BaseResponse createFirstAdmin(@NotNull @RequestBody AdminDto payload){

            if(iAdminRepository.count() == 0) {

                adminRegistrationService.registerAdmin(payload);

                return new BaseResponse(null,"congratulations! you are the first admin");
            }
                return new BaseResponse("only the first admin can be created without added authorisations",null);
            }
        }
