package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;

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
		if(str != null && str.length() > 0  && amount != null && amount.length() > 0) {
			String getStr [] = str.split(",");
			int count = 0;
			for(String get : getStr) {
				productDao.updateHotSeq(count++, Integer.parseInt(get));
			}
			if( change != null &&  change.length() > 0) {
				if(getStr.length < Integer.parseInt(amount)) {
					productDao.updateNoHot(Integer.parseInt(change)); 	
				}			
			}

			return true;
		}
		return false;
	}
	
	@Override
	public boolean addUpProductOne(String addid) {
		ProductBean temp = productDao.selectById(Integer.parseInt(addid));
		if(temp != null) {
			temp.setStatu("on");
			return true;
		}
		return false;
	}
	

	@Override
	public boolean removeProductOne(String removepro) {
		if(removepro.length() >0) {
			ProductBean temp = productDao.selectById(Integer.parseInt(removepro));
			if(temp != null) {
				temp.setStatu("off");
				return true;
			}
			
		}
		return false;
	}

	@Override
	public List<ProductBean> getUpProduct() {
		return productDao.selectUpProduct();
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
