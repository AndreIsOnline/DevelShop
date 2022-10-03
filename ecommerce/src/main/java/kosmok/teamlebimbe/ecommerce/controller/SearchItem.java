package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;

import kosmok.teamlebimbe.ecommerce.entities.Item;

import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/search-item")
public class SearchItem {

    @Autowired
    private ItemRepository itemRepository;

}