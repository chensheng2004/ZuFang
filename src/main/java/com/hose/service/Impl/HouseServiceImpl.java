package com.hose.service.Impl;

import com.hose.mapper.HouseMapper;
import com.hose.pojo.House;
import com.hose.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseMapper houseMapper;

    @Override
    public int HouseNumber() {
        return houseMapper.selectAllTheHouses();
    }

    @Override
    public int insert(House record) {
        return houseMapper.insert(record);
    }

    @Override
    public int MyHouses(Integer userId) {
        return houseMapper.selectMyHousesnumber(userId);
    }

    @Override
    public List<House> selectMyHouses(Integer userId) {
        return houseMapper.selectMyHouses(userId);
    }

    @Override
    public List<House> selectAll(Integer userId) {
        return houseMapper.selectAll(userId);
    }

    @Override
    public House selectByPrimaryKey(Integer houseId) {
        return houseMapper.selectByPrimaryKey(houseId);
    }

    @Override
    public List<House> PriceAscending(Integer userId) {
        return houseMapper.selectAllPriceAscending(userId);
    }

    @Override
    public List<House> PriceDescending(Integer userId) {
        return houseMapper.selectAllPriceDescending(userId);
    }

    @Override
    public List<House> searchResult(String keywords) {
        return houseMapper.searchResult(keywords);
    }

    @Override
    public int deleteByPrimaryKey(Integer houseId) {
        return houseMapper.deleteByPrimaryKey(houseId);
    }
}
