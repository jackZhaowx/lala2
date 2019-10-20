package com.grp.mybatis.entity;

import java.util.List;

/**
 * Created by Administrator on 2019/10/20 0020.
 */
public class SysUserRole {
    private List<String> role_ids;
    private String username;
    private String password;

    public List<String> getRole_ids() {
        return role_ids;
    }

    public void setRole_ids(List<String> role_ids) {
        this.role_ids = role_ids;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"role_ids\":")
                .append(role_ids);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
