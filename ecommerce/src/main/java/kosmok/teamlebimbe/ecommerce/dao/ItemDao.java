package kosmok.teamlebimbe.ecommerce.dao;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import kosmok.teamlebimbe.ecommerce.entities.Item;
import kosmok.teamlebimbe.ecommerce.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertItems(String name, String description, Integer quantityInStock, Integer unitPrice,Long sellerID) {
		return jdbcTemplate.update(
				"INSERT INTO ITEM (name,description,quantity_in_stock,unit_price,time_of_insertion,seller_id_seller_id) VALUES"
				+ "(?,?,?,?,?,?)", name, description, quantityInStock, unitPrice, System.currentTimeMillis(),sellerID) == 1;
	}

	public ItemModel findBySellerAndName(AuthenticationContext.Principal seller , String itemName){
		List<ItemModel> queryList= jdbcTemplate.query("SELECT * From ITEM WHERE name=? And  seller_id_seller_id=? ", new RowMapper<ItemModel>(){

			@Override
			public ItemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				ItemModel itemModel =new ItemModel();
				itemModel.setId(rs.getLong("item_id"));
				itemModel.setDescription(rs.getString("description"));
				itemModel.setName(rs.getString("name"));
				itemModel.setQuantityInStock(rs.getInt("quantity_in_stock"));
				itemModel.setSellerId(rs.getLong("seller_id_seller_id"));
				itemModel.setUnitPrice(rs.getInt("unit_price"));
				itemModel.setTimeOfInsertion(rs.getLong("time_of_insertion"));
				return itemModel;
			}
		},itemName,seller.getUserId());
		if (queryList.isEmpty()){
			return null;
		}else {
			return queryList.get(0);
		}
	}

	public boolean insertToShoppingCart(Integer count, Long itemId, Long customerId) {
		return jdbcTemplate.update(
				"INSERT INTO SHOPPING_KART(item_item_id,date_add, registration_customer_id, quantity) VALUES"
				+ "(?,?,?,?)", itemId,System.currentTimeMillis(),customerId,count) == 1;
	}

	public boolean checkCount(Integer count, Long itemId) {
		Integer countFromDb = jdbcTemplate.queryForObject("SELECT quantity_in_stock FROM ITEM WHERE item_id = ?", Integer.class,
				itemId);
		System.out.println("count param = " + count + "count from db = " + countFromDb);

		if(countFromDb != null && countFromDb >= count) {
			return true;
		} else {
			return false;
		}
	}

	public int updateItemQuantity(int i, Long itemId) {
		return jdbcTemplate.update("UPDATE ITEM SET quantity_in_stock=? where item_id=?",i,itemId);
	}

	public void updateItemQuantityByItemId(Integer quantity, Long itemId) {
		jdbcTemplate.update("UPDATE item SET quantity_in_stock = ? WHERE item_id = ?", quantity, itemId);
	}

	public Integer getItemPriceByItemId(Long itemId) {
		return jdbcTemplate.queryForObject("SELECT unit_price FROM item WHERE item_id = ?", Integer.class, itemId);
	}

	public Integer getItemQuantityInStockByItemId(Long itemId) {
		return jdbcTemplate.queryForObject("SELECT quantity_in_stock FROM item WHERE item_id = ?", Integer.class, itemId);
	}

	public List<ItemModel> getAllItemsFromStore() {
		List<ItemModel> queryList = jdbcTemplate.query("SELECT * FROM item",
				new RowMapper<ItemModel>(){
			@Override
			public ItemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				ItemModel itemModel =new ItemModel();
				itemModel.setId(rs.getLong("item_id"));
				itemModel.setDescription(rs.getString("description"));
				itemModel.setName(rs.getString("name"));
				itemModel.setQuantityInStock(rs.getInt("quantity_in_stock"));
				itemModel.setSellerId(rs.getLong("seller_id_seller_id"));
				itemModel.setUnitPrice(rs.getInt("unit_price"));
				itemModel.setTimeOfInsertion(rs.getLong("time_of_insertion"));
				return itemModel;
			}
		});
		if (queryList.isEmpty()){
			return null;
		}else {
			return queryList;
		}
	}



}
