import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import edu.emory.mathcs.backport.java.util.Collections;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.lang.String;
import java.lang.Object;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelHelper {
    private HSSFWorkbook workbook;

    public ExcelHelper(){
        this.workbook = new HSSFWorkbook();
    }

    public void populateSheet(String sheetName, Map dataToPopulate, String orderBy){
        Ordering<Map.Entry<String, Integer>> byMapValues = new Ordering<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
                return left.getValue().compareTo(right.getValue());
            }
        };
        List<Map.Entry<String, Integer>> sort = Lists.newArrayList(dataToPopulate.entrySet());
        Collections.sort(sort, byMapValues.reverse());

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
