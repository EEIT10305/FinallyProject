package model.service;

import java.io.IOException;
import java.util.List;

import model.bean.OrderDetailBean;

public interface LinePayService {

	String PayToLinePayInService(Integer price, Integer orderId) throws IOException;

	String PayToLinePayConfirmInService(String transactionId, Integer price) throws IOException;

	List<OrderDetailBean> ShowOrderDetailByLinePayInService(Integer OrderID) throws IOException;

}
