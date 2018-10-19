package com.imocc.usemybatis.controller;

import com.imocc.usemybatis.entity.Area;
import com.imocc.usemybatis.service.IAreaService;
import com.imocc.usemybatis.util.ResultUtil;
import com.imocc.usemybatis.util.objUtil.Result;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private IAreaService areaService;

    @GetMapping(value = "/getArea")
    public Result getAreas(){
        return ResultUtil.success(areaService.queryArea());
    }

    @GetMapping(value="/getAreabyAreaId/{id}")
    public Result getAreabyAreaId(@PathVariable(value = "id")Integer areaId){
        return ResultUtil.success(areaService.queryAreaById(areaId));
    }

    @PostMapping(value="/createArea")
    public Result createArea(Area area){
        areaService.insertArea(area);
        return ResultUtil.success();
    }

    @PutMapping(value="/updateArea")
    public Result updateArea(Area area){
        areaService.updateArea(area);
        return ResultUtil.success();
    }

    @DeleteMapping(value="/deleteArea/{areaId}")
    public Result deleteArea(@PathVariable(value="areaId")Integer id){
        areaService.deleteArea(id);
        return ResultUtil.success();
    }


}
