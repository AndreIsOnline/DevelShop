package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.dao.ItemDao;
import kosmok.teamlebimbe.ecommerce.dao.OrderDao;
import kosmok.teamlebimbe.ecommerce.model.OrderItemsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/get-order-items-by-order-id")
public class GetOrderItemsByOrderId {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemDao itemDao;

    @GetMapping
    @RoleSecurity(value = {"admin", "customer"})
    public List<OrderItemsModel> getOrderItems(@RequestParam Long orderId) {

        List<OrderItemsModel> currentItemsList;

        currentItemsList = orderDao.getOrderItemsByOrderId(orderId);

        if(currentItemsList.size() > 0 && currentItemsList != null) {

            for(int i = 0; i < currentItemsList.size(); i++) {
                OrderItemsModel currentItem = currentItemsList.get(i);
                currentItem.setUnitPrice(itemDao.getItemPriceByItemId(currentItem.getItemId()));
            }
            return currentItemsList;
        } else {
            return null;
        }

    }
}
