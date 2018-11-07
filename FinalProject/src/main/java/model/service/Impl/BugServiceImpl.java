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

import model.bean.CategoryBean;
import model.bean.ProductBean;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.service.BugService;
import model.service.crawler.MyWebCrawler;

@Service
@Transactional
public class BugServiceImpl implements BugService {
	
	private MyWebCrawler mwc;
	@Autowired
	private ProductDAO productDao ;
	@Autowired
	private CategoryDAO categoryDao ;
	
    
	public BugServiceImpl() {
		this.mwc = new MyWebCrawler();
	}
    
	@Override
	public ArrayList<HashMap<String, String>> getWebProCategory(String orgin) {
		ArrayList<HashMap<String, String>> result = mwc.getWebProCategory(orgin);
		ArrayList<HashMap<String, String>> realresult = new ArrayList<>();
		List<CategoryBean> all = categoryDao.selectAll();
		String allstr = "";
		for(CategoryBean cb : all) {
			allstr += cb.getCategory() + ",";
		}
		for(HashMap<String, String> hm : result) {
			if(allstr.indexOf(hm.get("catagory")) != -1) {
				realresult.add(hm);
			}
		}
		return realresult;
	}


	@Override
	public ArrayList<HashMap<String, String>> getAllWebProduct(String orgin ,String page) {
	    HashMap<String, Set<String>> hm = mwc.visitPage(page);//取出第一頁的頁數連結和商品
	    ArrayList<HashMap<String, String>> empty = new ArrayList<>();//要回傳的陣列 用來蒐集商品資訊
	    Set<String> numberPage = hm.get("numberPage");
	    Set<String> proPage = hm.get("proPage");
	    System.out.println(numberPage.size());
	    System.out.println(proPage.size());
	    Iterator<String> npi = numberPage.iterator();//頁數
	    while (npi.hasNext()) {
	    	HashMap<String, Set<String>> pro = mwc.visitPage(orgin + npi.next());
		    Set<String> proPage2 = pro.get("proPage");
		    Iterator<String> ppi2 = proPage2.iterator();//其他頁數的商品
		    while(ppi2.hasNext()) {
		    	ArrayList<HashMap<String, String>> pro2 = mwc.visitContentPage(orgin + ppi2.next());
		    	empty.addAll(pro2);
		    } 
		    System.out.println(empty.size());
	    }
	    Iterator<String> ppi = proPage.iterator();//商品
	    while (ppi.hasNext()) {
	    	ArrayList<HashMap<String, String>> pro = mwc.visitContentPage(orgin + ppi.next());
	    	empty.addAll(pro);
	    }

		return empty;
	}

	@Override
	public List<Object> getSubTablePro(String category) {
		List<Object> list = null;
		CategoryBean bean = categoryDao.getCategoryBeanBycategorycode(category);
		if(bean != null) {
			String hql="From " + bean.getCode();
			list = categoryDao.selectSubTable(hql);			
		}
		return list;
	}
	
//gogogogogogogogogoggogogogogoogogogogogogogogoggogoggogo衝突阿rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
//	衝起來衝起來!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	問題怎麼這麼多!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
}
