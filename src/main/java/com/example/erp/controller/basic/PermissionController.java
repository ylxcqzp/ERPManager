package com.example.erp.controller.basic;

import com.example.erp.entity.Menu;
import com.example.erp.entity.RespMes;
import com.example.erp.entity.Role;
import com.example.erp.service.MenuService;
import com.example.erp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qzp
 * @date 2020/5/9
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespMes updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespMes.ok("更新成功!");
        }
        return RespMes.error("更新失败!");
    }

    @PostMapping("/role")
    public RespMes addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespMes.ok("添加成功!");
        }
        return RespMes.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    public RespMes deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespMes.ok("删除成功!");
        }
        return RespMes.error("删除失败!");
    }
}
