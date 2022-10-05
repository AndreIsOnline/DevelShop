package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete-store")
public class DeleteStore {

    @Autowired
    ISellerRepository iSellerRepository;

    @DeleteMapping("/{id}")
    @RoleSecurity(value = {"seller", "admin"})
    private BaseResponse deleteStore(@PathVariable Long id) {
        if (iSellerRepository.existsById(id)) {
            if (AuthenticationContext.get().getUserId() == id || AuthenticationContext.get().getRoles().contains("admin")) {
                iSellerRepository.deleteById(id);
                return new BaseResponse(null,"the store has successfully been removed");
            }
            return new BaseResponse("only the owner of the store or an admin can remove the store",null);

        }
        return new BaseResponse("the id selected was not found",null);
    }
}