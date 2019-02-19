import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

interface CalculateTime {
    public long time();
}

class ImplementCalculateTime implements CalculateTime {

    public long time() {
        return System.currentTimeMillis();
    }

}

public class ReadImage { //clasa citire imagine de la adresa specificata

    private BufferedImage image;
    CalculateTime IntInstance = new ImplementCalculateTime();

    public void ReadText() {
        System.out.println("Text afisat din clasa de ReadImage");
    }


    public ReadImage(String filename) { //constructor cu un parametru
        long start = IntInstance.time();
        try { //se incearca accesarea fisierului dat ca parametru
            File imageFile = new File(filename);
            this.image = ImageIO.read(imageFile); //imaginea este stocata in variabila image
        } catch (IOException e) { //daca nu se poate deschide fisierul
            System.out.println(e.getMessage()); //se afiseaza eroarea care a aparut
        }

        long end = IntInstance.time();
        System.out.println("Reading took " + (end - start) + " milliseconds"); //se afiseaza timpul calculat
    }

    public BufferedImage getImage() {
        return image;
    } //getter pentru variabila private image

}