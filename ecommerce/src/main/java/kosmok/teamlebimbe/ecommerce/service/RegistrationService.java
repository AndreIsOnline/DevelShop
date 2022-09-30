package kosmok.teamlebimbe.ecommerce.service;

import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.controller.dto.RegistrationRequest;
import kosmok.teamlebimbe.ecommerce.dao.RegistrationDao;
import kosmok.teamlebimbe.ecommerce.exception.EmailAlredyExistException;
import kosmok.teamlebimbe.ecommerce.exception.UsernameAlredyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationDao registrationDao;

    public BaseResponse register(RegistrationRequest payload) {
        if(registrationDao.checkUserExistByEmail(payload.getEmail())) {
            throw new EmailAlredyExistException(payload.getEmail());
        }
        if(registrationDao.checkUserExistByUsername(payload.getUsername())) {
            throw new UsernameAlredyExistException(payload.getUsername());
        }

        if(registrationDao.save(payload)) {
            return new BaseResponse();
        } else {
            return new BaseResponse("Error saving user");
        }
    }


}
