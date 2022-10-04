package kosmok.teamlebimbe.ecommerce.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.dao.ItemDao;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
