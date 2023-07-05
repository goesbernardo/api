package com.goesbernardo.api.service;

import com.goesbernardo.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();

    void changeCarForSale(CarPostDTO cardPostDTO, String id);

    void removeCarForSale(String id);
}
