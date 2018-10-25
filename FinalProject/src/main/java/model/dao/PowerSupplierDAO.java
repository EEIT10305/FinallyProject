package model.dao;

import java.util.List;

import model.bean.PowerSupplierBean;

public interface PowerSupplierDAO {
	 List<PowerSupplierBean> selectAll();
	    PowerSupplierBean selectById(int id);
	    PowerSupplierBean insert(PowerSupplierBean bean);
	    boolean update(PowerSupplierBean bean);
}
