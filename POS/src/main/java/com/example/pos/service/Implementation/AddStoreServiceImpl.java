package com.example.pos.service.Implementation;

import com.example.pos.dto.request.addStoreRequest;
import com.example.pos.dto.response.addStoreResponse;
import com.example.pos.model.AddStore;
import com.example.pos.repository.AddStoreRepository;
import com.example.pos.service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddStoreServiceImpl implements AddStoreService {

    private final AddStoreRepository addstoreRepository;

    public addStoreResponse addStore(addStoreRequest addstoreRequest) {
        AddStore addStore = new AddStore();

        addStore.setStoreManager(addstoreRequest.getStoreManager());
        addStore.setStoreLocation(addstoreRequest.getStoreLocation());
        addStore.setStoreName(addstoreRequest.getStoreName());
        addStore.setStoreNumber(addstoreRequest.getStoreNumber());
        addStore.setStoreStatus(addstoreRequest.getStoreStatus());


        AddStore saveStore = addstoreRepository.save(addStore);
        return new addStoreResponse(saveStore.getStoreName());

    }

    public List<AddStore> getAllAddStore() {
        return addstoreRepository.findAll();
    }
    public AddStore getAddStoreById(Long id) {
        Optional<AddStore> addStore = addstoreRepository.findById(id);
        return addStore.orElse(null);
        //return addstoreRepository.findById(id);
    }
}
