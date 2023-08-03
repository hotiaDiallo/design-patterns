package observer;

public class SpreadCheet implements Observer{
    private final DataSource dataSource;

    public SpreadCheet(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void update() {
        System.out.println("SpreadCheet got notified " + dataSource.getValue());
    }
}
