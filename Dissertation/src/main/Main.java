package main;

import u.blend.Blend;
import java.io.File;
import java.io.IOException;

import org.dom4j.Document;


public class Main{

	
	
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("bin/auto-standard/scenario.xml");
        Blend b = new Blend(file);
//      Document doc = b.readfile(file);
//      b.isEnable("true");
//      b.modify1(doc);
        float[] a = {(float) -25,0,-2};
        float[] c = {(float) 25,0,-2};
        b.math(3, 4, 10, a, c); // car width,length road width
        //b.clear();
		b.write();
	}
}
