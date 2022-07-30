package restassured.ReadDataFromExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllData {
	public ArrayList<String> getdata(String BookAPITest ) throws IOException {
		
		
		
		
		  ArrayList<String> al=new ArrayList<String>();
				
				FileInputStream  fis= new FileInputStream("C:\\Users\\QQA0371\\eclipse-workspace\\rest-assured-learning-main.zip_expanded\\rest-assured-learning-main\\ExcelRead\\BookAPITest.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			int sheets=wb.getNumberOfSheets();
			for(int i=0; i<sheets; i++) {
			
			if(wb.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet=wb.getSheetAt(i);
			
				Iterator <Row> rows=sheet.iterator();
			   Row firstrow= rows.next();
			   // rows.next();
			 Iterator<Cell> cells=firstrow.cellIterator();   
			 int k=0;
			 int column=0;
			  while(cells.hasNext()) {
			 Cell value=cells.next() ; 
			   if( value.getStringCellValue().equalsIgnoreCase("BookAPITest")) {
				  column=k; 
			   }
			 k++;
			  }
			System.out.println(column);
			
			while(rows.hasNext()) {
				
			Row rovalue=rows.next();
			if(rovalue.getCell(column).getStringCellValue().equalsIgnoreCase("bookOne")) 
			{
				Iterator<Cell> cv=rovalue.cellIterator();
				while(cv.hasNext()) {
					Cell c=cv.next();
					if(c.getCellType()==CellType.STRING) {
						
					
				al.add(cv.next().getStringCellValue()); 
					
					}else {
						al.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						
					}
				}
			}
			}
			
			
			}
			//.System.out.println(al.get(0));
			}
		return al;
			}
		public static void main(String[] args)throws IOException {
			
		}
		}


