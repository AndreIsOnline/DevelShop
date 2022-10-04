package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.entities.Seller;
import kosmok.teamlebimbe.ecommerce.repository.ISellerRepository;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clear-item")
public class RemoveItemFromRepository {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ISellerRepository iSellerRepository;



    @DeleteMapping("/{id}")
    @RoleSecurity(value ={"seller","admin"})
    public BaseResponse clear(@PathVariable long id) {
         Seller currentSeller = itemRepository.findById(id).get().getSellerId();

         AuthenticationContext.Principal currentUser = AuthenticationContext.get();

         if(currentUser.getUserId() == currentSeller.getId() || currentUser.getRoles().contains("admin")){
            itemRepository.deleteById(id);

            return new BaseResponse();
        } else {
             return new BaseResponse("ITEM_NOT_FOUND_IN_DB");
         }

    }
}
