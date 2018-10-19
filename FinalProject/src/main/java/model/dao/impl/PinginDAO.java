package model.dao.impl;

import java.sql.Blob;
import java.util.List;

import model.PinginBean;

public interface PinginDAO {

	PinginBean select(Integer pinginid);

	List<PinginBean> select();

	boolean update(String pinginid, String name, Integer price, String status, Blob picture);

	PinginBean insert(PinginBean bean);

	boolean delete(Integer pingin_id);

}