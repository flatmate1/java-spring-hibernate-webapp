package pl.miki.service;

import java.util.List;

import pl.miki.model.CartInfo;
import pl.miki.model.OrderDetailInfo;
import pl.miki.model.OrderInfo;

public interface OrderService {

    public void saveOrder(CartInfo cartInfo);
    
    // public PaginationResult<OrderInfo> listOrderInfo(int page,
            // int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
	
}
