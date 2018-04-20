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
	
	public boolean makeExcel(String pathDir, String[] checked) { // ���⼭��
		boolean result = true; // ���,//
		HashMap<String, String> nationList = NationList.nationList;
		File path = getFilePath(pathDir); // path�� �޾ƿ���
		
		// �޾ƿ� �ؽ����� iter������ ��Ʈ�� �ϳ��� �ͱ���.
		HSSFWorkbook workbook = new HSSFWorkbook(); // �� xls file ����
		
		
		for (String nation : checked) {
			ArrayList<ChartVO> contents = crawler.crawlChart(nationList.get(nation));
			HSSFSheet sheet = workbook.createSheet(nation);
			String thisWeek = new SimpleDateFormat("MM��W����").format(new Date());
			
			HSSFRow row = sheet.createRow(0); // ������ ���� 0������ ����
			HSSFCell cell = row.createCell(0); // ���� ���� 0������ ����
			cell.setCellValue(thisWeek + " " + nation + " Chart"); // title���������.
			
			int rowCount = 1;
			for (ChartVO vo : contents) {
				row = sheet.createRow(rowCount++); // ������ ���� 0������ ����
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
			System.out.println("�������ϻ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�������ϻ�������");
			result = false;
		}

		return result;
	}
	
	public File getFilePath(String pathDir) { // ��θ� �޾ƿ���.
		Date today = new Date();
		SimpleDateFormat dayTime = new SimpleDateFormat("YYYY_MM_dd");
		String str = dayTime.format(today);
		String temp = pathDir + "\\" + str + "_Charts.xls";
		File path = new File(temp);
		return path;
	}
}
