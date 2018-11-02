package testDao;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

public class TestBugMyWebCrawler extends WebCrawler {
	
private final static Pattern FILTERS = Pattern.compile("-\\d+");
private static ArrayList array = new ArrayList<>();;
private static ArrayList array2 = new ArrayList<>();;
private static ArrayList array3 = new ArrayList<>();
private static String varWebsite;;

    
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        
        return FILTERS.matcher(href).find() && href.startsWith("http://www.gh3c.com.tw/") && !href.endsWith("posts") && !href.endsWith("answers") && !href.endsWith("asks") && !href.endsWith("collections");
    }
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            Document doc = Jsoup.parse(html);
//            <span class="value" id="PriceTotal" itemprop="price">14490</span>
//            <span class="fontColor3" ectype="goods_price">$6,790</span>
//            <h2 class="ware_title">INTEL Core i3-8100(代理盒裝3年保固)</h2>
//            <a href="index.php?app=goods&amp;id=23429" target="_blank">INTEL Core i9-9900K (代理盒裝3年保固)</a>
            Elements bodyEles = doc.select("span.fontColor3");
            Elements bodyEles2 = doc.select("h2.ware_title");
            Elements bodyEles3 = doc.select("a[target$=_blank]");
            for(Element item : bodyEles){
            	array.add(item.text());
            	System.out.println(array.toString());
//          	 System.out.println("span#PriceTotal:" + item.text());
            	 
            }
            for(Element item : bodyEles2){
            	array2.add(item.text());
            	System.out.println(array2.toString());
//           	System.out.println("span#PriceTotal:" + item.text());
            	
            }
            for(Element item : bodyEles3){
            	array3.add(item.attr("href"));
            	varWebsite = item.attr("href");
            	System.out.println("varWebsite:" + varWebsite);
            	System.out.println(array3.toString());
            	
            }
          
        }
    }


    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "C://temp//";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setFollowRedirects(true);
        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        
//        for(int x = 19950 ; x < 23000 ; x++) {
//        	controller.addSeed("http://www.gh3c.com.tw/index.php?app=goods&id="+x);
//        }
//
        controller.addSeed("http://www.gh3c.com.tw/index.php?app=store&id=29&act=search&cate_id=408"); 
        
//        controller.addSeed("http://www.gh3c.com.tw/index.php?app=goods&id=21029");
//        controller.addSeed("http://www.gh3c.com.tw/index.php?app=goods&id=21027");
//        controller.addSeed("http://www.gh3c.com.tw/index.php?app=goods&id=19950");
//        controller.addSeed("http://www.gh3c.com.tw/index.php?app=goods&id=21970");
//        controller.addSeed("http://www.gh3c.com.tw/index.php?app=goods&id=22664");
//        controller.addSeed("http://www.gh3c.com.tw/index.php?app=goods&id=99999");
//

        controller.start(TestBugMyWebCrawler.class, numberOfCrawlers);
        
        PageFetcher pageFetcher2 = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig2 = new RobotstxtConfig();
        RobotstxtServer robotstxtServer22 = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller2 = new CrawlController(config, pageFetcher, robotstxtServer);
        System.out.println(array3.size());
        for(int i = 0 ; i < array3.size() ; i++) {
        	controller2.addSeed("http://www.gh3c.com.tw/" + array3.get(i)); 
        	
        }
        
        controller2.start(TestBugMyWebCrawler.class, numberOfCrawlers);
        
        
    }


}
