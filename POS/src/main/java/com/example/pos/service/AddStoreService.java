package com.example.pos.service;

import com.example.pos.dto.request.addStoreRequest;
import com.example.pos.dto.response.addStoreResponse;
import com.example.pos.model.AddStore;

import java.util.List;

public interface AddStoreService {
    public addStoreResponse addStore(addStoreRequest addStoreRequest);
    List<AddStore>getAllAddStore();
    AddStore getAddStoreById(Long id);


}
