package com.example.pos.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class adminRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;
}
