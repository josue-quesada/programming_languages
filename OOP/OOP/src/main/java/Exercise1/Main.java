package Exercise1;

import java.util.ArrayList;
import java.util.List;

class GraphicObject {
    private String name;

    public GraphicObject(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("Drawing " + this.name);
    }
    
    public String getName(){
        return this.name;
    }
}

class Group extends GraphicObject {
    private List<GraphicObject> objects;

    public Group(String name) {
        super(name);
        this.objects = new ArrayList<>();
    }

    public void addObject(GraphicObject object) {
        this.objects.add(object);
    }

    @Override
    public void draw() {
        System.out.println("Drawing group: " + this.getName());
        for (GraphicObject object : this.objects) {
            object.draw();
        }
    }
}

class Document {
    private List<Sheet> sheets;

    public Document() {
        this.sheets = new ArrayList<>();
    }

    public void addSheet(Sheet sheet) {
        this.sheets.add(sheet);
    }
    
    public List<Sheet> getSheets(){
        return this.sheets;
    }
}

class Sheet extends Document {
    private String name;
    private List<GraphicObject> objects;

    public Sheet(String name) {
        super();
        this.name = name;
        this.objects = new ArrayList<>();
    }

    public void addObject(GraphicObject object) {
        this.objects.add(object);
    }

    public List<GraphicObject> getObjects() {
        return objects;
    }

    public String getName() {
        return name;
    }
    
    
   
}

public class Main {
    public static void main(String[] args) {
        GraphicObject circle = new GraphicObject("Circle");
        GraphicObject rectangle = new GraphicObject("Rectangle");
        Group group1 = new Group("Group1");
        Group group2 = new Group("Group2");
        Sheet sheet = new Sheet("Sheet1");

        group1.addObject(circle);
        group1.addObject(rectangle);
        group2.addObject(group1);

        sheet.addObject(circle);
        sheet.addObject(group2);

        Document document = new Document();
        document.addSheet(sheet);

        
        for (Sheet s : document.getSheets()) {
            System.out.println("Drawing sheet: " + s.getName());
            for (GraphicObject object : s.getObjects()) {
                object.draw();
            }
        }
    }
}
