package backend.hoaxify.business.abstracts;

import backend.hoaxify.core.utils.results.Result;
import backend.hoaxify.entities.concretes.UserEntity;

public interface UserService {
    Result save(UserEntity userEntity);
}
