package com.calculator.junit.first.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.calculator.junit.first.ÑalculatorEngine;
import com.calculator.junit.first.DivideByZeroException;

public class CalculatorEngineTest {
	ÑalculatorEngine myCalc;

	public static void main(String[] args) throws IOException {
	}

	@Before
	public void setUp() throws Exception {
		myCalc = new ÑalculatorEngine();
	}

	@After
	public void tearDown() throws Exception {
		myCalc = null;
	}

	@Test
	public void testOperationPlus() {
		double result = myCalc.operatePlus(10.0, 10.0);
		assertEquals(20.0, result, 0);
	}

	@Test
	public void testRandomNumbers() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Danik\\eclipse-workspace\\RandomNumbers.xlsx");
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
			assertEquals(actualResult, result, 0);
		}
		file.close();
	}

	@Test
	public void testOperationMinus() {
		double result = myCalc.operateMinus(10.0, 10.0);
		assertEquals(0.0, result, 0);
	}

	@Test
	public void testOperationMultiply() {
		double result = myCalc.operateMultiply(10.0, 10.0);
		assertEquals(100.0, result, 0);
	}

	@Test
	public void testOperationDevide() throws DivideByZeroException {
		double result = myCalc.operateDevide(10.0, 10.0);
		assertEquals(1.0, result, 0);
	}

	@Test(expected = DivideByZeroException.class)
	public void testDevideByZeroException() throws DivideByZeroException {
		double result = myCalc.operateDevide(10.0, 0.0);
		assertEquals(0.0, result, 0);
	}

	@Test
	public void testCalcResultPlus() throws DivideByZeroException {
		String testPlus = "+";
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.calcResult(firstNumber, testPlus, secondNumber);
		Assert.assertEquals(13.0, result, 0);
	}

	@Test
	public void testCalcResultMinus() throws DivideByZeroException {
		String testMinus = "-";
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.calcResult(firstNumber, testMinus, secondNumber);
		Assert.assertEquals(-5.0, result, 0);
	}

	@Test
	public void testCalcResultMultiply() throws DivideByZeroException {
		String testMultiply = "*";
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.calcResult(firstNumber, testMultiply, secondNumber);
		Assert.assertEquals(36.0, result, 0);
	}

	@Test
	public void testCalcResultDevide() throws DivideByZeroException {
		String testDevide = "/";
		double firstNumber = 8;
		double secondNumber = 2;
		double result = myCalc.calcResult(firstNumber, testDevide, secondNumber);
		Assert.assertEquals(4.0, result, 0);
	}

	@Test
	public void testCheckValidTrue() {
		String testParameter = "+";
		boolean isValidOperation = ÑalculatorEngine.checkValid(testParameter);
		Assert.assertTrue(isValidOperation);
	}

	@Test
	public void testCheckValidFalse() {
		String testParameter = "qwe";
		boolean isValidOperation = ÑalculatorEngine.checkValid(testParameter);
		Assert.assertTrue(isValidOperation == false);
	}

}
