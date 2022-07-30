package restassured.ReadDataFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegration {
public static String fileName="C:\\Users\\QQA0371\\eclipse-workspace\\rest-assured-learning-main.zip_expanded\\rest-assured-learning-main\\ExcelRead\\BookAPITest.xlsx";
public static String SheetName="Sheet1";	
public static String testCaseLiteral="TestCases";	

public static String testCaseName="bookOne";	


	public static void main(String[] args) throws Exception {
	
		Map<String ,Integer>rowColoumMap = searchfortestcase( fileName,  SheetName , testCaseLiteral) ;
		getDataforTestCase(rowColoumMap ,fileName ,SheetName,testCaseName);
	}
	public static ArrayList< Object> getDataforTestCase(Map<String ,Integer> rowColoumMap ,
			 String fileName, String sheetName ,String testCaseName) throws Exception {
		     ArrayList<Object> al=new ArrayList<>();
	
		     FileInputStream fis =new FileInputStream(fileName);
             XSSFWorkbook wb=new XSSFWorkbook(fis);
             int totalnoOfsheet=  wb.getNumberOfSheets();
             System.out.println("Total no of sheets =" +totalnoOfsheet);
             Iterator <Sheet>SheetIterator =wb.iterator();
             Sheet xsheet =SheetIterator.next();
    
         while(SheetIterator.hasNext())
	     if(xsheet.getSheetName().equals(SheetName)) {
   
		Integer rowNumber= rowColoumMap.get("row") + 1;
		Integer columnNumber= rowColoumMap.get("column") ;
		Integer rowindex=0;
		Integer columnIndex=0;
        Iterator<Row> rowiterator =xsheet.iterator();
	    while(rowiterator.hasNext()) {
		if(rowindex >=rowNumber) {
		Row curentrow=rowiterator.next();
		if(curentrow.getCell(columnNumber).toString().equals(testCaseName)) {
		//	columnNumber++;
		
		Iterator<Cell> celliterator=curentrow.cellIterator();
	    while(celliterator.hasNext()){
	   if(columnIndex >=columnNumber) {
	    	Cell currentcell=celliterator.next();
	    	if(currentcell.getCellType().equals(CellType.STRING)) {
	    		al.add(currentcell.getStringCellValue());
	    		//columnNumber=columnIndex;
	    		//isfound=true;
	    	}
	    	}
	    	else {
	    		String ConvertedCellValue=NumberToTextConverter.toText(currentcell.getNumericCellValue());
	    	al.add(ConvertedCellValue);
	    	}
	  
	    }
	    rowindex++;
	}
	   else {
		   celliterator.next();
		   columnIndex++;
	     }
	    }
	    }//rowNumber=rowindex;
		rowindex++;	
	}
		else {
			rowiterator.next();	
			rowindex++;
		}
	}	
	}		

	

System.out.println(al);
return al;

	
}

public static Map<String ,Integer> searchfortestcase(String fileName, String SheetName ,String testCaseLiteral) throws IOException{
	Map<String ,Integer> rowColoumMap =new HashMap<>();
	
	FileInputStream fis =new FileInputStream(fileName);
    XSSFWorkbook wb=new XSSFWorkbook(fis);
     int totalnoOfsheet=  wb.getNumberOfSheets();
   // System.out.println("Total no of sheets =" +totalnoOfsheet);
int columnNumber=-1;
int rowNumber=-1;
for(int i=0; i<totalnoOfsheet; i++) {
	if(wb.getSheetName(i).equalsIgnoreCase(SheetName)) {
	//System.out.println("Post sheet is found !");
    
	XSSFSheet xsheet=wb.getSheetAt(i);
	Iterator<Row> rowiterator =xsheet.rowIterator();
	boolean isfound=false;
	int rowindex=0;
	while(rowiterator.hasNext()) {
		Row curentrow=rowiterator.next();
		Iterator<Cell> celliterator=curentrow.cellIterator();
	    int columnIndex=0;
	    while(celliterator.hasNext()){
	    Cell currentcell=celliterator.next();
	    	if(currentcell.getStringCellValue().equals(testCaseLiteral)) {
	    		columnNumber=columnIndex;
	    		isfound=true;
	    	break;
	    	}
	columnIndex++;
	
	}
	if(isfound) {
		rowNumber=rowindex;
	break;
	}
	rowindex++;

	}
	rowColoumMap.put("row", rowNumber);
	rowColoumMap.put("column", columnNumber);

}
	
}
System.out.println(rowColoumMap);
return rowColoumMap;
}
}