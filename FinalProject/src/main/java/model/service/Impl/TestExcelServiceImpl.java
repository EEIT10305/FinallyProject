package model.service.Impl;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import model.dao.ProductDAO;
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
	@Autowired
	private ProductDAO productDAO;
	
	public static String outputFile = "C:\\temp\\test.xls";
	@Override
	public List<BranchStockBean> ShowExcelInService(String yyyy,String MM,String dd,Integer d) {
		List<BranchStockBean> BB = branchStockDAO.selectAllByBranchId(1);
		Map<String,Integer> map=productDAO.selectAllByHashMap();
		
		String days="";
		String date="";
		int ProductAmount=0;
		int total=0;
		
		try {
			
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
				Date today=new Date();
				String now =sdf.format(today);
				HSSFWorkbook workbook = new HSSFWorkbook();

				HSSFSheet sheet = workbook.createSheet();
				
				HSSFRow row0 = sheet.createRow((short) 0);
				HSSFCell row0cell0 = row0.createCell((short) 0);
				row0cell0.setCellValue(now+"-大安店");
				
				HSSFRow row1 = sheet.createRow((short) 1);
				HSSFCell row1cell0 = row1.createCell((short) 0);
				row1cell0.setCellValue("Model");
				
				HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell row2cell0 = row2.createCell((short) 0);
				row2cell0.setCellValue(now+" 庫存");
				
				int countx=1;
				int county=1;
				
				for(int x = 0 ; x<BB.size();x++) {
					HSSFCell row1cellx = row1.createCell((short) countx);
					row1cellx.setCellValue(BB.get(x).getProductBean().getModel());
					
					HSSFCell row2cellx = row2.createCell((short) countx);
					row2cellx.setCellValue(BB.get(x).getAmount());
					countx++;
				}
						for(int y= 0; y<d;y++) {
							days=yyyy+"/"+MM+"/"+(Integer.parseInt(dd)+y);
							date=sdf.format(sdf.parse(days));
							List<OrderListBean> OLB = orderListDAO.selectAllByTime(date);
							county=1;
							HSSFRow rowx = sheet.createRow((short) (3+y));
								for(int z=0;z<OLB.size();z++) {
									List<OrderDetailBean> ODB=orderDetailDAO.selectAllByOrderId(OLB.get(z).getOrderid());
									for(int i=0;i<ODB.size();i++) {
											ProductAmount =map.get(ODB.get(i).getModel());
											total=ProductAmount + ODB.get(i).getAmount();
											map.put(ODB.get(i).getModel(), total);
											
										}
									}
								for(int j=0;j<BB.size();j++) {
										HSSFCell rowxcell0 = rowx.createCell((short) 0);
										rowxcell0.setCellValue(date+" 銷售數量");
										HSSFCell rowxcelly = rowx.createCell((short) county);
										rowxcelly.setCellValue(map.get(BB.get(j).getProductBean().getModel()));
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
