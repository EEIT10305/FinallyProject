package model.dao;

import java.sql.Blob;
import java.util.List;

import model.bean.PinginBean;

public interface PinginDAO {

	PinginBean selectById(int pinginid);
	List<PinginBean> selectAll();
	boolean update(PinginBean bean);
	PinginBean insert(PinginBean bean);
	boolean delete(Integer pingin_id);

}


