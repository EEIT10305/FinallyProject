package model.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.BranchStockBean;
import model.bean.ImportBean;
import model.bean.ImportDetailBean;
import model.dao.BranchStockDAO;
import model.dao.ImportDAO;
import model.dao.ImportDetailDAO;
import model.service.ImportService;

@Service
@Transactional
public class ImportServiceImpl implements ImportService {
	@Autowired
	ImportDAO importDAO;

	@Autowired
	ImportDetailDAO importDetailDAO;

	@Autowired
	BranchStockDAO branchStockDAO;

	public ImportServiceImpl() {

	}

	@Override
	public List<ImportBean> selectAll() {

		return importDAO.selectAll();
	}

	@Override
	public ImportBean selectByimprotid(Integer improtid) {

		return importDAO.getImportDetail(improtid);
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
	public List<ImportBean> updateStatus(String statu, Integer improtid) {
		return importDAO.updateStatus(statu, improtid);

	}


	@Override
	public List<BranchStockBean> insertBranchStock(Integer improtid, Integer proid) {
		List<BranchStockBean> result = new ArrayList<>();
		System.out.println("result size======================================================" + result.size());

		List<ImportDetailBean> importDetailBean = importDetailDAO.selectAllByID(improtid);

		for (int x = 0; x < importDetailBean.size(); x++) {
			System.out.println("forrrrrrrrrrrrrrrrrrrr");

			System.out.println(" proid ==================="+importDetailBean.get(x).getProid());
					
			BranchStockBean branch = branchStockDAO.selectAllBy(importDetailBean.get(x).getProid());
			
//如果branch_stock裡面有ImportDetailBean的proid
//update				
			
			if (branch.getProid()==proid) {
				

				System.out.println("branchid============================" + branch.getBranchid());
				int total = importDetailBean.get(x).getAmount() + branch.getAmount();

				branch.setAmount(total);
								
				branchStockDAO.update(branch);
				result.add(branch);
				
				break;
			}
			else if(branch.getProid()== null){

				System.out.println("insert into stock+++++++++++++++++++++++++++++++++++++++++++++++");

				BranchStockBean bean = new BranchStockBean(null, importDetailBean.get(x).getAmount(), 1,
						importDetailBean.get(x).getProid(), "on");
				branchStockDAO.insert(bean);
				result.add(bean);
				break;

			}

		}
//如果branch_stock裡面沒有ImportDetailBean的proid
//insert		

		return result;
	}



}
