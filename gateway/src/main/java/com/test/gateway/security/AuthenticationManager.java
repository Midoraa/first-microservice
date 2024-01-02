package com.test.gateway.security;

import com.nimbusds.jwt.SignedJWT;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    @Autowired
    private JwtProvider tokenProvider;

    @Override
    @SuppressWarnings("unchecked")
    public Mono authenticate(Authentication authentication) {

        String authToken = authentication.getCredentials().toString();
        SignedJWT jwt = null;
        try {
            jwt = SignedJWT.parse(authToken);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject payload = jwt.getPayload().toJSONObject();
        System.out.println(payload);
        String username = tokenProvider.getUserNameFromJwtToken(payload);

        if (username != null) {
            List<String> roles = tokenProvider.getListRoles(payload);

            List authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, username, authorities);
            SecurityContextHolder.getContext().setAuthentication(auth);

            return Mono.just(auth);

        } else {
            return Mono.empty();
        }
    }
}