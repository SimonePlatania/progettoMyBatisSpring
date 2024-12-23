package com.simone.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import com.simone.model.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);
    
    @Select("SELECT * FROM users WHERE id = #{id}")
    User find(Long id);
    
    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);
    
    @Select("SELECT * FROM users")
    List<User> findAll();
    
    @Select("SELECT * FROM users WHERE name LIKE #{name}")
    List<User> search(String name);
}