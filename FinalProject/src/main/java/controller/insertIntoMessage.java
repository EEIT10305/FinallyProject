package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.dao.MessageDAO;

@Controller
public class insertIntoMessage {
	@Autowired
	MessageDAO messageDAO;
	
	@RequestMapping(path="insertMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String insertMessage(String memo) {
		//retuen new Gson().toJson();
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
