package com.wwy.uac.dao;

import com.wwy.uac.model.PermissionDto;
import com.wwy.uac.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wwy
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public UserDto getUserByUsername(String username){
        String sql="select * from t_user where username=?";
        List<UserDto> dtos = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(UserDto.class));
        if(dtos!=null&&dtos.size()==1){
            return dtos.get(0);
        }
        return null;
    }
    public List<String> findPermissionByUserId(String id){
        String sql="select `code` from t_permission where id in (\n" +
                "\tselect permission_id from t_role_permission where role_id in(\n" +
                "\t\tselect role_id from t_user_role where user_id=?))";
        List<PermissionDto> dtos = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(PermissionDto.class));
        if(dtos!=null){
            return dtos.stream().map(x->x.getCode()).collect(Collectors.toList());
        }
        return null;
    }
}
