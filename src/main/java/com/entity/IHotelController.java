package com.entity;

import com.model.simpreserv.Hotel;

public interface IHotelController {

    Hotel loadHotelInfo();

    void saveHotelInfo(Hotel newRecord);

}
