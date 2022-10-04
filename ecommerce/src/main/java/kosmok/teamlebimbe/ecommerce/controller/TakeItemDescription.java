package kosmok.teamlebimbe.ecommerce.controller;


import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.controller.dto.ItemDescriptionDto;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
public class TakeItemDescription {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private HttpServletResponse httpServletResponse;


    @GetMapping("/description/{id}")
    @PublicEndpoint
    public ItemDescriptionDto getDescription(@PathVariable  Long id) throws IOException {

        Optional<Item> itemToCheck = itemRepository.findById(id);

        ItemDescriptionDto itemToReturn = new ItemDescriptionDto();

        if(itemToCheck.isPresent()) {
            String currentItemDescription = itemToCheck.get().getDescription();
            if(currentItemDescription != null && currentItemDescription.length() > 0) {
                itemToReturn.setDecsription(currentItemDescription);
                return itemToReturn;
            } else {
                return null;
            }
        }

        return null;
    }
}
