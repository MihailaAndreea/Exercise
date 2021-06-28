package module.validator;

import module.Image;

public class ImageValidator implements Validator<Image> {

    @Override
    public void validate(Image entity) throws ValidatorException {
        if( entity.getRow() > 250)
            throw new ValidatorException("Row number too big.");
        if(entity.getColumn() < 1)
            throw new ValidatorException("Column number too small");
    }
}
