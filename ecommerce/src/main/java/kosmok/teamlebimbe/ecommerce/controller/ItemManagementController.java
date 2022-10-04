package kosmok.teamlebimbe.ecommerce.controller;

import javax.validation.Valid;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosmok.teamlebimbe.ecommerce.controller.dto.PostItemDto;


@RestController
@RequestMapping("/insert-item-into-stock")
public class ItemManagementController {
	
	@Autowired
	private ItemService itemService;


	@RoleSecurity("seller")
	@PostMapping
	public BaseResponse postItem(@RequestBody @Valid PostItemDto payload) {

		return itemService.save(payload,AuthenticationContext.get());

	}


	
}
