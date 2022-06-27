package com.ecentral.image.api;

import akka.japi.Pair;
import com.ecentral.image.model.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public interface IImage {
    Optional<Pair<Image,String>> InvertColor(File file) throws IOException;
    Optional<Image> getImage(String filename) throws IOException;
}
