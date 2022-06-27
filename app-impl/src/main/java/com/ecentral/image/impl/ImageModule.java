package com.ecentral.image.impl;

import com.ecentral.image.api.IImage;
import com.google.inject.AbstractModule;

public class ImageModule extends AbstractModule {

    @Override
    protected void configure()
    {
        bind(IImage.class).to(ImageImpl.class);
    }
}
