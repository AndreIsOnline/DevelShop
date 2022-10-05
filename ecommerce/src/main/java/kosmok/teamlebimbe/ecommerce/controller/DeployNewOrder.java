package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.dao.ItemDao;
import kosmok.teamlebimbe.ecommerce.dao.OrderDao;
import kosmok.teamlebimbe.ecommerce.dao.ShoppingCartDao;
import kosmok.teamlebimbe.ecommerce.model.ShoppingCartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/deploy-new-order")
@RestController
public class DeployNewOrder  {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemDao itemDao;


    @RoleSecurity(value = {"customer"})
    @PostMapping
    public BaseResponse deployNewOrder() {

        Long currentUserId = AuthenticationContext.get().getUserId();

        List<ShoppingCartModel> currentCart = shoppingCartDao.getAllItemsByCustomerId();

        Integer currentItemQuantity;
        Integer itemInStockQuantity;
        Integer actualQuantity;
        ShoppingCartModel currentItem;

        if(currentCart != null && currentCart.size() > 0) {
            for(int i = 0; i < currentCart.size(); i++) {
                currentItem = currentCart.get(i);

                currentItemQuantity = currentItem.getQuantity();
                itemInStockQuantity = itemDao.getItemQuantityInStockByItemId(currentItem.getItemId());
                actualQuantity = itemInStockQuantity - currentItemQuantity;

                itemDao.updateItemQuantityByItemId(actualQuantity, currentItem.getItemId());

            }
            orderDao.createNewOrderByCustomerIdAndByCartList(currentUserId, currentCart);

            shoppingCartDao.deleteCartByCustomerId(currentUserId);
            return new BaseResponse();


        } else {
            return new BaseResponse("DB_ERROR", null);
        }

    }

}
