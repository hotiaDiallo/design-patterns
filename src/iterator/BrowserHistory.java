package iterator;

public class BrowserHistory {
    private String[] urls = new String[10];
    private int count;
    public void push(String url) {
        urls[count++] = url;
    }

    public Iterator createIterator() {
        return new UrlIterator(this);
    }

    public String pop() {
        return urls[--count];
    }

    public String[] getUrls() {
        return urls;
    }

    public int getCount() {
        return count;
    }

}
