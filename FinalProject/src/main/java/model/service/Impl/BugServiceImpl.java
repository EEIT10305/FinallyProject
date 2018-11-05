package model.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.ProductBean;
import model.dao.ProductDAO;
import model.service.BugService;
import model.service.crawler.MyWebCrawler;

@Service
@Transactional
public class BugServiceImpl implements BugService {
	
	private MyWebCrawler mwc;
	@Autowired
	private ProductDAO productDao ;
    
	public BugServiceImpl() {
		this.mwc = new MyWebCrawler();
	}

	@Override
	public List<ProductBean> getAllModel() {
		return productDao.selectProductExcludeDown();
	}

	@Override
	public ArrayList<HashMap<String, String>> getAllWebProduct(String orgin ,String page) {
	    HashMap<String, Set<String>> hm = mwc.visitPage(page);//取出第一頁的頁數連結和商品
	    ArrayList<HashMap<String, String>> empty = new ArrayList<>();//要回傳的陣列 用來蒐集商品資訊
	    Set<String> numberPage = hm.get("numberPage");
	    Set<String> proPage = hm.get("proPage");
	    Iterator<String> npi = numberPage.iterator();//頁數
	    while (npi.hasNext()) {
	    	HashMap<String, Set<String>> pro = mwc.visitPage(orgin + npi.next());
		    Set<String> proPage2 = pro.get("proPage");
		    Iterator<String> ppi2 = proPage2.iterator();//其他頁數的商品
		    while(ppi2.hasNext()) {
		    	ArrayList<HashMap<String, String>> pro2 = mwc.visitContentPage(orgin + ppi2.next());
		    	empty.addAll(pro2);
		    } 
		    System.out.println(empty);
	    }
	    Iterator<String> ppi = proPage.iterator();//商品
	    while (ppi.hasNext()) {
	    	ArrayList<HashMap<String, String>> pro = mwc.visitContentPage(orgin + ppi.next());
	    	empty.addAll(pro);
	    }

		return empty;
	}
	
//gogogogogogogogogoggogogogogoogogogogogogogogoggogoggogo衝突阿rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
//	衝起來衝起來!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	問題怎麼這麼多!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
}
