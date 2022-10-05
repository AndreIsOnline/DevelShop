package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.dto.SellerDto;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.entities.Seller;
import kosmok.teamlebimbe.ecommerce.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/update-store-information")
public class UpdateStoreInformation {
    @Autowired
    ISellerRepository iSellerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RoleSecurity(value = "seller")
    @PatchMapping
    private BaseResponse updateStoreInformation(@NotNull @RequestBody SellerDto payload){

            Seller seller = iSellerRepository.getReferenceById(AuthenticationContext.get().getUserId());
            seller.setAddress(payload.getAddress());
            seller.setPassword(bCryptPasswordEncoder.encode(payload.getPassword()));
            seller.setCity(payload.getCity());
            seller.setSellerRating(payload.getSellerRating());
            seller.setIvaGame(payload.getIvaGame());
            seller.setState(payload.getState());
            seller.setStoreType(payload.getStoreType());
            seller.setStoreName(payload.getStoreName());
            iSellerRepository.save(seller);
            return new BaseResponse(null, "done! your information have been updated");
        }

    }



