package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.BugService;

@Controller
public class BugController {
	@Autowired
	private BugService bugService;
	
	@RequestMapping(path="ShowAllProduct",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method() {
		return new Gson().toJson(bugService.getAllModel());	
	}
	@RequestMapping(path="BugWebsite",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method2() {
		String coll = "";
		String strurl="https://www.eclife.com.tw/pc_nb/moreinfo_125205.htm";
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
             br.close();
             return coll;
     } catch (Exception e) {
             e.printStackTrace();
             return "";
         }
	}
	

}
