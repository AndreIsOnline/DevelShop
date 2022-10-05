package kosmok.teamlebimbe.ecommerce.service;

import javax.validation.Valid;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import kosmok.teamlebimbe.ecommerce.dao.ItemDao;
import kosmok.teamlebimbe.ecommerce.dao.ShoppingCartDao;
import kosmok.teamlebimbe.ecommerce.entities.ShoppingKart;
import kosmok.teamlebimbe.ecommerce.model.ItemModel;

import kosmok.teamlebimbe.ecommerce.entities.RegistrationCustomer;
import kosmok.teamlebimbe.ecommerce.entities.Seller;
import kosmok.teamlebimbe.ecommerce.repository.IRegistrationCustomerRepository;
import kosmok.teamlebimbe.ecommerce.repository.ISellerRepository;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingCart;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosmok.teamlebimbe.ecommerce.controller.dto.AddToCartDto;
import kosmok.teamlebimbe.ecommerce.controller.dto.PostItemDto;
import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;


import java.util.Optional;


@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Autowired
	private IRegistrationCustomerRepository iRegistrationCustomerRepository;

	@Autowired
	private ISellerRepository iSellerRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private IShoppingCart iShoppingCart;

	public BaseResponse save(PostItemDto payload, AuthenticationContext.Principal principal) {
		Optional<Seller> seller = iSellerRepository.findByStoreName(principal.getUsername());
		ItemModel currentItem = itemDao.findBySellerAndName(principal, payload.getName());
		if (currentItem == null) {
			if (itemDao.insertItems(payload.getName(), payload.getDescription(), payload.getQuantityInStock(),
					payload.getUnitPrice(), seller.get().getId())) {
				return new BaseResponse();
			} else {
				return new BaseResponse("DB_OPERATION_ERROR", null);
			}
		} else {
			Integer itemToUpdate=itemDao.updateItemQuantity(currentItem.getQuantityInStock()+ payload.getQuantityInStock(),currentItem.getId());
			if(itemToUpdate==0){
				return new BaseResponse("DB_OPERATION_ERROR", null);
			}else{
				return new BaseResponse();
			}

		}
	}

	public BaseResponse addToCart(@Valid AddToCartDto payload, AuthenticationContext.Principal principal) {
		BaseResponse br = null;

		Long currentUserId = AuthenticationContext.get().getUserId();

		Integer quantityFromCart = shoppingCartDao.getItemQuantityByItemIdAndCustomerId(payload.getItemId(), currentUserId);
		Integer quantityFromPayload = payload.getCount();
		Integer totalQuantity = 0;

		if(quantityFromCart != null) {
			totalQuantity = quantityFromCart + quantityFromPayload;
		} else {
			totalQuantity = quantityFromPayload;
		}

		if(itemDao.checkCount(totalQuantity, payload.getItemId()) == false) {
			br = new BaseResponse("OUT_OF_STOCK", null);
		} else {
			if(shoppingCartDao.checkIfUserHasItemInCart(payload.getItemId(), currentUserId)) {
				int quantityToUpdate = shoppingCartDao.getItemQuantityByItemIdAndCustomerId(
						payload.getItemId(), currentUserId
				) + payload.getCount();

				System.out.println("QUANTITY TO UPDATE = " + quantityToUpdate);

				shoppingCartDao.updateItemQuantity(quantityToUpdate, payload.getItemId(), currentUserId);

				if(quantityToUpdate == 0){
					return new BaseResponse("DB_OPERATION_ERROR", null);
				} else {
					return new BaseResponse();
				}
			} else {
				Optional<RegistrationCustomer> customer = iRegistrationCustomerRepository.findByUsername(principal.getUsername());
				if (itemDao.insertToShoppingCart(payload.getCount(), payload.getItemId(), customer.get().getId())) {
					br = new BaseResponse();
				} else {
					br = new BaseResponse("DB_OPERATION_ERROR", null);
				}
			}
		}


		return br;
	}
}