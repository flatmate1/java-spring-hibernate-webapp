package pl.miki.dao;

import java.util.List;

import pl.miki.model.CartInfo;
import pl.miki.model.OrderDetailInfo;
import pl.miki.model.OrderInfo;

public interface OrderDao {
 
    public void saveOrder(CartInfo cartInfo);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}