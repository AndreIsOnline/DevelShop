package kosmok.teamlebimbe.ecommerce.controller;


import com.fasterxml.jackson.annotation.JsonBackReference;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.controller.dto.PostItemDto;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/search-item")
public class SearchItem {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    @PublicEndpoint
    public PostItemDto item(@RequestParam Long itemId){

        PostItemDto itemToReturn = new PostItemDto();
        Optional<Item> itemFromRepo = itemRepository.findById(itemId);

        if(itemFromRepo.isPresent()) {
            itemToReturn.setDescription(itemFromRepo.get().getDescription());
            itemToReturn.setName(itemFromRepo.get().getName());
            itemToReturn.setUnitPrice(itemFromRepo.get().getUnitPrice());
            itemToReturn.setQuantityInStock(itemFromRepo.get().getQuantityInStock());

            return itemToReturn;

        } else {
            return null;
        }
    }
}