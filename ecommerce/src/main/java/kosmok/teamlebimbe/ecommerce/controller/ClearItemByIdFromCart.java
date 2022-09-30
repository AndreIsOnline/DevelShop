package kosmok.teamlebimbe.ecommerce.controller;


import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingKart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clear-one")
public class ClearItemByIdFromCart {

    @Autowired
    private IShoppingKart iShoppingKart;


    @RoleSecurity(value = "customer")
    @DeleteMapping("/{id}")
    public void clearOneItem(@PathVariable long id) {
            iShoppingKart.deleteById(id);

    }


}
