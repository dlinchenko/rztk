import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHelper {

    private String fName;
    private Path resultFileName;
    private Path dir;

    FileHelper(String fName){
        this.fName = fName;
        this.resultFileName = makeFile();
    }

    private Path makeFile(){
        //creating file to save test results
        try{
            this.dir = Paths.get(System.getProperty("user.dir")+ File.separator+"TestResults");
            if (!Files.exists(this.dir)) {
                Files.createDirectory(this.dir);
            }
            Path fPath = this.dir.resolve(this.fName);
            if (Files.exists(fPath)) {
                Files.delete(fPath);
            }
            Files.createFile(fPath);
            return fPath;
            }
         catch (IOException e){
            System.err.format("IOException: %s%n", e);
            return null;
         }
    }

    void writeResultFile(List<String> strings){
        //writing to text file
            try {
                for (String s : strings) {
                    s = s + "\n";
                    Files.write(this.resultFileName, s.getBytes(), StandardOpenOption.APPEND);
                }
            } catch (Exception e) {
                System.err.format("Exception while trying to write the file: %s%n", e);
            }
    }

    void writeResultsFile(ExcelHelper excel){
        //writing to excel file
        try{
        HSSFWorkbook workbook = excel.getWorkbook();
        FileOutputStream f = new FileOutputStream(this.resultFileName.toString());
        workbook.write(f);
        f.close();
        }
        catch (IOException e){
            System.err.print(e);
        }
    }

    public Path getResultFilePath() {
        if(Files.exists(this.resultFileName)){
            return this.resultFileName;
        }
        else {
            return null;
        }
    }

    public String getResultFileName(){
        return this.fName;
    }

    public void deleteResultFile() throws IOException {
        if (Files.exists(this.resultFileName)){
            Files.delete(this.resultFileName);
        }
    }
}
