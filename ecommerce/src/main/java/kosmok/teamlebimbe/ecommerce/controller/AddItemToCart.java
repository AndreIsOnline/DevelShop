package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.dto.AddToCartDto;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add-into-cart")
public class AddItemToCart {

    @Autowired
    private ItemService itemService;

    @RoleSecurity(value = {"customer"})
    @PostMapping
    public BaseResponse addIntoKart(@RequestBody AddToCartDto payload)  {
        return itemService.addToCart(payload,AuthenticationContext.get());
    }
}
