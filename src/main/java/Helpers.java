import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static int getPrice(String price){
        String p = price.substring(0, (price.length()-4)).replaceAll("\\s", "");
        return Integer.parseInt(p);
    }

    public static List<String> generateTestUrls(String baseUrl, int pageCount){
        List<String> urls = new ArrayList<String>();
        for (int i = 1; i <=pageCount; i++){
            urls.add(String.format(baseUrl, i));
        }
        return urls;
    }

}
