package com.minhdua.apps.service;

import static com.minhdua.apps.constant.MessageConstants.AUTHENTICATION_SUCCESSFUL;
import static com.minhdua.apps.constant.MessageConstants.REGISTRATION_SUCCESSFUL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhdua.apps.document.User;
import com.minhdua.apps.dto.UserDto;
import com.minhdua.apps.dto.UserInfoPublic;
import com.minhdua.apps.exception.AccountOrPasswordWrongException;
import com.minhdua.apps.exception.AlreadyExistsException;
import com.minhdua.apps.exception.NotMatchException;
import com.minhdua.apps.payload.request.LoginRequest;
import com.minhdua.apps.payload.request.SignupRequest;
import com.minhdua.apps.payload.response.JwtResponse;
import com.minhdua.apps.payload.response.SignupResponse;
import com.minhdua.apps.repository.UserReactiveRepository;
import com.minhdua.apps.util.JwtUtils;
import com.minhdua.apps.util.UuidUtils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class AuthService {
    @Autowired
    UserReactiveRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JwtUtils jwtUtil;

    public Mono<Boolean> isMatchPassword(String password, String passwordRetyping) {
        return Mono.just(password.equals(passwordRetyping));
    }

    public Mono<SignupResponse> signup(SignupRequest request) {
        var username = request.getUsername().trim().toLowerCase();
        var password = request.getPassword();
        var passwordRetyping = request.getPasswordRetyping();
        var user = User.builder().username(username).password(encoder.encode(password))
                .passwordRetyping(encoder.encode(passwordRetyping)).build();

        return isMatchPassword(password, passwordRetyping).flatMap(valid -> {
            if (Boolean.TRUE.equals(valid)) {
                return userRepository.findByUsername(username).defaultIfEmpty(user).flatMap(userFounded -> {
                    if (userFounded.getId() == null) {
                        userFounded.setId(UuidUtils.uuid());
                        return userRepository.save(userFounded).flatMap(savedUser -> {
                            var userDto = modelMapper.map(savedUser, UserDto.class);
                            var signupResponse = SignupResponse.builder().data(userDto).build();
                            signupResponse.setMessage(REGISTRATION_SUCCESSFUL);
                            return Mono.just(signupResponse);
                        });
                    }
                    return Mono.error(AlreadyExistsException.getInstance().withParam(User.class));
                });
            }
            return Mono.error(NotMatchException.getInstance().withParam("Password"));
        });
    }

    public Mono<JwtResponse> getToken(LoginRequest loginRequest) {
        var username = loginRequest.getUsername();
        var password = loginRequest.getPassword();
        return userRepository.findByUsername(username).defaultIfEmpty(new User()).flatMap(user -> {
            if (user.getId() != null && encoder.matches(password, user.getPassword())) {
                var token = jwtUtil.generateToken(user);
                var data = modelMapper.map(user, UserInfoPublic.class);
                var response = JwtResponse.builder().data(data).token(token).build();
                response.setMessage(AUTHENTICATION_SUCCESSFUL);
                return Mono.just(response);
            }
            return Mono.error(AccountOrPasswordWrongException.getInstance().withDefault());
        });
    }

    public Mono<String> hello() {
        return Mono.just("hello");
    }
}