package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bok extends SuperObject{
	
	public OBJ_Bok() {
		
		name = "Bok";
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/objects/복단.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}