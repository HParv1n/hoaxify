package backend.hoaxify.business.concretes;

import backend.hoaxify.business.abstracts.UserService;
import backend.hoaxify.core.utils.results.Result;
import backend.hoaxify.core.utils.results.SuccessResult;
import backend.hoaxify.dataAcces.abstracts.UserDao;
import backend.hoaxify.entities.concretes.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Result save(UserEntity userEntity) {
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));
        userDao.save(userEntity);
        return new SuccessResult("User created");
    }
}
