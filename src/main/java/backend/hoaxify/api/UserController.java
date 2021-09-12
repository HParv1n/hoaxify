package backend.hoaxify.api;

import backend.hoaxify.business.abstracts.UserService;
import backend.hoaxify.core.utils.results.ErrorDataResult;
import backend.hoaxify.core.utils.results.Result;
import backend.hoaxify.entities.concretes.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usercontroller/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public Result createUser(@Valid @RequestBody UserEntity userEntity){
        return this.userService.save(userEntity);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>("Validation Errors", validationErrors);
        return errors;
    }
}
