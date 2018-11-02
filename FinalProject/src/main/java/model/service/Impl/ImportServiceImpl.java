package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.ImportBean;
import model.dao.ImportDAO;
import model.service.ImportService;
@Service
public class ImportServiceImpl implements ImportService {
	@Autowired
	ImportDAO importDAO;
	
	
	public ImportServiceImpl() {
		
	}


	@Override
	public List<ImportBean> selectAll() {
		
		return importDAO.selectAll();
	}

	
	@Override
	public List<ImportBean> selectByOrderdate(String orderdate) {
		 	
		return importDAO.selectByOrderdate(orderdate);
	}
	
	@Override
	public List<ImportBean> selectByArrivedate(String arrivedate) {
		
		return importDAO.selectByArrivedate(arrivedate);
			
	}
	
	@Override
	public List<ImportBean> selectByStatus(String statu) {				
		return importDAO.selectByStatus(statu);
			
	}
	
	@Override
	public List<ImportBean> selectByADOD(String arrivedate, String orderdate) {
		return importDAO.selectByADOD(arrivedate, orderdate);
		
	}
	
	
	@Override
	public List<ImportBean> selectByADS(String arrivedate, String statu) {
		return importDAO.selectByADS(arrivedate, statu);
		
	}
	
	@Override
	public List<ImportBean> selectByODS(String orderdate, String statu) {
		return importDAO.selectByODS(orderdate, statu);
		
	}
	
	@Override
	public List<ImportBean> selectByADODS(String arrivedate, String orderdate, String statu) {
		return importDAO.selectByADODS(arrivedate, orderdate, statu);
		
	}


	@Override
	public ImportBean updateStatus(String statu, Integer improtid) {
			return importDAO.updateStatus(statu, improtid);
			
		}

}
