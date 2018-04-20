package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import vo.ChartVO;
import vo.NationList;



public class ExportExcel {
	private HashMap<String, String> nationList = null;
	private Crawl crawler = null;
	
	ExportExcel() {
		
	}
	
	public boolean makeExcel(String pathDir, String[] checked) { // 여기서는
		boolean result = true; // 경로,//
		HashMap<String, String> nationList = NationList.nationList;
		File path = getFilePath(pathDir); // path를 받아오자
		
		// 받아온 해쉬맵을 iter돌려서 시트를 하나씩 맹글자.
		HSSFWorkbook workbook = new HSSFWorkbook(); // 새 xls file 생성
		
		
		for (String nation : checked) {
			ArrayList<ChartVO> contents = crawler.crawlChart(nationList.get(nation));
			HSSFSheet sheet = workbook.createSheet(nation);
			String thisWeek = new SimpleDateFormat("MM월W주차").format(new Date());
			
			HSSFRow row = sheet.createRow(0); // 엑셀의 행은 0번부터 시작
			HSSFCell cell = row.createCell(0); // 행의 셀은 0번부터 시작
			cell.setCellValue(thisWeek + " " + nation + " Chart"); // title을집어넣자.
			
			int rowCount = 1;
			for (ChartVO vo : contents) {
				row = sheet.createRow(rowCount++); // 엑셀의 행은 0번부터 시작
				row.createCell(0).setCellValue(vo.getRank());
				row.createCell(1).setCellValue(vo.getArtist());
				row.createCell(2).setCellValue(vo.getSong());
			}
		}
		
		try {
			FileOutputStream fileoutputstream = new FileOutputStream(path);
			workbook.write(fileoutputstream);
			fileoutputstream.close();
			workbook.close();
			System.out.println("엑셀파일생성성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("엑셀파일생성실패");
			result = false;
		}

		return result;
	}
	
	public File getFilePath(String pathDir) { // 경로를 받아오자.
		Date today = new Date();
		SimpleDateFormat dayTime = new SimpleDateFormat("YYYY_MM_dd");
		String str = dayTime.format(today);
		String temp = pathDir + "\\" + str + "_Charts.xls";
		File path = new File(temp);
		return path;
	}
}
