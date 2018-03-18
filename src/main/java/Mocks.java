import java.util.List;
import java.util.Map;

public class Mocks {

    public static void textFileMock(List<String> testResults){
        for(String s: testResults){
            System.out.println(s);
        }
    }
    public static void excelFileMock(Map testResults){
        for(Object key: testResults.keySet()){
            System.out.println(key + " " + testResults.get(key));
        }

    }
    public static void sqlMock(Map testResults){
        for(Object key: testResults.keySet()){
            System.out.println(key + " " + testResults.get(key));
        }
    }
}

