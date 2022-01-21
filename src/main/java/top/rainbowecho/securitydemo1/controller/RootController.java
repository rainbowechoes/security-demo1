package top.rainbowecho.securitydemo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowecho.web.servlet.common.BeanValue;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rainbow
 * @since 2021/11/30 11:06 上午
 */
@RestController
@RequestMapping("/")
public class RootController {
    @Resource
    private BeanValue beanValue;

    @GetMapping("/secret")
    public String secret() {
        return "this is secret api";
    }

    @GetMapping("/userInfo")
    public String userInfo(Authentication principal) {
        return principal.getName();
    }

    @PreAuthorize("hasRole('radmin')")
    @GetMapping("/admin")
    public String adminApi() {
        return "this is admin api";
    }

    @PreAuthorize("hasRole('ruser')")
    @GetMapping("/user")
    public String userApi() {
        return "this is user api";
    }

    @PreAuthorize("hasAnyPermission('ruser:add')")
    @GetMapping("/user-add")
    public String addPermission() {
        return "this is add permission api";
    }
}
