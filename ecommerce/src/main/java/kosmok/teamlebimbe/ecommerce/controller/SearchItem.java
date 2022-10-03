package kosmok.teamlebimbe.ecommerce.controller;

<<<<<<< HEAD
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;

import kosmok.teamlebimbe.ecommerce.entities.Item;

import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/search-item")
=======
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

>>>>>>> e894229a1b70d010868b67bb0b65c6d545e3c544
public class SearchItem {

    @Autowired
    private ItemRepository itemRepository;

<<<<<<< HEAD
}
=======

    @GetMapping
    @PublicEndpoint


    public Item item(@RequestParam String name){

        return itemRepository.findByName(name);
    }

}
>>>>>>> e894229a1b70d010868b67bb0b65c6d545e3c544
