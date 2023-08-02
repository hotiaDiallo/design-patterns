package iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistoryOld {
    public List<String> getUrls() {
        return urls;
    }

    private List<String> urls = new ArrayList<>();

    public void push(String url){
        urls.add(url);
    }

    public String pop(){
        int lastIndex = urls.size() - 1;
        String lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);
        return lastUrl;
    }
}
