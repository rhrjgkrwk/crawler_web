package controllers;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import vo.ChartVO;

public class Crawl {
	// 여기에 action 정의
	// 여기서 크롤링이랑 엑셀 저장까지?????
	// for를 돌려서 각 국의 차트를 긁어서 저장하자. 41개국.. 일본/중국/영국/칠레/싱가폴/미국 순
	public ArrayList<ChartVO> crawlChart(String nation) {
		ArrayList<ChartVO> contents = new ArrayList<>();// rank, artist, song
		try {

			Document doc = Jsoup.connect("https://itopchart.com/" + nation + "/en/top-songs/k-pop/").get();
			for (int i = 0; i < 100; i++) {
				contents.add(new ChartVO(doc.select(".rank").get(i).text(), doc.select(".artist").get(i).text(), doc.select("h3.app-name > a").get(i).text()));
			}

		} catch (IOException e1) { // Jsoup의 connect 부분에서 IOException 오류가 날 수eh.
			e1.printStackTrace();
		}
		return contents;
	}
}