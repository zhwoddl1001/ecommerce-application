package com.kht.ecommerce.ecommerce_application.mapper;

import com.kht.ecommerce.ecommerce_application.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
   // 사용자 조회
   List<User> getAllUsers();

   // 사용자 저장
   void insertUser(User user);

   // 이메일 존재 유무 확인
   int existByEmail(String email);

   List<User> getDetailUser();
}
