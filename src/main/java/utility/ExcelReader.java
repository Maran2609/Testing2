package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Object[][] getdata(String name) throws IOException
	{
		FileInputStream file=new FileInputStream(".\\testdata\\Book1.xlsx");
		XSSFWorkbook Workbook =new XSSFWorkbook(file);
		XSSFSheet sheetname=Workbook.getSheet(name);
		Object[][] data=new Object[sheetname.getLastRowNum()][sheetname.getRow(0).getLastCellNum()];//[0][0]
		for(int i=0;i<sheetname.getLastRowNum();i++)
		{
			for(int j=0;j<sheetname.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheetname.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
