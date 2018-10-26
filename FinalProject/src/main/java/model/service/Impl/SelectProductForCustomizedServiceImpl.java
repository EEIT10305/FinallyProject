package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.CpuBean;
import model.bean.ProductBean;
import model.dao.ProductDAO;
import model.service.SelectProductForCustomizedService;
@Service
public class SelectProductForCustomizedServiceImpl implements SelectProductForCustomizedService {
	@Autowired
	private ProductDAO productDAO;
	@Override
	public List<ProductBean> selectCpu() {
				
		return productDAO.selectByCategory(1);		
	}
}
