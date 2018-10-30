package model.service;

import java.util.List;

import model.bean.ProductBean;
import model.bean.WallBean;

public interface HotService {
	//拿到上架且推薦商品 
	public List<ProductBean> getNeedProduct();
	//拿到上架但非推薦商品
	public List<ProductBean> getNeedProduct2();
	//改店推薦商品放置順序
	public boolean changeProductSeq(String str, String change, String amount);
	//商品上架
	boolean insertPhotoSeq(String productid);
	//商品下架
	boolean changePhotoSeq(String productid);

}
