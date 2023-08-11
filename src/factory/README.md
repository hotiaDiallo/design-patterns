# The factory pattern
The Factory pattern is used when we want to differ the creation of an object to subclasses

## Problem
Let's say we want to build a web framework, so other developers can use it to build their web 
applications. 
The framework has an engine that can read a template and spin out html content. (see `Template.html`)

```
public class KornerViewEngine {
    public String render(String viewName, Map<String, Object> context){
        return "View rendered by Korner";
    }
}
```
Let's implement a controller which is going to respond the user actions. 

```
public class KornerControlller {
    public void render(String viewName, Map<String, Object> context){
        var engine = new KornerViewEngine();
        var html = engine.render(viewName, context);
        System.out.println(html);
    }
}
```
Now someone can use our product to build their applications. 
```
public class ProductController extends Controller{
    public void listProducts(){
        // Get products from a database
        Map<String, Object> context = new HashMap<>();
        // context.put(products)
        render("products.html", context);
    }
}
```
It looks like we are done; but there is a problem in our current implementation of our controller `KornerControlller`:
- it is tightly coupled to `KornerViewEngine`. What if we want allow others to use our framework to use their own view engine? Not possible with our current implementation. 

One solution could be to create a `ViewEngine` interface and to pass it as a parameter to our render method. 

```
public class KornerControlller {
    public void render(String viewName, Map<String, Object> context, ViewEngine engine){
        // we do not need line 8 now
        // var engine = new KornerViewEngine();
        var html = engine.render(viewName, context);
        System.out.println(html);
    }
}
```

This solve our problem but create another one; it make it harder for other to use our framework because every time they want to render a content, they have to pass a view engine as a parameter. 

We can solve this problem elegantly using the factory pattern. 

![Image](../../images/)

With this implementation, we have a default implementation of our view engine. But other users can override it and use their own. 
We could also abstract it and force others to do the implementation; either way, our controller act as a Factory. 
