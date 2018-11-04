package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.bean.ProductBean;

public interface BugService {

	List<ProductBean> getAllModel();

	ArrayList<HashMap<String, String>> getAllWebProduct(String orgin, String page);
    
}
