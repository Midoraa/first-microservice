package com.test.gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



@Component
public class JwtProvider implements Serializable {

    public List<String> getListRoles(JSONObject payload) {
        JSONArray groups = (JSONArray) payload.get("groups");
        return groups.stream() .map(group -> ((JSONObject) group).get("authority").toString()).collect(Collectors.toList());
    }


    public String getUserNameFromJwtToken(JSONObject payload) {
        return payload.getAsString("sub");
    }

    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

    public boolean isTokenExpired(JSONObject payload) {
        long exp = payload.getAsNumber("exp").longValue();

        return new Date(exp * 1000).before(new Date());
    }
}