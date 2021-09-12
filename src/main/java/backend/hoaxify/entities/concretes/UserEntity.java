package backend.hoaxify.entities.concretes;

import backend.hoaxify.core.utils.annotation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long userId;


    @NotNull
    @NotBlank
    @UniqueUsername(message = "Username must be unique")
    @Size(min = 4,max = 20)
    @Column(name = "username")
    private String username;

    @Column(name = "displayname")
    @NotNull
    @NotBlank
    @Size(min = 4,max = 20)
    private String displayname;

    @Column(name = "image")
    private String image;

    @Column(name = "password")
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$",message = "Password must be greater than 6 characters and use lowercase letters, uppercase letters and numbers")
    private String password;
}
