package controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.ProductBean;
import model.service.MainPageSelectService;
import model.service.NavigateService;

@Controller
public class ProductSelectByCategoryController {
	@Autowired
	NavigateService nav;
	@Autowired
	MainPageSelectService mainpageselect;
	
	//類別標籤
	@RequestMapping(path = "SelectByCategory",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String category() {
		return new Gson().toJson(nav.selectAllCategory());		
	}
	
	//品牌標籤
	@RequestMapping(path = "SelectByBrand",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectByBrand(String category) {
		Gson gson= new Gson();
		if(category!=null) {
			System.out.println(new Gson().toJson(nav.selectBrand(category)));
			return new Gson().toJson(nav.selectBrand(category));
		}
		return null;	
	}
	//左邊按下分類標籤即時顯示商品
	@RequestMapping(path = "showProductByCategory",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showProductByCategory(String leftcategory) {
		return new Gson().toJson(nav.showProductByCategory(leftcategory));		
	}
	

	
	//搜尋標籤&輸入搜尋
	@RequestMapping(path = "userInput",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String userInput(String category, String brand, Integer price, String searchspace) {
		System.out.println("category="+category);
		System.out.println("brand="+brand);
		System.out.println("price="+price);
		System.out.println("searchspace="+searchspace);
		
		//使用標籤
		if((searchspace).equals("ini") || (searchspace).equals("")) {
			//分類 品牌 價格 都有選
			if (!"ini".equals(category) && !"ini".equals(brand) && !price.equals(0)) {
//				System.out.println("==============================");
//				System.out.println("分類 品牌 價格 ");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCatBraPri(category, brand, price));		
				
			} // 分類 品牌 有選
			else if (!"ini".equals(category) && !"ini".equals(brand) && price.equals(0)) { 
//				System.out.println("==============================");
//				System.out.println("分類 品牌");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCatBra(category, brand));
			}// 分類 價格 有選
			else if (!"ini".equals(category) && "ini".equals(brand) && !price.equals(0)) { 
//				System.out.println("==============================");
//				System.out.println("分類 價格 ");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCatPri(category, price));
			}// 只選分類
			else if(!"ini".equals(category) && "ini".equals(brand) && price.equals(0)) {
//				System.out.println("==============================");
//				System.out.println("分類 ");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCat(category));				
			} else {				
				return null;
			}
		//使用輸入欄	
		} else  {
			System.out.println("======================================");
			System.out.println("隊地controller");
			System.out.println("======================================");
			return new Gson().toJson(nav.selectByinput(searchspace));		
		}
	}
	
	//左邊標籤
	@RequestMapping(path = "leftTag",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String leftTag(String leftcategory, String leftbrand, Integer leftprice) {
		System.out.println("======================================");
		System.out.println("leftcategory="+leftcategory);
		System.out.println("leftbrand="+leftbrand);
		System.out.println("leftprice="+leftprice);
		System.out.println("======================================");		
		
			//分類 品牌 價格 都有選
			if (!"ini".equals(leftcategory) && !"ini".equals(leftbrand) && !leftprice.equals(0)) {
//				System.out.println("==============================");
//				System.out.println("分類 品牌 價格 ");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCatBraPri(leftcategory, leftbrand, leftprice));		
				
			} // 分類 品牌 有選
			else if (!"ini".equals(leftcategory) && !"ini".equals(leftbrand) && leftprice.equals(0)) { 
//				System.out.println("==============================");
//				System.out.println("分類 品牌");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCatBra(leftcategory, leftbrand));
			}// 分類 價格 有選
			else if (!"ini".equals(leftcategory) && "ini".equals(leftbrand) && !leftprice.equals(0)) { 
//				System.out.println("==============================");
//				System.out.println("分類 價格 ");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCatPri(leftcategory, leftprice));
			}// 只選分類
			else if(!"ini".equals(leftcategory) && "ini".equals(leftbrand) && leftprice.equals(0)) {
//				System.out.println("==============================");
//				System.out.println("分類 ");
//				System.out.println("==============================");
				return new Gson().toJson(nav.selectByCat(leftcategory));				
			} else {				
				return null;
			}
			
		
		
		

	}
	
	
}
