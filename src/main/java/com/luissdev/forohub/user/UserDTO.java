package com.luissdev.forohub.user;

public record UserDTO(
        String name,
        String username,
        String password,
        Boolean enable
) {
}
