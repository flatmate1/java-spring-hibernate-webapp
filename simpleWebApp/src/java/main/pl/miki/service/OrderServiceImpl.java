package pl.miki.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.miki.dao.OrderDao;
import pl.miki.model.CartInfo;
import pl.miki.model.OrderDetailInfo;
import pl.miki.model.OrderInfo;




@Service(value="orderService")
public class OrderServiceImpl implements OrderService {

	private final OrderDao orderDao;
	 
	/* CONSTRUCTOR INJECT
	 * with only single constructor no need annotation @autowired
	 * constructor injection is easier to testing
	 */
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Transactional
	public void saveOrder(CartInfo cartInfo) {
		orderDao.saveOrder(cartInfo);
	}

	@Transactional
	public OrderInfo getOrderInfo(String orderId) {
		return orderDao.getOrderInfo(orderId);
	}

	@Transactional
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		return orderDao.listOrderDetailInfos(orderId);
	}
}
