package kosmok.teamlebimbe.ecommerce.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.dto.ItemsInCartDto;
import kosmok.teamlebimbe.ecommerce.dao.ShoppingCartDao;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingKart;
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
    private IShoppingKart iShoppingKart;


    // Questo metodo ritorna una lista di Item presenti in uno shopping cart a partire dall'id del Customer

    @GetMapping
    @RoleSecurity(value = {"admin", "customer"})
    @JsonBackReference
    public List<ItemsInCartDto> addToCart() {

        Long currentUserId = AuthenticationContext.get().getUserId();

        // in questa lista ci sono tutti gli item_id presenti nella lista associata ad un customer presi dalla query
        List<Long> itemsListFromQuery = shoppingCartDao.getShoppingCartItemsList(currentUserId);

        List<ItemsInCartDto> currentCartItemList = new ArrayList<>();

        if (itemsListFromQuery != null) {
            // una lista di Long id associate all'id dell'item nel respository
            //devo fare un for che mi addi l'item alla lista di ItemsInCartDto


            itemsListFromQuery.forEach(itemId -> {
                // una lista di Item presi dall'Item repository trovati a partire dall'id degli item nella query (itemId)
                Optional<Item> currentItem = itemRepository.findById(itemId);

                if(currentItem.isPresent()) {
                    // questo è l'item dell'iterazione corrente da inserire nella lista di DTO da ritornare
                    ItemsInCartDto itemFromRep = new ItemsInCartDto();

                    // qui voglio inserire all'interno del dto da ritornare il COUNT cioè la quantità totale nel carrell


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
