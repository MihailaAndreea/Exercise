package module.validator;

import module.Image;
import module.validator.Validator;
import module.validator.ValidatorException;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.io.IOException;

public class ImageValidator implements Validator<Image> {

    @Override
    public void validate(Image entity) throws ValidatorException {
        if( entity.getRow() > 250)
            throw new ValidatorException("Row too big.");
        if(entity.getColumn() < 1)
            throw new ValidatorException("Column number too small");
    }
}
