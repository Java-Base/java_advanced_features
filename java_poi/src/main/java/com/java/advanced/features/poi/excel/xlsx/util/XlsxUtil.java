package com.java.advanced.features.poi.excel.xlsx.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.java.advanced.features.poi.excel.xlsx.model.Data;

/**
 * Util test create xlsx file
 *
 * @author 	Lian
 * @time	2016年8月11日
 * @since 	1.0
 */
public class XlsxUtil {

	private static List<Data> list = new ArrayList<Data>();

	static {
		Data record = null;
		for (int i = 0; i < 100; i++) {
			record = new Data("name" + i, i, "mail" + i, "address" + i);
			list.add(record);
		}
	}

	/**
	 * Create .xlsx file
	 */
	public static void createXlsx() {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("15元优惠券");

		// 创建数据头
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("NO.");
		row.createCell(1).setCellValue("名称");
		row.createCell(2).setCellValue("年龄");
		row.createCell(3).setCellValue("邮件");
		row.createCell(4).setCellValue("地址");

		padData(list.subList(0, 49), sheet);

		padData(list.subList(50, 99), sheet);

		// 将workbook保存为excel文件
		String path = "/Users/xingguliu/Downloads/" + "test.xlsx";
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("......done");
	}

	/**
	 * Padding data to row
	 *
	 * @param list
	 * @param sheet
	 */
	public static void padData(List<Data> list, Sheet sheet) {
		Row row = null;
		int i = 1;
		for(Data record : list) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(i);
			row.createCell(1).setCellValue(record.getName());
			row.createCell(2).setCellValue(record.getAge());
			row.createCell(3).setCellValue(record.getMail());
			row.createCell(4).setCellValue(record.getAddress());
			i++;
		}
	}

}
