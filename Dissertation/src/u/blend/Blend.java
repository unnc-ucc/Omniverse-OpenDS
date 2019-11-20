package u.blend;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class Blend {                  // this part is focus on autoPilot part 
	 Document doc = null;
	 private File file = null;
	 int num = 20;
	 
	 public Blend(File file) {
		 //this.file = file;
		 readfile(file);
	 }

    
	 public void setnum(int n) {
		 num = n;
	 }
	 
	 
	 
	 
    public void modify1(Document doc){
    	
    	//Element autoPilot = getauto(doc);
    	//System.out.println(autoPilot.getName());
        System.out.println("Fine!");
    }
    
    public void math(float car_width, float car_length, float road_width, float[] a, float[] b) {               
    	
    // add model
    	
    }
    
    public float[] model(float[] a, float[] b, float l,float x,float r) {
    	float pos[] = {x,a[1],0};
    	float del = (float)Math.sqrt(r-(x-(a[0]+b[0])/2)*(x-(a[0]+b[0])/2));
    	float z = a[2]+l/2+del;             
    	//System.out.println(x);
    	pos[2] = z;
    	
    	return pos;
    }
    
    public Boolean check(float r, float R, float w, float l, float d) {
    	
    	float R1 = (float) Math.sqrt((((d+w)/2+r))*(((d+w)/2)+r)+l*l);

    	float need_width = R1-r;
    	if(need_width <= d) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    public void clear() {
    	
    	float[] first_pos= {(float) -30.4,0,-50};
    	Element wayPoints = getauto(doc).element("wayPoints");
		List<Element> list = wayPoints.elements();
    	list.clear();
    	addwaypoint("WayPoint_0_1", first_pos,20);
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
	public void addwaypoint(String id, float[] pos,int sp) {               // need to check
    	
    	Element wayPoints = getauto(doc).element("wayPoints");
		List<Element> list = wayPoints.elements();
		
		//int num = list.size() -1;
		
    	Element wayPoint =  wayPoints.addElement("wayPoint");
		
		//Element wayPoint = null;
    	//list.add(num, wayPoint);
    	wayPoint.addAttribute("id", id);//

    	Element translation = wayPoint.addElement("translation");
    	Element speed =  wayPoint.addElement("speed");
    	speed.setText(String.valueOf(sp));
    	Element vector = translation.addElement("vector");
    	vector.addAttribute("jtype", "java_lang_Float");
    	vector.addAttribute("size", "3");
    	Element entry = vector.addElement("entry");
    	Element entry2 = vector.addElement("entry");
    	Element entry3 = vector.addElement("entry");
    	list = vector.elements();
    	list.get(0).setText(String.valueOf(pos[0]));
    	list.get(1).setText(String.valueOf(pos[1]));
    	list.get(2).setText(String.valueOf(pos[2]));
    }
    
    
    
    public Element getauto(Document doc) {
        Element root = doc.getRootElement();
    	Element driver=root.element("driver");
    	Element car=driver.element("car");
    	Element autoPilot=car.element("autoPilot");
    	return autoPilot;
    }
    
    

    public Element getcar(Document doc) {
        Element root = doc.getRootElement();
    	Element driver=root.element("driver");
    	Element car=driver.element("car");
    	return car;
    }
    

    
    public void isEnable(String b) {
    	Element autoPilot = getauto(doc);
    	Element enabled = autoPilot.element("enabled");
    	enabled.setText(b);
    	System.out.println(enabled.getStringValue());
    }
    
    public void setDistance(String min, String max) {
    	Element autoPilot = getauto(doc);
    	Element minDistance = autoPilot.element("minDistanceFromPath");
    	Element maxDistance = autoPilot.element("maxDistanceFromPath");
    	minDistance.setText(min);
    	maxDistance.setText(max);
    }
    
    
    public void setTension(String a) {
    	Element autoPilot = getauto(doc);
    	Element Tension = autoPilot.element("curveTension");
    	Tension.setText(a);
    } 
    
    
    public void IsCycle(String a) {
    	Element autoPilot = getauto(doc);
    	Element IsCycle = autoPilot.element("pathIsCycle");
    	IsCycle.setText(a);
    } 
    
    public void Element(String a) {
    	Element autoPilot = getauto(doc);
    	Element IsVisible = autoPilot.element("pathIsVisible");
    	IsVisible.setText(a);
    } 
    
    public void setStartpoint(String a) {
    	Element autoPilot = getauto(doc);
    	Element Point = autoPilot.element("startWayPoint");
    	Point.setText(a);
    }
    
    

    public void setfile(File file) {
    	this.file = file;
    	readfile(file);
    }
    
    public Document readfile(File file) {
   	 SAXReader reader = new SAXReader();
   	try {
   		 doc = reader.read(file);
   	}catch (Exception e) {
   		e.printStackTrace();
   	}
   	return doc;
   }
   
    
    public void write() throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("bin/auto-standard/scenario.xml"), format);
		writer.write(doc);
		writer.close();
    }


}
    