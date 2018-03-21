import java.util.ArrayList;
import java.util.List;

class Helpers {

    static int getPrice(String price){
        //coverts price found on page to int value
        String p = price.substring(0, (price.length()-4)).replaceAll("\\s", "");
        return Integer.parseInt(p);
    }

    static List<String> generateTestUrls(String baseUrl, int pageCount){
        //generates list of urs to be run in tests
        List<String> urls = new ArrayList<>();
        for (int i = 1; i <=pageCount; i++){
            urls.add(String.format(baseUrl, i));
        }
        return urls;
    }

}
