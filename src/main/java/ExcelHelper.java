import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import edu.emory.mathcs.backport.java.util.Collections;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.lang.String;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class ExcelHelper {
    private HSSFWorkbook workbook;

    ExcelHelper(){
        this.workbook = new HSSFWorkbook();
    }

    void populateSheet(String sheetName, Map dataToPopulate, String orderBy){
        Ordering<Map.Entry<String, Integer>> byMapValues = new Ordering<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
                return left.getValue().compareTo(right.getValue());
            }
        };
        List<Map.Entry<String, Integer>> sortedMap = Lists.newArrayList(dataToPopulate.entrySet());
        if(orderBy.equals("desc")){ Collections.sort(sortedMap, byMapValues.reverse());}
        else if(orderBy.equals("asc")){Collections.sort(sortedMap, byMapValues);}

        HSSFSheet sheet = this.workbook.createSheet(sheetName);

        int rowNum = 0;
        for(HashMap.Entry<String, Integer> hm: sortedMap) {
                Row row = sheet.createRow(rowNum++);
                Cell cell = row.createCell(0);
                cell.setCellValue(hm.getKey());
                cell = row.createCell(1);
                cell.setCellValue(hm.getValue());
            }
        }


    HSSFWorkbook getWorkbook(){
        return this.workbook;
    }

}
