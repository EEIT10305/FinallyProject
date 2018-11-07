package model.service;

import java.util.List;

import model.bean.ProductBean;

public interface ShowAllProductService {
	public List<ProductBean> selectAll();
}