package model.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ProductBean;
import model.dao.OrderDetailDAO;
import model.dao.ProductDAO;
import model.service.ChartService;

@Service
@Transactional
public class ChartServiceImpl implements ChartService {
    
	@Autowired
	private OrderDetailDAO orderDetailDAO ; 
	@Autowired
	private ProductDAO productDAO ; 
	
	@Override
	public List<Map<String,Object>> getSoldPro() {
		List<Map<String,Object>> realresult = new ArrayList<>();
		List<Map<String, Object>> result = orderDetailDAO.countSoldPro();
		for(int i = 0 ; i < result.size() ; i ++) {
			Map<String,Object> hm = new HashMap<>();
			hm.put("pro",productDAO.selectById(Integer.parseInt(result.get(i).get("pro").toString())));
			hm.put("sum", result.get(i).get("sum").toString());
			realresult.add(hm);
		}
		return realresult;
	}

}
