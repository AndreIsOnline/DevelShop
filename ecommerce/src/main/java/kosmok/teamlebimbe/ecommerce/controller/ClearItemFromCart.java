package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.dao.ShoppingCartDao;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingCart;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

        Long currentCustomerId = AuthenticationContext.get().getUserId();

        Optional<Item> currentItem = itemRepository.findById(itemId);

        boolean isItemOwnedByCustomer = shoppingCartDao.checkIfUserHasItemInCart(currentItem.get().getId(), currentCustomerId);

        if(currentItem.isPresent() && isItemOwnedByCustomer) {
            shoppingCartDao.deleteItemFromCart(itemId, currentCustomerId);
            return new BaseResponse("ITEM_REMOVED_FROM_DB");
        } else {
            return new BaseResponse("DB_ERROR_FAILURE");
        }
    }


}
