import java.awt.image.BufferedImage;

public class ProcessingImage extends SuperClass1{

    private BufferedImage imageToProcess;

    public ProcessingImage() {
        //constructor fara argumente, necesar pentru demonstrarea mostenirii.
    }

    //constructorul asteapta un parametru de tip BufferedImage
    public ProcessingImage(ReadImage readImage) {
        this.imageToProcess = readImage.getImage();
    }

    public void OverwritePixel() {
        //functia in care se aplica efectiv modificarile pe fiecare pixel in parte
        long startTime = System.currentTimeMillis(); //salvez in startTime momentul inceperii rularii clasei.
        int width = imageToProcess.getWidth(); //salvez latimea imaginii
        int height = imageToProcess.getHeight(); //salvez inaltimea imaginii
        int pixel; //variabila folosita pentru alterarea fiecarui pixel in parte
        int greyscale; //variabila in care se calculeaza noua valoare ce trebuie data fiecarei culori in parte
        int alpha, red, green, blue;

        for( int i = 0; i < width; i++) { //parcurgem matricea pe coloane
            for (int j = 0; j < height; j++) {
                pixel = imageToProcess.getRGB(i,j); //se obtine pixel-ul de la pozitia curenta
                alpha = (pixel >> 24) & 0xff; //shiftez bitii pentru a separa cele 3 valori ale culorilor primare: rosu, verde si albastru
                red = (pixel >> 16) & 0xff;
                green = (pixel >> 8) & 0xff;
                blue = pixel & 0xff;

                greyscale = (int)(0.2989*red) + (int)(0.5870*green) + (int)(0.1140*blue); //calculam valoarea cu care vor fi suprascrise valorile celor 3 culori primare ale
                //pixelui curent.

                pixel = (alpha << 24) | (greyscale << 16) | (greyscale << 8) | greyscale; //scriem noile valori inapoi in pixel-ul curent
                imageToProcess.setRGB(i,j,pixel); //aplicam modificarile efectuate pixel-ului.
            }
        }
        long endTime = System.currentTimeMillis(); //salvez momentul finalizarii rularii clasei
        long elapsedTime = endTime - startTime; //facem diferenta dintre cele doua si valoarea obtinuta reprezinta numarul de milisecunde necesare pentru parcurgerea intregului cod
        System.out.println("Processing took " + elapsedTime + " milliseconds"); //printez timpul calculat

        //cream o instanta a clasei de procesare pentru a demonstra mostenirea
        ProcessingImage object = new ProcessingImage();
        //demonstrarea mostenirii
        object.DisplayFrom1();
        object.DisplayFrom2();
        object.DisplayFrom3();

        varNumber(1234);
        varNumber(1,2,3,4);
        varNumber();

    }

    public BufferedImage getImageToProcess() {
        return imageToProcess;
    } //getter pentru variabila private de tip BufferedImage
}
