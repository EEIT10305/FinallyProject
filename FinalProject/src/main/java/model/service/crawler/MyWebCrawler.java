package model.service.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


public class MyWebCrawler {

	public HashMap<String, Set<String>> visitPage(String pageUrl) {
		HashMap<String, Set<String>> hm = new HashMap<>();
		Set<String> numberPage = new HashSet<>();
		Set<String> proPage = new HashSet<>();
		try {
			Document doc = Jsoup.connect(pageUrl).data("query", "Java") // 请求参数
					.userAgent("yinyuanmeow") // 设置 User-Agent
					.cookie("auth", "token") // 设置 cookie
					.timeout(3000) // 设置连接超时时间
					.post();
			Elements bodyEles = doc.select("a[target$=_blank] ,a.page_link");// 商品連結
			for (Element item : bodyEles) {
//				System.out.println(item.attr("href"));
				if (item.attr("href").startsWith("index.php?app=search")) {
					numberPage.add(item.attr("href"));
				} else if (item.attr("href").startsWith("index.php?app=goods&id")) {
					proPage.add(item.attr("href"));
				}
				hm.put("numberPage", numberPage);
				hm.put("proPage", proPage);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hm;
	}

	public ArrayList<HashMap<String, String>> visitContentPage(String contentUrl) {
		ArrayList<HashMap<String, String>> list = new  ArrayList<>();
		ArrayList<String> price = new ArrayList<>();
		ArrayList<String> proName = new ArrayList<>();
		ArrayList<String> picture = new ArrayList<>();
		try {
			Document doc = Jsoup.connect(contentUrl).data("query", "Java") // 请求参数
					.userAgent("yinyuanmeow") // 设置 User-Agent
					.cookie("auth", "token") // 设置 cookie
					.timeout(3000) // 设置连接超时时间
					.post();
			Elements bodyEles = doc.select("span.fontColor3");// 價格
			Elements bodyEles2 = doc.select("h2.ware_title");// 標頭
			Elements bodyEles5 = doc.select("span.jqzoom");// 圖片
			for(int i = 0 ; i < bodyEles.size() ;i++) {
				HashMap<String, String> hm = new HashMap<>();
				hm.put("price",bodyEles.get(i).text());
				hm.put("proName",bodyEles2.get(i).text());
				hm.put("picture",bodyEles5.get(i).childNode(0).attr("src"));
				list.add(hm);
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<HashMap<String, String>> getWebProCategory(String origin) {
		ArrayList<HashMap<String, String>> list = new  ArrayList<>();
		try {
			Document doc = Jsoup.connect(origin).data("query", "Java") // 请求参数
					.userAgent("yinyuanmeow") // 设置 User-Agent
					.cookie("auth", "token") // 设置 cookie
					.timeout(3000) // 设置连接超时时间
					.post();
			Elements bodyEles =  doc.select("a.hover");// 商品連結
			for (Element item : bodyEles) {
				HashMap<String, String> hm = new HashMap<>();
				System.out.println(item.text() +"-------------------" +item.attr("href"));
				hm.put("catagory" ,item.text());
				hm.put("cateUrl",item.attr("href"));
				list.add(hm);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
