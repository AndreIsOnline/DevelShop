package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
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
public class RemoveItem {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ISellerRepository iSellerRepository;



    @DeleteMapping("/{id}")
    @RoleSecurity(value ={"seller","admin"})
    public void clear(@PathVariable long id) {
         Seller x =itemRepository.findById(id).get().getSellerId();
         AuthenticationContext.Principal currentUser=AuthenticationContext.get();

         if(currentUser.getUserId() == x.getId() || currentUser.getRoles().contains("admin")){

            itemRepository.deleteById(id);
        }

    }
}
