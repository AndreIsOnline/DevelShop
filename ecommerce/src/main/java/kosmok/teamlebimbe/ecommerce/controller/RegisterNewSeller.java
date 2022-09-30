package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.entities.Seller;
import kosmok.teamlebimbe.ecommerce.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class RegisterNewSeller {
    @Autowired
    private ISellerRepository iSellerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    @PublicEndpoint
    public BaseResponse createSeller(@RequestBody Seller seller){
        seller.setPassword(bCryptPasswordEncoder.encode(seller.getPassword()));
        if (seller !=null){
            iSellerRepository.save(seller);
            return new BaseResponse();
        }else
           return new BaseResponse("something went wrong!");

    }
}
