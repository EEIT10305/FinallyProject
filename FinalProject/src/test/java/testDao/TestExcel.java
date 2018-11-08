package testDao;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TestExcel {
	public static String outputFile = "C:\\temp\\test.xls";

	public static void main(String argv[]) {
		try {

//		　　 創建新的Excel 活頁簿
			HSSFWorkbook workbook = new HSSFWorkbook();

//		　　// 在Excel活頁簿中建一工作表，其名為缺省值
//		　　　　　　// 如要新建一名為"效益指標"的工作表，其語句為：
//		　　　　　　// HSSFSheet sheet = workbook.createSheet("效益指標");
			HSSFSheet sheet = workbook.createSheet();

//		　　// 在索引0的位置創建行（最頂端的行）
			HSSFRow row = sheet.createRow((short) 0);

//		　　//在索引0的位置創建儲存格（左上端）
			HSSFCell cell = row.createCell((short) 0);
//		　　// 定義儲存格為字串類型
//			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//		　　// 在儲存格中輸入一些內容
			cell.setCellValue("增加值");
//		　　// 新建一輸出檔案流
			FileOutputStream fOut = new FileOutputStream(outputFile);
//		　　// 把相應的Excel 活頁簿存檔
			workbook.write(fOut);
			fOut.flush();
//		　　// 操作結束，關閉檔
			fOut.close();
			System.out.println("檔生成...");
		} catch (Exception e) {
			System.out.println("已運行 xlCreate() : " + e);
		}
	}

}
