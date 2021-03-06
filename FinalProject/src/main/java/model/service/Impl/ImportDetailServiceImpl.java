package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ImportDetailBean;
import model.dao.ImportDetailDAO;
import model.service.ImportDetailService;
@Service
@Transactional
public class ImportDetailServiceImpl implements ImportDetailService{

	
	@Autowired
	ImportDetailDAO importDetailDAO;
		
	public ImportDetailServiceImpl() {

	}
	
	
	@Override
	public List<ImportDetailBean> selectAll() {
		return importDetailDAO.selectAll();
	}


	@Override
	public ImportDetailBean selectByID(int id) {
		
		return importDetailDAO.selectById(id);
	}

	@Override
	public List<ImportDetailBean> selectAllByID(Integer improtid){
		
		return importDetailDAO.selectAllByID(improtid);
	}

}
