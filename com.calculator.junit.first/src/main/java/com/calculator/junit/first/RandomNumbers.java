package com.calculator.junit.first;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RandomNumbers {
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Danik\\Desktop\\practice\\RandomNumbers.xlsx");
		Workbook wb = new XSSFWorkbook(file);
		ArrayList firstNumberList = new ArrayList();
		ArrayList secondNumberList = new ArrayList();
		ArrayList listResult = new ArrayList();

		double number = 0;

		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		while (it.hasNext()) {
			Row row = it.next();
			Iterator<Cell> cells = row.iterator();
			while (cells.hasNext()) {
				Cell cell = cells.next();
				int columnIndex = cell.getColumnIndex();
				if (columnIndex != 0 && columnIndex != 1 && columnIndex != 2) {
					continue;
				}
				number = cell.getNumericCellValue();
				if (columnIndex == 0) {
					firstNumberList.add(number);
				}
				if (columnIndex == 1) {
					secondNumberList.add(number);
				}
				if (columnIndex == 2) {
					listResult.add(number);
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			double number1 = (Double) firstNumberList.get(i);
			double number2 = (Double) secondNumberList.get(i);
			double actualResult = (Double) listResult.get(i);
			double result = number1 + number2;
			if (actualResult == result) {
				System.out.println(result + " è " + actualResult);
			} else {
				System.out.println("Îøèáêà");
			}
		}
		file.close();
	}
}
