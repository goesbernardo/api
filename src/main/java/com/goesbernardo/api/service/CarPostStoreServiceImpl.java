package com.goesbernardo.api.service;

import com.goesbernardo.api.client.CarPostStoreClient;
import com.goesbernardo.api.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {


    @Autowired
    private CarPostStoreClient client;

    @Override
    public List<CarPostDTO> getCarForSales() {
        return client.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO cardPostDTO, String id) {

        client.changeCarForSaleClient(cardPostDTO, id);
    }

    @Override
    public void removeCarForSale(String id) {

        client.deleteCarForSaleClient(id);
    }
}
