package model.service;

import java.util.List;

import model.bean.ProductBean;

public interface MainPageSelectService {
	public List<ProductBean> selectByinput(String input);
}
