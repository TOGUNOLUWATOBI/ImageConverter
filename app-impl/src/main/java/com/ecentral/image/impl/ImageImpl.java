package com.ecentral.image.impl;

import akka.japi.Pair;
import com.ecentral.image.api.IImage;
import com.ecentral.image.model.Image;
import com.ecentral.image.model.ImageMapper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class ImageImpl implements IImage {
    @Override
    public Optional<Pair<Image,String>> InvertColor(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        for(int y = 0; y < image.getHeight(); y++ )
        {
            for(int x = 0; x < image.getWidth(); x++)
            {

                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel,true);
                /*
                * Red Changes to Green,
                * Green Changes to Blue,
                * Blue Changes to Red
                * */
                int red = color.getGreen();
                int green = color.getBlue();
                int blue = color.getRed();

                color = new Color(red,green,blue);
                image.setRGB(x,y,color.getRGB());
            }
        }
        return ofNullable(new Pair (image,file.getAbsolutePath())).map(ImageMapper::fileImageToImage);
    }

    @Override
    public Optional<Image> getImage(String filename) throws IOException {
        File file = new File("../ConvertedImages/" + filename);
        if(file.exists())
        {
            Image image = new Image();
            image.setFilename(filename);
            image.setFilePath("ConvertedImages\\"+filename);
            image.setFile(file);
            return ofNullable(image);
        }
        else
        {
            return null;
        }
    }


}
