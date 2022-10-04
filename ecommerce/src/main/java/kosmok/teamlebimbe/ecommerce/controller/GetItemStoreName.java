package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.dao.ShoppingCartDao;
import kosmok.teamlebimbe.ecommerce.entities.Seller;
import kosmok.teamlebimbe.ecommerce.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/view-store")
public class GetItemStoreName {


    @Autowired
    private ISellerRepository sellerRepository;

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @GetMapping
    @PublicEndpoint
    public List<String> viewItems(@RequestParam String storeName) {

        Optional<Seller> seller = sellerRepository.findByStoreName(storeName);

        if (seller.isPresent()) {
            return shoppingCartDao.getStore(seller.get().getId());
        }
        return null;
    }
}