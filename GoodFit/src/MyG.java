import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
 

 
class BgPanel extends JPanel{
    private String path;
	public void paintComponent(Graphics g){
        Image im = null;
        try {
            im = ImageIO.read(new File(getPath()));
        } catch (IOException e) {}
        g.drawImage(im, 0, 0, null); 
    }
    public void setPath(String path){
    	this.path=path;
    }
    
    public String getPath(){
    	return path;
    }
}