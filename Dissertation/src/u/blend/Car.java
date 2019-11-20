package u.blend;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import u.blend.Blend;

public class Car {
	
	private Document doc;
	
	public Car(File file) {
		Blend b = new Blend(file);
	    doc = b.readfile(file);
	}
	
	
	
}