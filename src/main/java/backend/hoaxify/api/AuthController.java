package backend.hoaxify.api;

import backend.hoaxify.core.utils.results.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/auth")
    ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization", required = false) String authorization){
        if(authorization==null){
            ErrorResult errorResult= new ErrorResult("Unauthorized request blin");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResult);
        }
        return ResponseEntity.ok().build();
    }
}
