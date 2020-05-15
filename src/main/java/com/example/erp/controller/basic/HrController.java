package com.example.erp.controller.basic;

import com.example.erp.entity.Hr;
import com.example.erp.entity.RespMes;
import com.example.erp.entity.Role;
import com.example.erp.service.HrService;
import com.example.erp.service.RoleService;
import com.example.erp.util.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * @author qzp
 * @date 2020/5/9
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    private HrService hrService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        List<Hr> allHrs = hrService.getAllHrs(keywords);
        return allHrs;
    }

    @PutMapping("/")
    public RespMes updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespMes.ok("更新成功!");
        }
        return RespMes.error("更新失败!");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespMes updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespMes.ok("更新成功!");
        }
        return RespMes.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespMes deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespMes.ok("删除成功!");
        }
        return RespMes.error("删除失败!");
    }

    @GetMapping("/face_url")
    public RespMes getFaceUrl(){
        return hrService.getFaceUrl();
    }

    @PostMapping("/img_upload")
    public RespMes upload(@RequestParam("imgFile")MultipartFile imgFile){
        String filepath = "";
        try {
            String filename = imgFile.getOriginalFilename();
            //使用UUId自定义文件名
            String saveFileName= UUID.randomUUID().toString().replace("-","")+"_"+filename;
            /*上传到七牛云*/
            QiNiuUtils.upload2QiNiu(imgFile.getBytes(),saveFileName);
            //文件上传后的路径
            filepath=QiNiuUtils.qiniu_img_url_pre+saveFileName;
            hrService.updateUserFaceUrl(filepath);
            //todo 用户数据
        }catch (IOException | SQLException e){
            e.printStackTrace();
            return RespMes.error("上传失败");
        }
        return RespMes.ok("上传完成！",filepath);
    }

}
