package model.service;

import java.util.List;
import java.util.Map;

import model.bean.CartDetailBean;
import model.bean.OrderDetailBean;
import model.bean.ProductBean;

public interface ChartService {
	List<Map<String, Object>> getSoldPro();
    
}
