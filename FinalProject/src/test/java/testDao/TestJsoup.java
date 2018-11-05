package testDao;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 

public class TestJsoup {
	private static ArrayList array = new ArrayList<>();;
	private static ArrayList array2 = new ArrayList<>();;
	private static ArrayList array3 = new ArrayList<>();
	private static Set array4 = new HashSet<>();
	private static ArrayList array5 = new ArrayList<>();
	private static String varWebsite;;
	
	public static void main(String[] args) throws Exception {
            Parsing();
    }
	
	public static void Parsing() throws Exception {
//		 String html = "<html><head><title> 开源中国社区 </title></head>"
//				  + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>"; 
//				 Document doc = Jsoup.parse(html); 

//				 // 从 URL 直接加载 HTML 文档
		
				 Document doc = Jsoup.connect("http://www.gh3c.com.tw/index.php?app=goods&id=23429")
						  .data("query", "Java")   // 请求参数
						  .userAgent("I ’ m jsoup") // 设置 User-Agent 
						  .cookie("auth", "token") // 设置 cookie 
						  .timeout(3000)           // 设置连接超时时间
						  .post(); 
				 Elements bodyEles = doc.select("span.jqzoom");
				 for(Element item : bodyEles){
		            	array.add(item.text());  	 
		            	System.out.println("bodyEles5.get(i).attr(\"src\"):"+item.childNode(0).attr("src"));
		            }
//				 Elements links = doc.select("span[href]"); // 具有 href 属性的链接
//				 Elements pngs = doc.select("img[src$=.png]");// 所有引用 png 图片的元素
//				 <span class="jqzoom">
//				 <img src="data/files/store_29/goods_175/small_201704121926152593.png" width="300" height="300" jqimg="data/files/store_29/goods_175/201704121926152593.png" alt="">
//				 </span>
//				 Element masthead = doc.select("span.jqzoom").first(); 
				 // 找出定义了 class=masthead 的元素
				 
//				 System.out.println(masthead.childNode(0).attr("src"));
//				 String tupian = masthead.childNode(0).attr("src");
//				 String tupian_1 = "http://www.gh3c.com.tw/"+tupian;
//	                //連接url
//	                URL url1 = new URL(tupian_1);
//	                URLConnection uri=url1.openConnection();
//	                //獲取數據流
//	                InputStream is=uri.getInputStream();
//	                //獲取後綴名
//	                
//	                //寫入數據流
//	                OutputStream os = new FileOutputStream(new File("C:\\temp\\ya.png"));
//	                byte[] buf = new byte[1024];
//	                int p=0;
//	                while((p=is.read(buf))!=-1){
//	                    os.write(buf, 0, p);
//	                }


//				 Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
//				 String title = doc.title(); 

//				 Document doc = Jsoup.connect("http://www.oschina.net/") 
//				  .data("query", "Java")   // 请求参数
//				  .userAgent("I ’ m jsoup") // 设置 User-Agent 
//				  .cookie("auth", "token") // 设置 cookie 
//				  .timeout(3000)           // 设置连接超时时间
//				  .post();                 // 使用 POST 方法访问 URL 

				 // 从文件中加载 HTML 文档
//				 File input = new File("D:/test.html"); 
//				 Document doc = Jsoup.parse(input,"UTF-8","https://www.eclife.com.tw/pc_nb/moreinfo_125205.htm");

//				请大家注意最后一种 HTML 文档输入方式中的 parse 的第三个参数，为什么需要在这里指定一个网址呢（虽然可以不指定，如第一种方法）？因为 HTML 文档中会有很多例如链接、图片以及所引用的外部脚本、css 文件等，而第三个名为 baseURL 的参数的意思就是当 HTML 文档使用相对路径方式引用外部文件时，jsoup 会自动为这些 URL 加上一个前缀，也就是这个 baseURL。
//
//				例如 <a href=/project> 开源软件 </a> 会被转换成 <a href=http://www.oschina.net/project> 开源软件 </a>。

    }


}
