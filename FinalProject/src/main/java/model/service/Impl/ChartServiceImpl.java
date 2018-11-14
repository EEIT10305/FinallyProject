package model.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.OrderListBean;
import model.dao.OrderDetailDAO;
import model.dao.OrderListDAO;
import model.dao.ProductDAO;
import model.service.ChartService;

@Service
@Transactional
public class ChartServiceImpl implements ChartService {
    
	@Autowired
	private OrderDetailDAO orderDetailDAO ; 
	@Autowired
	private OrderListDAO orderListDAO ; 
	@Autowired
	private ProductDAO productDAO ; 
	
	@Override
	public List<Map<String,Object>> getSoldPro(String start,String end) {
		List<Map<String,Object>> realresult = new ArrayList<>();
		List<OrderListBean> list = orderListDAO.selectBetweenTime(start, end);
		
			List<Map<String, Object>> result = orderDetailDAO.countSoldPro(list.get(0).getOrderid(),list.get(list.size() - 1).getOrderid());
			for(int j = 0 ; j < result.size() ; j ++) {
				Map<String,Object> hm = new HashMap<>();
				hm.put("pro",productDAO.selectById(Integer.parseInt(result.get(j).get("pro").toString())));
				hm.put("sum", result.get(j).get("sum").toString());
				realresult.add(hm);
			}
			
		
		return realresult;
	}

}
