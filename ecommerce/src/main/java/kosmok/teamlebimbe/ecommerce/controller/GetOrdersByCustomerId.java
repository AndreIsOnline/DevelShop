package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.dao.OrderDao;
import kosmok.teamlebimbe.ecommerce.model.OrderModel;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/get-orders-by-customer-id")
public class GetOrdersByCustomerId {

    @Autowired
    private OrderDao orderDao;



    @GetMapping
    @RoleSecurity(value = {"admin", "customer"})
    public List<OrderModel> getOrdersByCustomerId() {

        Long currentUserId = AuthenticationContext.get().getUserId();

        List<OrderModel> currentOrderList;

        currentOrderList = orderDao.getOrdersByCustomerId(currentUserId);

        Long idFromList = currentOrderList.get(0).getCustomerId();

        if(currentOrderList.size() > 0 && currentOrderList != null && currentUserId == idFromList) {
            currentOrderList.forEach(item -> {
                System.out.println("DOES EXIST?" + orderDao.doesOrderExistById(item.getOrderId()));

            });
            return currentOrderList;
        } else {
            return null;
        }

    }

}
