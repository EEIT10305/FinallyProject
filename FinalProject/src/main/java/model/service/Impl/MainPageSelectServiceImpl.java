package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.ProductBean;
import model.dao.ProductDAO;
import model.service.MainPageSelectService;
@Repository
public class MainPageSelectServiceImpl implements MainPageSelectService {
    @Autowired
	private ProductDAO productDAO;
	@Override
	public List<ProductBean> selectByinput(String input) {		
		return productDAO.selectByinput(input);
	}

}
