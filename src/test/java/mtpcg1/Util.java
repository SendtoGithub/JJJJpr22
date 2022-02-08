package mtpcg1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	XSSFRow row;
	XSSFCell cell;
	String path= null;
	Util(String path){
		this.path= path;
	}
	public int rowcount(String shname) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(shname);
	  int rows = sh.getLastRowNum();
	  wb.close();
	  fis.close();
	  return rows;		
	}
	public int columcount(String shname, int rownum)throws IOException {
	    fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(shname);
	    row = sh.getRow(rownum);
	    int cols = row.getLastCellNum();
	    wb.close();
	    fis.close();
		return cols;
	}
	public String getcell(String shname,int rownum,int colnum) throws IOException{
		fis = new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sh = wb.getSheet(shname);
		row = sh.getRow(rownum);
	    cell = row.getCell(colnum);
	    DataFormatter format = new DataFormatter();
	    String data ;
	    try {
	    	data = format.formatCellValue(cell);
	    }
		catch(Exception e){
			data="";
		}
	    wb.close();
	    fis.close();
	    return data;
	}
}
