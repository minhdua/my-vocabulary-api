package com.minhdua.apps.config;

import static com.minhdua.apps.constant.CommonConstants.SYSTEM_ERROR_CODE;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.minhdua.apps.exception.ServerException;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    public static boolean allInstanceOf(Object obj, Class<?>... classes) {
        for (Class<?> cls : classes) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        final Map<String, Object> map = super.getErrorAttributes(request, options);
        var error = getError(request);
        var messageClass = error.getClass().getSimpleName();
        var message = error.getMessage();
        var messageCode = "System Error , Check logs!";
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (error instanceof ServerException) {
            ServerException ex = (ServerException) getError(request);
            messageCode = ex.getMessageCode();
            status = ex.getStatus();
        }
        if (allInstanceOf(error, SignatureException.class, ExpiredJwtException.class, UnsupportedJwtException.class,
                MalformedJwtException.class, UnsupportedEncodingException.class,IllegalArgumentException.class)) {
            status = HttpStatus.BAD_REQUEST;
            messageCode = SYSTEM_ERROR_CODE;
        }

        map.put("exceptionClass", messageClass);
        map.put("message", message);
        map.put("messageCode", messageCode);
        map.put("status", status.value());
        map.put("error", status.getReasonPhrase());

        return map;
    }
}
