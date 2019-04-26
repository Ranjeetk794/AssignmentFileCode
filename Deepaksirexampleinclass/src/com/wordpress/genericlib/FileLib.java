package com.wordpress.genericlib;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Ranjeet Kumar
 *This class contain File related methods, which is used read the data from Excel & Properties.
 */
public class FileLib {
	/**
	 * its used the property key value from commanData.properties
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getPropetyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./Datafile/commanData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value= pobj.getProperty(key);
	return value;
		
	}
	/**
	 * its used to read data from Excel-WorkBook, based on User agument.
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return data
	 * @throws Throwable
	 */
	public String getExcellData(String sheetName, int rowNum,int celNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./Datafile/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	/**
	 * its used to write data back to Excel based on user argumnet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public String getExcellData(String sheetName, int rowNum,int celNum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/testData.xlsx");
		wb.write(fos);
		wb.close();
		return data;
		
	}

}
