package generics;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;

public class ScreenShot  {
	
	public static void takeScreenShot() 
	{
    try {
	Robot robot=new Robot();
	Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	BufferedImage img = robot.createScreenCapture(rect);
	SimpleDateFormat s=new SimpleDateFormat("yyyy-mm-dd-mm-ss");
	String time = s.format(new Date(0));
	ImageIO.write(img,"png", new File("./screenshots/"+time+".png"));
	
	
	}
    catch(Exception e)
    {
    	System.out.println("exception occured while taking screenshot");
    }
	}


}
