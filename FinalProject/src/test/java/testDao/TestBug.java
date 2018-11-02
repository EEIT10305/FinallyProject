package testDao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestBug {
	
	public static void main(String[] args) {
	
		String strurl="https://www.eclife.com.tw/pc_nb/moreinfo_125205.htm";
		String coll= "";
		        //創建url爬取核心對象
		        try {
		             URL url=new URL(strurl);
		             //通過url創建與網頁的連接
		             URLConnection conn=url.openConnection();
		             //通過鏈接取得網頁返回的數據
		             InputStream is=conn.getInputStream();
		             
		             System.out.println(conn.getContentEncoding());
		             //一般按行讀取網頁數據，並進行內容分析
		             //因此用BufferedReader和InputStreamReader把字節流轉化為字符流的緩衝流
		             //進行轉換時，需要處理編碼格式問題
		             BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
		         
		             //按行讀取並打印
		             String line=null;
		             while((line=br.readLine())!=null){
		            	 coll += line;
		             }
		             
		             System.out.println(coll.indexOf("sPrice"));
		             
		             br.close();
	         } catch (Exception e) {
		             // TODO Auto-generated catch block
		             e.printStackTrace();
		         }

	}

}
