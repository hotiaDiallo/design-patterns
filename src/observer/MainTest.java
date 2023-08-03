package observer;

public class MainTest {
    public static void main(String[] args) {
        var dataSource = new DataSource();

        var sheet1 = new SpreadCheet(dataSource);
        var sheet2 = new SpreadCheet(dataSource);
        var chart = new Chart(dataSource);

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);
        dataSource.setValue(1);
    }
}
