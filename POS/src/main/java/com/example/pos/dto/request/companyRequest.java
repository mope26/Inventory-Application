package com.example.pos.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NonNull
public class companyRequest {
    private Long id;
    private String companyName;
    private String companyLocation;
    private String companyLogo;
    private String companyEmail;
    private String companyPhoneNumber;
}
