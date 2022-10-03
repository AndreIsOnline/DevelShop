package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.entities.Admin;
import kosmok.teamlebimbe.ecommerce.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create/admin")
public class RegisterNewAdmin {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IAdminRepository iAdminRepository;

    @RoleSecurity(value = "admin")
    @PostMapping
    public BaseResponse createAdmin(@RequestBody Admin admin){

        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        Admin newAdmin=iAdminRepository.save(admin);
        if(admin != null) {
            return new BaseResponse();
        }else {
            return new BaseResponse("something went Wrong!");
        }

    }
}
