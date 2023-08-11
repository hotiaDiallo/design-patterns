package factory.korner;

import java.util.Map;

public class KornerViewEngine implements ViewEngine {

    @Override
    public String render(String viewName, Map<String, Object> context) {
        return "View rendered by Korner";
    }
}
