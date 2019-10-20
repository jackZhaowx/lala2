package com.grp.mybatis;

import com.grp.mybatis.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2019/10/20 0020.
 */
public interface SysUserRoleMapper {
    /**
     * 根据usernaem查找user_role实体
     * @param username
     * @return
     */
    SysUserRole getEntityByUsername(@Param("username")String username);
}
