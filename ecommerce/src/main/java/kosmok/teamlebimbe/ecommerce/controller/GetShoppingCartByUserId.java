package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;

import kosmok.teamlebimbe.ecommerce.entities.ShoppingKart;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingKart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get-cart-by-id")
public class GetShoppingCartByUserId {

    @Autowired
    private IShoppingKart iShoppingKart;

    @GetMapping
    @RoleSecurity(value = {"admin", "customer"})
    public ShoppingKart getItemsInCartById() {
        AuthenticationContext.get().getUserId();


        return null;
    }

}