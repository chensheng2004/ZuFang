package com.hose.service;

import com.hose.pojo.House;

import java.util.List;

public interface HouseService {

    int HouseNumber();

    int insert(House record);

    int MyHouses(Integer userId);

    List<House> selectMyHouses(Integer userId);

    List<House> selectAll(Integer userId);

    House selectByPrimaryKey(Integer houseId);

    List<House> PriceAscending(Integer userId);

    List<House> PriceDescending(Integer userId);

    List<House> searchResult(String keywords);

    int deleteByPrimaryKey(Integer houseId);
}
