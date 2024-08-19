package cs.pdn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class App {
	public static void main(String[] args) throws IOException {
		String webpage = "https://sci.pdn.ac.lk/";
		String html = Jsoup.connect(webpage).get().html();
		Document doc = Jsoup.parse(html);
		//System.out.println(html);
//		System.out.println(doc.select("title").text());
		
//		Elements links = doc.select("a[href]");
//		for(Element link:links) {
//			System.out.println("\nlink: "+link.attr("href"));
//			System.out.println("text: "+link.text());
//		}
//		
		Elements images = doc.select("img");
		for(Element src:images) {
			System.out.println("src :"+ src.attr("src"));
		}
			
	}

}
