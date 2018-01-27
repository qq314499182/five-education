package com.five.fiveeducation.web;

import com.five.fiveeducation.entity.Menu;
import com.five.fiveeducation.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuWeb {

    @Autowired
    private MenuService menuService;

    @PostMapping("menu-getList")
    public Menu findAll(){
        return menuService.findAll();
    }

}
