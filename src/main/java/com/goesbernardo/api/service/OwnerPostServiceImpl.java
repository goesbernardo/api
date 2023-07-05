package com.goesbernardo.api.service;

import com.goesbernardo.api.client.CarPostStoreClient;
import com.goesbernardo.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private CarPostStoreClient client;

    @Override
    public void createOwner(OwnerPostDTO ownerPostDTO) {

        client.ownerPostsClient(ownerPostDTO);
    }
}
