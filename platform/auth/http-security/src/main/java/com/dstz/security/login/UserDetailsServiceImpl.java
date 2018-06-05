package com.dstz.security.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dstz.base.core.util.BeanUtils;
import com.dstz.org.api.model.IUser;
import com.dstz.org.api.service.UserService;
import com.dstz.org.core.manager.UserRoleManager;
import com.dstz.org.core.model.UserRole;
import com.dstz.security.constans.PlatformConsts;
import com.dstz.security.login.model.LoginUser;

/**
 * 实现UserDetailsService 接口获取UserDetails 接口实例对象。
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    UserService userService;
    @Resource
    UserRoleManager userMananger;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        IUser defaultUser = userService.getUserByAccount(username);

        LoginUser loginUser = new LoginUser(defaultUser);


        if (BeanUtils.isEmpty(loginUser)) {
            throw new UsernameNotFoundException("用户：" + username + "不存在");
        }

        //构建用户角色。
        List<UserRole> userRoleList = userMananger.getListByUserId(loginUser.getUserId());
        Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
        for (UserRole userRole : userRoleList) {
            GrantedAuthority role = new SimpleGrantedAuthority(userRole.getAlias());
            collection.add(role);
        }
        if (loginUser.isAdmin()) {
            collection.add(PlatformConsts.ROLE_GRANT_SUPER);
        }
        loginUser.setAuthorities(collection);

        return loginUser;
    }
}
