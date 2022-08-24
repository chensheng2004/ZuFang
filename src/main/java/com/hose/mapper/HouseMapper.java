package com.hose.mapper;

import com.hose.pojo.House;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer houseId);

    int insert(House record);

    House selectByPrimaryKey(Integer houseId);

    List<House> selectAll(Integer userId);

    int updateByPrimaryKey(House record);

    int selectAllTheHouses();

    int selectMyHousesnumber(Integer userId);

    List<House> selectMyHouses(Integer userId);

    List<House> selectAllPriceAscending(Integer userId);

    List<House> selectAllPriceDescending(Integer userId);

    List<House> searchResult(String keywords);

}