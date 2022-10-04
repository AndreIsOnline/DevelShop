package kosmok.teamlebimbe.ecommerce.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.dto.ItemsInCartDto;
import kosmok.teamlebimbe.ecommerce.dao.ShoppingCartDao;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingCart;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/get-cart-by-id")
public class GetShoppingCartByUserId {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private IShoppingCart iShoppingCart;


    // Questo metodo ritorna una lista di Item presenti in uno shopping cart a partire dall'id del Customer

    @GetMapping
    @RoleSecurity(value = {"admin", "customer"})
    @JsonBackReference
    public List<ItemsInCartDto> addToCart() {

        Long currentUserId = AuthenticationContext.get().getUserId();

        List<Long> itemsListFromQuery = shoppingCartDao.getShoppingCartItemsList(currentUserId);
        System.out.println("LONG LIST LENGTH IS " + itemsListFromQuery.size());

        List<ItemsInCartDto> currentCartItemList = new ArrayList<>();

        if (itemsListFromQuery != null) {

            itemsListFromQuery.forEach(itemId -> {
                Optional<Item> currentItem = itemRepository.findById(itemId);

                if(currentItem.isPresent()) {
                    ItemsInCartDto itemFromRep = new ItemsInCartDto();

                    itemFromRep.setCount(shoppingCartDao.getItemQuantityByItemIdAndCustomerId(itemId, currentUserId));

                    itemFromRep.setId(currentItem.get().getId());

                    currentCartItemList.add(itemFromRep);
                }
            });

            return currentCartItemList;
        }

        return null;
    }

}
