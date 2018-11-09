package model.service.Impl;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.BranchStockBean;
import model.bean.OrderDetailBean;
import model.bean.OrderListBean;
import model.dao.BranchStockDAO;
import model.dao.OrderDetailDAO;
import model.dao.OrderListDAO;
import model.service.TestExcelService;
@Service
@Transactional
public class TestExcelServiceImpl implements TestExcelService {
	@Autowired
	private BranchStockDAO branchStockDAO;
	@Autowired
	private OrderListDAO orderListDAO;
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	public static String outputFile = "C:\\temp\\test.xls";
	@Override
	public List<BranchStockBean> ShowExcelInService(String yyyy,String MM,String dd) {
		String Time = yyyy+"/"+MM+"/"+dd ;
		List<BranchStockBean> BB = branchStockDAO.selectAllByBranchId(1);
		List<OrderListBean> OLB1 = orderListDAO.selectAllByTime(Time);
		List<OrderListBean> OLB2 = orderListDAO.selectAllByTime(Time);
//		for(int i=0 ;i<OLB1.size();i++) {
//			for(int j=0;i<OLB2.size();j++) {
//				if(OLB1.get(i).get)
//			}
//		}
		try {
			
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
				Date today=new Date();
				String now =sdf.format(today);
				HSSFWorkbook workbook = new HSSFWorkbook();

				HSSFSheet sheet = workbook.createSheet();
				int countx=1;
				int county=1;
				HSSFRow row0 = sheet.createRow((short) 0);
				HSSFCell row0cell0 = row0.createCell((short) 0);
				row0cell0.setCellValue(now+"-大安店");
				
				HSSFRow row1 = sheet.createRow((short) 1);
				HSSFCell row1cell0 = row1.createCell((short) 0);
				row1cell0.setCellValue("Model");
				
				HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell row2cell0 = row2.createCell((short) 0);
				row2cell0.setCellValue(now+" 庫存");
				
				HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell row3cell0 = row3.createCell((short) 0);
				row3cell0.setCellValue(Time+" 銷售數量");
				
//				HSSFRow row3 = sheet.createRow((short) 3);
//				HSSFCell row3cell0 = row3.createCell((short) 0);
//				row3cell0.setCellValue("Statu");
				for(int x = 0 ; x<BB.size();x++) {
					HSSFCell row1cellx = row1.createCell((short) countx);
					row1cellx.setCellValue(BB.get(x).getProductBean().getModel());
					HSSFCell row2cellx = row2.createCell((short) countx);
					row2cellx.setCellValue(BB.get(x).getAmount());
//					HSSFCell row3cellx = row3.createCell((short) count);
//					row3cellx.setCellValue(BB.get(x).getStatu());
					System.out.println("111111111111"+BB.get(x).getProductBean().getModel());
					countx++;
					county=1;
					for(int y=0;y<OLB1.size();y++) {
						List<OrderDetailBean> ODB = orderDetailDAO.selectAllByOrderId(OLB1.get(y).getOrderid());
						HSSFCell row3celly = row3.createCell((short) county);
						if(ODB.get(y).getModel().equals(BB.get(x).getProductBean().getModel())) {
							row3celly.setCellValue(1);
							System.out.println("222"+ODB.get(y).getModel());
						}
						county++;
					}
				}

				FileOutputStream fOut = new FileOutputStream(outputFile);

				workbook.write(fOut);
				fOut.flush();

				fOut.close();
				System.out.println("檔生成...");
		} catch (Exception e) {
			System.out.println("已運行 xlCreate() : " + e);
		}
		return BB;
	}
}
