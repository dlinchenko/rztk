import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.lang.String;
import java.lang.Object;


import java.util.HashMap;
import java.util.Map;

public class ExcelHelper {
    private HSSFWorkbook workbook;

    public ExcelHelper(){
        this.workbook = new HSSFWorkbook();
    }

    public void populateSheet(String sheetName, Map dataToPopulate){
        HSSFSheet sheet = this.workbook.createSheet(sheetName);

        int rowNum = 0;

        for(Object key:dataToPopulate.keySet()){
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(key.toString());
            cell = row.createCell(1);
            cell.setCellValue(dataToPopulate.get(key).toString());
        }
    }

    public HSSFWorkbook getWorkbook(){
        return this.workbook;
    }

}
