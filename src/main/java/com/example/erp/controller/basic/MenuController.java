package com.example.erp.controller.basic;

import com.example.erp.entity.Menu;
import com.example.erp.service.HrService;
import com.example.erp.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qzp
 * @date 2020/2/15
 */
@Slf4j
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/system/menus")
    public List<Menu> getMenusByUserId(){
        log.info("==========开始加载菜单栏=======");
        return menuService.getMenuByUserId();
    }

}
