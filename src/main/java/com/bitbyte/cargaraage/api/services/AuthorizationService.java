package com.bitbyte.cargaraage.api.services;

import com.bitbyte.cargaraage.api.entities.User;
import com.bitbyte.cargaraage.api.models.DecodedToken;
import com.bitbyte.cargaraage.api.models.Status;
import com.bitbyte.cargaraage.api.repositories.UserRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.security.jwt.JwtHelper.decode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationService.class);

    public boolean isAuthorized(String token, String role){
        DecodedToken decodedToken = new DecodedToken(decode(token).toString(), decode(token).getClaims());
        validateTokenExpiration(decodedToken);
        validateIssuer(decodedToken);
        try {
            JsonObject jsonObject = new JsonParser().parse(decodedToken.getPayload()).getAsJsonObject();
            Long userId = jsonObject.get("userId").getAsLong();
            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent() && user.get().getRoles().stream().filter(r -> r.getRole().equals(role)).findAny().isPresent() && user.get().getStatus().equals(Status.ACTIVE) && decodedToken.isValidExpiration() && decodedToken.isValidIssuer()){
                return true;
            } else
                return false;
        } catch (Exception e){
            LOG.error(e.getMessage());
            return false;
        }
    }

    private void validateIssuer(DecodedToken decodedToken) {
        try {
            JsonObject jsonObject = new JsonParser().parse(decodedToken.getPayload()).getAsJsonObject();
            if(jsonObject.get("iss").getAsString().equals("")){
                decodedToken.setValidIssuer(true);
            } else
                decodedToken.setValidIssuer(false);
        } catch (Exception e){
            LOG.error(e.getMessage());
            decodedToken.setValidIssuer(false);
        }
    }

    private void validateTokenExpiration(DecodedToken decodedToken) {
        try {
            JsonObject jsonObject = new JsonParser().parse(decodedToken.getPayload()).getAsJsonObject();
            if(isExpirationValidated(jsonObject.get("exp").getAsLong())){
                decodedToken.setValidExpiration(true);
            } else {
                decodedToken.setValidExpiration(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isExpirationValidated(Long dateToCheckInMillis) {
        return System.currentTimeMillis() < (dateToCheckInMillis.longValue() * 1000);
    }
}
