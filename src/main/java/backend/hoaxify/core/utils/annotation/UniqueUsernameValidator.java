package backend.hoaxify.core.utils.annotation;

import backend.hoaxify.dataAcces.abstracts.UserDao;
import backend.hoaxify.entities.concretes.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
      if(userDao.findByUsername(username) != null){
          return false;
      }
        return true;
    }
}
