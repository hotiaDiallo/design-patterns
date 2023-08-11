package factory.korner;

import java.util.Map;

public abstract class KornerControlller {
    public void render(String viewName, Map<String, Object> context){
        var engine = createViewEngine();
        var html = engine.render(viewName, context);
        System.out.println(html);
    }

    protected abstract ViewEngine createViewEngine();
}
