public class Main {
    public static void main(String[] args) {
        //se creaza o instanta a clasei ReadImage ce primeste ca parametru primul parametru adaugat de catre utilizator
        ReadImage image = new ReadImage(args[0]);

        //se creaza o instanta a clasei ProcessingImage ce primeste ca parametru imaginea citita de instanta ReadImage
        ProcessingImage processingImage = new ProcessingImage(image);
        processingImage.OverwritePixel(); //apelez metoda de prelucrare a pixelilor

        //se creaza o instanta a clasei WriteImage ce primeste ca parametru imaginea citita de instanta ProcessingImage
        WriteImage writeImage = new WriteImage(processingImage);
        writeImage.WriteToFile(args[1]); //se incearca scrierea la adresa specificata de catre utilizator prin al doilea parametru.

    }
}
