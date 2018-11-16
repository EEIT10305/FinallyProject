package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.MessageBean;
import model.dao.MessageDAO;

@Controller
public class insertIntoMessage {
	@Autowired
	MessageDAO messageDAO;
	
	@RequestMapping(path="insertMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String insertMessage(String memo) {
		//retuen new Gson().toJson();
		
//		-----------------------------------------------------------------------------------
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String Date = dateFormat.format(date);
		
		MessageBean bean = new MessageBean();
		bean.setDat(Date);
		bean.setMemberidA(3);
		bean.setMemberidB(5);
		bean.setMessag("親愛的同事,您的商品已經到貨了,請執行後續作業. 謝謝");
		bean.setReadstatu("notyet");
		bean.setTitle("商品上架");
		messageDAO.insert(bean);
		
//		-----------------------------------------------------------------------------------		
		System.out.println("memo================================ " + memo);
		return null;
	}
	
	@RequestMapping(path="getMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMessage() {
		//retuen new Gson().toJson();
		
		return new Gson().toJson(messageDAO.selectAll());
	}
}
