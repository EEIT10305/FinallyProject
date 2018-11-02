package testDao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

public class TestBugWebCrawler extends WebCrawler {
	Pattern Filters = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|zip|gz))$");

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return !Filters.matcher(href).matches() && href.startsWith("https://www.eclife.com.tw/");
	}

	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		System.out.println("***URL:" + url);
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData hpd = (HtmlParseData) page.getParseData();
			String html = hpd.getHtml();
			String text = hpd.getText();
			Set<WebURL> links = hpd.getOutgoingUrls();

		}
		super.visit(page);
	}

	public static void main(String[] args) {

		String folder = "C://temp//";
		try {
			CrawlConfig cc = new CrawlConfig();
			cc.setMaxDepthOfCrawling(0);
			cc.setCrawlStorageFolder(folder);
			PageFetcher pf = new PageFetcher(cc);
			RobotstxtConfig rc = new RobotstxtConfig();
			RobotstxtServer rs = new RobotstxtServer(rc, pf);
			CrawlController controller = new CrawlController(cc, pf, rs);
			
			controller.addSeed("https://www.eclife.com.tw/pc_nb/moreinfo_125207.htm");
			controller.addSeed("https://www.eclife.com.tw/pc_nb/moreinfo_125205.htm");

		
			controller.start(TestBugWebCrawler.class,7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
