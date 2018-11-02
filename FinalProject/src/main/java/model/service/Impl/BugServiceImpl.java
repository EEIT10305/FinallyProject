package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.ProductBean;
import model.dao.ProductDAO;
import model.service.BugService;

@Service
public class BugServiceImpl implements BugService {
	@Autowired
	private ProductDAO productDao;

	@Override
	public List<ProductBean> getAllModel() {
		return productDao.selectProductExcludeDown();
	}
	
//gogogogogogogogogoggogogogogoogogogogogogogogoggogoggogo衝突阿rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
//	衝起來衝起來!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	問題怎麼這麼多!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
}
