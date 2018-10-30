package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ProductBean;
import model.dao.ProductDAO;
import model.service.HotService;
@Service
@Transactional
public class HotServiceImpl implements HotService {

	@Autowired
	private ProductDAO productDao;
	@Override
	public List<ProductBean> getNeedProduct() {
		return productDao.selectNeedProduct();
	}

	@Override
	public List<ProductBean> getNeedProduct2() {
		return productDao.selectNeedProduct2();
	}

	@Override
	public boolean changeProductSeq(String str, String change, String amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertPhotoSeq(String productid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePhotoSeq(String productid) {
		// TODO Auto-generated method stub
		return false;
	}

}
