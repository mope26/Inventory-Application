package com.example.pos.controller;

import com.example.pos.dto.request.addStoreRequest;
import com.example.pos.dto.response.addStoreResponse;
import com.example.pos.model.AddStore;
import com.example.pos.service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")

public class AddStoreController {

    private final AddStoreService addStoreService;

    @PostMapping("/add")
    public addStoreResponse addStore(@RequestBody @Validated addStoreRequest addStoreRequest) {
        addStoreService.addStore(addStoreRequest);
        return new addStoreResponse(addStoreRequest.getStoreName());
    }


    @GetMapping("/all")
    public List<AddStore> getAllStores() {
        return addStoreService.getAllAddStore();
    }

    @GetMapping(path =  "/{id}")
    public AddStore getStoreById(@PathVariable Long id) {
        return addStoreService.getAddStoreById(id);
    }
}

