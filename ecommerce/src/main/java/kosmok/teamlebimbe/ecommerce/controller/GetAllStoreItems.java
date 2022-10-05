package kosmok.teamlebimbe.ecommerce.controller;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import kosmok.teamlebimbe.ecommerce.controller.dto.PostItemDto;
import kosmok.teamlebimbe.ecommerce.dao.ItemDao;
import kosmok.teamlebimbe.ecommerce.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get-all-items")
public class GetAllStoreItems {

    @Autowired
    private ItemDao itemDao;

    @GetMapping
    @PublicEndpoint
    public List<ItemModel> getAllStoreItems() {

        List<ItemModel> completeItemList = itemDao.getAllItemsFromStore();

        if(completeItemList.size() > 0 && completeItemList != null) {
            return completeItemList;
        } else {
            return null;
        }

    }

}
