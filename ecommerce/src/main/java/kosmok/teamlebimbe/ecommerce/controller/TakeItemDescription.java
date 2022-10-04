package kosmok.teamlebimbe.ecommerce.controller;


import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TakeItemDescription {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private HttpServletResponse httpServletResponse;

//FIXME
    @GetMapping("/description/{id}")
    @PublicEndpoint
    public Item getDescription(@PathVariable  long id) throws IOException {
        if(itemRepository.existsById(id)) {
            Item getItem = itemRepository.getReferenceById(id);
            return getItem;
        }else  {
            httpServletResponse.sendError(104,"The item id does not exist");
        }
        return null;
    }
}
