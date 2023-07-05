package com.goesbernardo.api.service;

import com.goesbernardo.api.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwner(OwnerPostDTO ownerPostDTO);
}
