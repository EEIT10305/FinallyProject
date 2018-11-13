package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.LinePayService;

@Controller
public class LinePayController {
	
	@Autowired
	private LinePayService linePayService;

	@RequestMapping("PayToLinePay")
	@ResponseBody
	public String PayToLinePayInController(Integer price, Integer orderId) throws IOException {

		return linePayService.PayToLinePayInService(price,orderId);
	}

	@RequestMapping("PayToLinePayConfirm")
	@ResponseBody
	public String PayToLinePayConfirmInController(String transactionId, Integer price) throws IOException {
		System.out.println(price);
		System.out.println(transactionId);
		return linePayService.PayToLinePayConfirmInService(transactionId,price);
	}
	
	@RequestMapping("ShowOrderDetailByLinePay")
	@ResponseBody
	public String ShowOrderDetailByLinePayInController(Integer OrderID) throws IOException {
		System.out.println("OrderID="+OrderID);
		return new Gson().toJson(linePayService.ShowOrderDetailByLinePayInService(OrderID));
	}
}
