package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.entities.OrderItems;
import kosmok.teamlebimbe.ecommerce.repository.IOrdersRepository;
import kosmok.teamlebimbe.ecommerce.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/view-all-orders")
public class GetAllOrders {

    @Autowired
    private IOrdersRepository iOrdersRepository;

    @Autowired
    private ISellerRepository iSellerRepository;

    @GetMapping
    @RoleSecurity(value = {"customer","admin"})
    public List<OrderItems> getMyOrder(){

        Optional<OrderItems> currentOrders=iOrdersRepository.findById(AuthenticationContext.get().getUserId());

        if (currentOrders.isPresent()||AuthenticationContext.get().getRoles().contains("admin")){
            iOrdersRepository.findAll();

        }
      return null;
    }
}
