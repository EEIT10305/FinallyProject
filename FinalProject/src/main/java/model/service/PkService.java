package model.service;

import java.util.List;

import com.google.gson.JsonElement;

import model.bean.PinginBean;
import model.bean.PinginDetailBean;

public interface PkService {

	List<PinginBean> pkSelectAll();

	List<PinginDetailBean> showPinginDetail(String name);

	void updateCartDetailAmount(Integer cartid, Integer amount, Integer proid);

}