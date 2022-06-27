package controllers;

import com.ecentral.image.api.IImage;
import com.ecentral.image.model.Image;
import com.encentral.scaffold.commons.util.MyObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Content;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Transactional
@Api(value = "Image")
public class ImageController extends Controller {

    @Inject
    IImage iImage;

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;

    @ApiOperation(value = "Upload Image",consumes = "multipart")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Image.class, message = "Newly created Image")}
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "upload image", required = true, dataType = "java.io.File", paramType = "form")
    })

        public Result invertImage(String filePath) throws IOException {
        Form<Image> imageForm = formFactory.form(Image.class).bindFromRequest();
        File file = new File(filePath);
        if (imageForm.hasErrors()) {
            return badRequest(imageForm.errorsAsJson());
        }
        try {
            iImage.InvertColor(file);
        }
        catch (Exception ex)
        {
            return badRequest("file not an image");
        }
        return ok("Image color inverted");
    }


    @ApiOperation(value = "View Image",consumes = "multipart")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Image.class, message = "Inverted Image")}
    )
    @ApiImplicitParams({

    })

    public Result viewImage(String fileName) throws IOException {
        Form<Image> imageForm = formFactory.form(Image.class).bindFromRequest();
        Optional<Image> image;
        if (imageForm.hasErrors()) {
            return badRequest(imageForm.errorsAsJson());
        }
        try {
            image = iImage.getImage(fileName);
        }
        catch (IOException ex)
        {
            return badRequest("file not exists");
        }
        return image.
                map(employee -> ok(objectMapper.toJsonString(employee)))
                .orElse(notFound());

    }

}
