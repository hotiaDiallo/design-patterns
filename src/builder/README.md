# The Builder pattern
The intent of this pattern is to separate the `construction` of an object from its `representation`.

Let's look at an example:
Once we create a presentation on Powerpoint or Keynote, we can export it in a different formats: PDF, Movie etc. 
Let's implement this concept in code. 

```
public class Slide {
    private String text;
    
    public Slide(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
```
Let's have a presentation class which is a composite because a presentation is a collections of slides.
```
public class Presentation {
    private List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide){
        slides.add(slide);
    }

    public void export(PresentationFormat format){
        if (format == PresentationFormat.PDF){
            var pdf = new PdfDocuemnt();
            for(Slide slide: slides)
                pdf.addPage(slide.getText());
        } else if (format == PresentationFormat.MOVIE) {
            var movie = new Movie();
            for(Slide slide: slides)
                movie.addFrame(slide.getText(), 3);
        }
    }
}
```
Now, there is a number of problem in this implementation:
- It violate the Open/close principle: if tomorrow we want to support a new `PresentationFormat`, we have to come back and modify this method. 
- The tight coupling between the `Presentation` class and other classes like `PdfDocument`. As we support more format, our coupling increases.
- Our `Presentation` class should have knowledge of other classes.
- Repetition in our exporting method

Let's solve this problem using the `Builder pattern`: Separate the `exporting logic` from the `presentation format`.

![Image]()

```
public class Presentation {
    private List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide){
        slides.add(slide);
    }
    public void export(PresentationBuilder builder){
        for (Slide slide: slides)
            builder.addSlide(slide);
    }
}
```

Now we have a single place where we have implemented the exporting logic. If we want to change this logic in the future,
this is the only place we will have to modify and if we want to support a new presentation format, we can do it without changing a single line of code here. 
This is the beauty of Object Oriented Design





