package model.service.Impl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import model.bean.OrderDetailBean;
import model.dao.OrderDetailDAO;
import model.service.LinePayService;
@Service
@Transactional
public class LinePayServiceImpl implements LinePayService {
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public String PayToLinePayInService(Integer price, Integer orderId) throws IOException {
		if (price != null && orderId != null) {
			OkHttpClient client = new OkHttpClient();

			MediaType mediaType = MediaType.parse("application/json");
			String str = "{\r\n\t\t\t\"productName\":\"3C產品\",\r\n\t\t\t\"amount\":" + price
					+ ",\r\n\t\t\t\"currency\":\"TWD\",\r\n\t\t\t\"confirmUrl\":\"http://localhost:8081/FinalProject/PayFinishedPage.html\",\r\n\t\t\t\"orderId\":\"Official2018"
					+ orderId + "\"\r\n\t\t}";
			System.out.println(str);
			RequestBody body = RequestBody.create(mediaType, str);
			Request request = new Request.Builder().url("https://sandbox-api-pay.line.me/v2/payments/request")
					.post(body).addHeader("Content-Type", "application/json")
					.addHeader("X-LINE-ChannelId", "1621069681")
					.addHeader("X-LINE-ChannelSecret", "2cfe6ce714dc48d5a6668016e7167237")
					.addHeader("X-LINE-MerchantDeviceProfileId", "DEVICE_PROFILE_ID")
					.addHeader("cache-control", "no-cache")
					.addHeader("Postman-Token", "91b9b773-dbb1-4e0b-8dc6-aa1a681c5ba2").build();

			Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
			JSONObject json = new JSONObject(jsonData);
			Object iwant = json.getJSONObject("info").getJSONObject("paymentUrl").get("web");
			System.out.println("info.paymentUrl.web:" + iwant);
			return iwant.toString();
		}

		return "沒東西是怎樣拉!!";
	}
	
	@Override
	public String PayToLinePayConfirmInService(String transactionId, Integer price) throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n\t\t\r\n\t\t\t\"amount\":" + price + ",\r\n\t\t\t\"currency\":\"TWD\"\r\n\t\t\r\n\t\t}");
		Request request = new Request.Builder()
				.url("https://sandbox-api-pay.line.me/v2/payments/"+ transactionId +"/confirm").post(body)
				.addHeader("Accept", "application/json").addHeader("Content-Type", "application/json")
				.addHeader("X-LINE-ChannelId", "1621069681")
				.addHeader("X-LINE-ChannelSecret", "2cfe6ce714dc48d5a6668016e7167237")
				.addHeader("X-LINE-MerchantDeviceProfileId", "DEVICE_PROFILE_ID").addHeader("cache-control", "no-cache")
				.addHeader("Postman-Token", "51a13302-cd58-4d79-b591-f53e7f44f810").build();

		Response response = client.newCall(request).execute();
		String jsonData = response.body().string();
		JSONObject json = new JSONObject(jsonData);
		Object iwant = json.get("returnMessage");
		System.out.println("returnMessage:" + iwant);
		return iwant.toString();
	}
	@Override
	public List<OrderDetailBean> ShowOrderDetailByLinePayInService(Integer OrderID) throws IOException {
		
		
		
		return orderDetailDAO.selectAllByOrderId(OrderID);
	}
}
