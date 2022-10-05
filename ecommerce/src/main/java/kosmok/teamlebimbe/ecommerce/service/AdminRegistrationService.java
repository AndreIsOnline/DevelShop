package kosmok.teamlebimbe.ecommerce.service;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.dto.AdminDto;
import kosmok.teamlebimbe.ecommerce.entities.Admin;
import kosmok.teamlebimbe.ecommerce.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRegistrationService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IAdminRepository iAdminRepository;

     public void registerAdmin(AdminDto payload){
        Admin out = new Admin();
        out.setCity(payload.getCity());
        out.setPassword(bCryptPasswordEncoder.encode(payload.getPassword()));
        out.setUsername(payload.getUsername());
        out.setEmail(payload.getEmail());
        iAdminRepository.save(out);

    }

}
