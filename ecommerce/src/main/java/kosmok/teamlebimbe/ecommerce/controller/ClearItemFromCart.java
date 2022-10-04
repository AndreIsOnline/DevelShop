package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.dao.ShoppingCartDao;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingCart;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clear-one-item")
public class ClearItemFromCart {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShoppingCartDao shoppingCartDao;


@DeleteMapping
@RoleSecurity("customer")
    private BaseResponse clearOne(@RequestParam Long itemId){
        Long itemId = itemRepository.findByName(itemName).getId();
        Long customerId = AuthenticationContext.get().getUserId();
        shoppingCartDao.deleteItemFromCart(itemId, customerId);

        return new BaseResponse("Item successfully removed from the cart");

    }


}
