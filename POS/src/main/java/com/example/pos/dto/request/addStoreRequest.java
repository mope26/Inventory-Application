package com.example.pos.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class addStoreRequest {
    private String storeName;
    private String storeLocation;
    private String storeManager;
    private String storeStatus;
    private String storeNumber;
}
