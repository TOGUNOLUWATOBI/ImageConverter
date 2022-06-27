package com.ecentral.image.model;

import akka.japi.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMapper {
    public static java.awt.Image imageToFileImage(Image image) throws IOException {
        File file = image.getFile();
        BufferedImage imageFile = ImageIO.read(file);
        return imageFile;
    }

    public static Pair<Image,String> fileImageToImage(Pair<BufferedImage,String> imageFile) {
        Image image = new Image();
        String filename =imageFile.second().substring(imageFile.second().lastIndexOf("\\") + 1);
        try {
            File file = new File("../ConvertedImages/image" + filename);
            ImageIO.write(imageFile.first(), "png", file);


            image.setFile(file);
            image.setFilename(filename);
            image.setFilePath(imageFile.second());
        }
        catch (IOException ex)
        {

        }
        return new Pair(image,imageFile.second());
    }

}
