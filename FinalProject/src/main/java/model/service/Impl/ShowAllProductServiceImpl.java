package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.ProductBean;
import model.dao.ProductDAO;
import model.service.ShowAllProductService;

@Service
public class ShowAllProductServiceImpl implements ShowAllProductService {
	@Autowired
	private ProductDAO productDAO;
	@Override
	public List<ProductBean> selectAll() {
				
		return productDAO.selectAll();		
	}
}
