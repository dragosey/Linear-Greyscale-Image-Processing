import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WriteImage {

    private BufferedImage imageToWrite;

    //constructorul asteapta un parametru de tip BufferedImage
    public WriteImage(ProcessingImage processingImage) {
        this.imageToWrite = processingImage.getImageToProcess();
    }

    public void WriteToFile(String filename) { //metoda de scriere a imaginii in fisier.
        long startTime = System.currentTimeMillis(); //salvez in startTime momentul inceperii rularii clasei.
        try {
            ImageIO.write(imageToWrite,"BMP",new File(filename)); //se incearca scrierea imaginii la locatia specificata
        } catch (IOException e) {
            System.out.println(e.getMessage()); //daca nu reuseste scrierea, se afiseaza eroarea specifica
        }
        long endTime = System.currentTimeMillis(); //salvez momentul finalizarii rularii clasei
        long elapsedTime = endTime - startTime; //facem diferenta dintre cele doua si valoarea obtinuta reprezinta numarul de milisecunde necesare pentru parcurgerea intregului cod
        System.out.println("Writing took " + elapsedTime + " milliseconds"); //printez timpul calculat
    }
}
