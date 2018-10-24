package com.imocc.usemybatis.service.impl;

import com.imocc.usemybatis.dao.AreaDao;
import com.imocc.usemybatis.entity.Area;
import com.imocc.usemybatis.service.IAreaService;
import com.imocc.usemybatis.util.enums.ResultEnum;
import com.imocc.usemybatis.util.exception.dao.AreaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        int i;
        //判断地区名称是否为空
        if (area.getAreaName() == null) {
            throw new AreaException(ResultEnum.AREA_INSERT_AREANAME_EMPTY);
        }
        //判断权重是否为空。
        if (area.getPriority() == null) {
            throw new AreaException(ResultEnum.AREA_INSERT_PRIORITY_EMPTY);
        }
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        try {
            i = areaDao.insertArea(area);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        if (i == 1) {
            return true;
        } else {
            throw new AreaException(ResultEnum.AREA_INSERT_AREAID_INVALID);
        }

    }

    @Transactional
    @Override
    public boolean updateArea(Area area) {
        int i;
        if (area != null && area.getAreaName() != null) {
            area.setLastEditTime(new Date());
            try {
                i = areaDao.updateArea(area);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            if (i == 0) {
                throw new AreaException(ResultEnum.AREA_UPDATE_ERROR);
            } else {
                return true;
            }
        } else {
            throw new AreaException(ResultEnum.AREA_UPDATE_AREANAME_EMPTY);
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(Integer areaId) {
        int i;
        if (areaId > 0) {
            try {
                i = areaDao.deleteArea(areaId);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            if (i == 0) {
                throw new AreaException(ResultEnum.AREA_DELETE);
            } else {
                return true;
            }
        } else {
            throw new AreaException(ResultEnum.AREA_DELETE_AREAID_EMPTY);
        }
    }
}
