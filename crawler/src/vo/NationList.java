package vo;

import java.util.HashMap;

import controllers.Crawl;

public class NationList {
	public static HashMap<String, String> nationList = null;
	static {
		nationList = new HashMap<String, String>();
		nationList.put("Japan", "jp");
		nationList.put("USA", "us"); 
		nationList.put("UK", "gb");
		nationList.put("Chile", "cl");
		nationList.put("Singapore", "sg");
		nationList.put("Hongkong", "hk");
		nationList.put("Argentina", "ar");
		nationList.put("Austrailia", "au");
		nationList.put("Austria", "at");
		nationList.put("VietNam", "vn");
		nationList.put("Malaysia", "my");
		nationList.put("India", "in");
		//나라 추가할 거면 여기서 추가하자.
	}
}
