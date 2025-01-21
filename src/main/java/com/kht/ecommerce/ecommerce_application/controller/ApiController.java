package com.kht.ecommerce.ecommerce_application.controller;

import com.kht.ecommerce.ecommerce_application.dto.Cart;
import com.kht.ecommerce.ecommerce_application.dto.Product;
import com.kht.ecommerce.ecommerce_application.dto.User;
import com.kht.ecommerce.ecommerce_application.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ApiController {

        @Autowired
        private UserServiceImpl userService;
        @Autowired
        private ProductServiceImpl productService;
       @Autowired
       private CartServiceImpl cartService;


    // 사용자 목록 API
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // 상품 목록 API
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    // 특정 사용자의 장바구니 API
    // http://localhost:8080/api/carts?userId=1
   @GetMapping("/api/carts")
    public List<Cart> getCart(@RequestParam("userId") int userId) {
        return cartService.getCartByUserId(userId);
    }
    /*
     Param = 파라미터 = 매개변수
    * @RequestParam 부분적으로 저장할 때 사용
    * 
    * @RequestBody 전체적으로 저장할 때 사용
    * */
        @PostMapping("/api/join")
        public void join(@RequestBody User user) {
            log.info("join user: {}", user);
            userService.insertUser(user);
        }
        @PostMapping("/api/product/insert")
        public void addProduct(@RequestBody Product product) {
            log.info("add product: {}", product);
            productService.addProduct();
        }

        @GetMapping("/api/existEmail")
    public boolean existEmail(@RequestParam("email") String email) {
            
            return userService.existByEmail(email); // 결과를 html 에 true false 로 전달
        }

        @GetMapping("/api/user/userId")
        public List<User> getUserById(@RequestParam("userId") int userId) {
            return userService.getDetailUser(userId);
        }
    /*
    @RequestParam = ?

    @PathVariable = /

    */
}
