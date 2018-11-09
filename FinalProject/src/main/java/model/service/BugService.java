package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonElement;

import model.bean.ProductBean;

public interface BugService {

	ArrayList<HashMap<String, String>> getAllWebProduct(String orgin, String page);

	ArrayList<HashMap<String, String>> getWebProCategory(String orgin);

	List<Object> getSubTablePro(String category);


	
    
}
