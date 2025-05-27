package com.api.testspringboot.Auth;

public record UserDTO(
        String name,
        String lastname,
        String email,
        String publicToken
) {

}
