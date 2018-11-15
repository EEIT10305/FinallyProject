package model.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import misc.AutoSendEmailByJava;
import model.bean.BranchStockBean;
import model.bean.ImportBean;
import model.bean.ImportDetailBean;
import model.bean.MemberBean;
import model.bean.MessageBean;
import model.bean.ProductBean;
import model.bean.WishBean;
import model.dao.BranchStockDAO;
import model.dao.ImportDAO;
import model.dao.ImportDetailDAO;
import model.dao.MemberDAO;
import model.dao.MessageDAO;
import model.dao.ProductDAO;
import model.dao.WishDAO;
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

	@Autowired
	MemberDAO memberDAO;

	@Autowired
	WishDAO wishDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	MessageDAO messageDAO;

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

			System.out.println(" proid ===================" + importDetailBean.get(x).getProid());

			BranchStockBean branch = branchStockDAO.selectAllBy(importDetailBean.get(x).getProid());

//如果branch_stock裡面有ImportDetailBean的proid
//update				

			if (branch != null) {
				if (branch.getProid() == proid) {

					System.out.println("branchid============================" + branch.getBranchid());
					int total = importDetailBean.get(x).getAmount() + branch.getAmount();

					branch.setAmount(total);

					branchStockDAO.update(branch);

					List<WishBean> allProWishList = wishDAO.selectAllByProId(importDetailBean.get(x).getProid());
					System.out.println("補貨");
					System.out.println("有沒有抓到會員的願望清單" + allProWishList);
					for (WishBean everyWishList : allProWishList) {
						System.out.println("進入迴圈");
						if (everyWishList.getTracked() == 2) {
							MemberBean memberBean = memberDAO.selectById(everyWishList.getMemberid());
							ProductBean productBean = productDAO.selectById(importDetailBean.get(x).getProid());
							System.out.println("會員mail=" + memberBean.getEmail() + "大選電腦提醒您!關注商品已到貨" + "商品名稱為："
									+ productBean.getModel());
							System.out.println("自動發mail第幾封?=>" + x);
							AutoSendEmailByJava.processMemberWishNotice(memberBean.getEmail(), "大選電腦提醒您!關注商品已到貨",
									"親愛的會員您好!您關注的商品:" + productBean.getModel() + "已到貨");
						}
					}

					result.add(branch);
				}

				break;
			}
//如果branch_stock裡面沒有ImportDetailBean的proid
//insert		
			else {

				System.out.println("insert into stock+++++++++++++++++++++++++++++++++++++++++++++++");
//                新增到庫存表
				BranchStockBean bean = new BranchStockBean(null, importDetailBean.get(x).getAmount(), 1,
						importDetailBean.get(x).getProid(), "on");
				branchStockDAO.insert(bean);
//				新增一筆到message表格
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				String da = sdf.format(new Date());
				MessageBean mbean = new MessageBean(null, 3, 6, da, "Dear同事:\\n請協助商品"+importDetailBean.get(x).getProductBean().getModel()+"上架，謝謝。\\n\\n  Best Regards", "請協助商品上架", "notyet");
				
				
				result.add(bean);
				break;

			}

		}

		return result;
	}

}
