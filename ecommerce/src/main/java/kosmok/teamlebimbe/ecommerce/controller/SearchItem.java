package kosmok.teamlebimbe.ecommerce.controller;


import com.fasterxml.jackson.annotation.JsonBackReference;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/search-item")
public class SearchItem {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    @PublicEndpoint
    public Item item(@RequestParam String name){

        return itemRepository.findByName(name);
    }
}