package controllers;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import vo.ChartVO;

public class Crawl {
	// ���⿡ action ����
	// ���⼭ ũ�Ѹ��̶� ���� �������?????
	// for�� ������ �� ���� ��Ʈ�� �ܾ ��������. 41����.. �Ϻ�/�߱�/����/ĥ��/�̰���/�̱� ��
	public ArrayList<ChartVO> crawlChart(String nation) {
		ArrayList<ChartVO> contents = new ArrayList<>();// rank, artist, song
		try {

			Document doc = Jsoup.connect("https://itopchart.com/" + nation + "/en/top-songs/k-pop/").get();
			for (int i = 0; i < 100; i++) {
				contents.add(new ChartVO(doc.select(".rank").get(i).text(), doc.select(".artist").get(i).text(), doc.select("h3.app-name > a").get(i).text()));
			}

		} catch (IOException e1) { // Jsoup�� connect �κп��� IOException ������ �� ��eh.
			e1.printStackTrace();
		}
		return contents;
	}
}