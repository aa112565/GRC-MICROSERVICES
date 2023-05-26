package com.asymmetrix.grc.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.common.constants.RiskConstants;
import com.asymmetrix.grc.common.exception.RiskException;

public class ExcelHelper {

	private static final String FAIL_TO_PARSE = "Fail To Parse Excel File ";

	private static final Logger LOG = LoggerFactory.getLogger(ExcelHelper.class);

	private ExcelHelper() {
		super();
	}

	public static boolean hasExcelFormat(MultipartFile file) {
		return (!RiskConstants.TYPE_EXCEL.equals(file.getContentType())) ? Boolean.FALSE : Boolean.TRUE;
	}

	public static List<Map<String, Object>> getDetailsFromExcel(MultipartFile file, String sheetName) {
		try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is);) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<String> headerList = mapFirstRowAsHeader(rows.next());
			return mapAndGetDetails(rows, headerList);
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new RiskException(FAIL_TO_PARSE);
		}
	}

	private static List<Map<String, Object>> mapAndGetDetails(Iterator<Row> rows, List<String> headerList) {
		List<Map<String, Object>> excelDetailsList = new ArrayList<>();
		rows.forEachRemaining(row -> {
			Map<String, Object> excelDetailsMap = new HashMap<>();
			row.cellIterator().forEachRemaining(currentCell -> {
				excelDetailsMap.put(headerList.get(currentCell.getColumnIndex()), getCellValueAsString(currentCell));
			});
			excelDetailsList.add(excelDetailsMap);
		});
		return excelDetailsList;
	}

	private static List<String> mapFirstRowAsHeader(Row row) {
		List<String> list = new ArrayList<>();
		row.cellIterator().forEachRemaining(currentCell -> list.add(getCellValueAsString(currentCell)));
		return list;
	}

	private static String getCellValueAsString(Cell cell) {
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case NUMERIC:
			return String.valueOf((long) cell.getNumericCellValue() + "");
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case STRING:
			return cell.getStringCellValue();
		default:
			return "";
		}
	}

}
