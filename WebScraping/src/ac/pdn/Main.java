package ac.pdn;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws IOException {

		final String URL = "https://www.worldometers.info/coronavirus/";

		// getTotalCovidCases(URL);
		// getHTMLData();

		facStaffNames("https://sci.pdn.ac.lk/academic-staff.php");
	}

	private static void getTotalCovidCases(String url) throws IOException {

		// Connect to the website and get the HTML
		Document document = Jsoup.connect(url).get();

		// Get the title of the page
		String title = document.title();
		System.out.println(title);

		String query = "span[style=color:#8ACA2B]";
		Element worldPopulation = document.select(query).first();
		System.out.println(worldPopulation.text());
	}

	private static void getHTMLData() {

		String html = "<!DOCTYPE html><html><head><title>Example</title></head>"
				+ "<body><div id='main-content'>This is the main content div.</div>"
				+ "<p id='intro'>This is an introductory paragraph.</p></body></html>";

		// Parse the HTML
		Document document = Jsoup.parse(html);

		// Select element by ID
		Element mainContent = document.select("#main-content").first();
		System.out.println(mainContent.text());

		Element intro = document.select("#intro").first();
		System.out.println(intro.text());

	}

	private static void facStaffNames(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();

		Elements mainElement = doc.select("div#accordion");

		for (Element element : mainElement.select("div.single-accodion")) {
			Elements depTitle = element.select("div.dept-title-bg h4");
			System.out.println(depTitle.text());
		}
	}
}
