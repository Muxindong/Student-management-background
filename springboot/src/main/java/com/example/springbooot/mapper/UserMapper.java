package com.example.springbooot.mapper;

import com.example.springbooot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMapper extends JpaRepository<User,String>{
    //Attribute findAttriById(String entity_id);
    @Query(name = "findById",nativeQuery = true,value =
            "select  row_number() OVER (ORDER BY entity_id) as rownum, * from attribute_kv where entity_id = :entity_id")
    List<User> findByEntity_id(@Param("entity_id")String entity_id);

}
