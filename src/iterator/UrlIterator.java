package iterator;
public class UrlIterator implements Iterator<String> {
    private final BrowserHistory history;
    private int index;

    public UrlIterator(BrowserHistory history) {
        this.history = history;
    }
    @Override
    public boolean hasNext() {
        return (index < history.getCount());
    }
    @Override
    public String next() {
        return history.getUrls()[index++];
    }
}
