package kosmok.teamlebimbe.ecommerce.controller;


import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
<<<<<<< HEAD
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
=======
import kosmok.teamlebimbe.ecommerce.controller.dto.ItemDescriptionDto;
>>>>>>> 150c63715dd54d8bc008f4e82b09eb93741e37fb
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
<<<<<<< HEAD
    public String getDescription(@PathVariable  long id) throws IOException {
        if(itemRepository.existsById(id)) {
            Item getItem = itemRepository.getReferenceById(id);
            return getItem.getDescription();
        }else  {
            return null;
        }
=======
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
>>>>>>> 150c63715dd54d8bc008f4e82b09eb93741e37fb
    }
}
