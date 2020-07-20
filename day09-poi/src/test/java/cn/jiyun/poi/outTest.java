package cn.jiyun.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class outTest {
	@Test
		public void outTest() throws Exception{
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("学生信息");
				XSSFRow row = sheet.createRow(0);
				String[] title={"编号","姓名","性别","生日","爱好","班级"};
				for(int i=0;i< title.length;i++){
					XSSFCell cell = row.createCell(i);
				cell.setCellValue(title[i]);
				}
				FileOutputStream stream = new  FileOutputStream("d:/学生信息.xlsx");
				workbook.write(stream);
		}
}
