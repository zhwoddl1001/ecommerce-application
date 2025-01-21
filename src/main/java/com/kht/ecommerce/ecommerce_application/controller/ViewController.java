package com.kht.ecommerce.ecommerce_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    // 사용자 목록 페이지
    @GetMapping("/")
    public String usersPage() {
        return "index";
    }

    // 상품 목록 페이지
    @GetMapping("/products")
    public String productsPage() {
        return "products";
    }

    // 장바구니 페이지
    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    //유저 장바구니 페이지
     /*
    HTTP Status 500 – Internal Server Error 서버에서 생각지못한 문제 발생
    Expected one result (or null) to be returned by selectOne(), but found: 3
    */
    @GetMapping("/api/cart{userId}")
    public String getCartByUserId(@PathVariable("userId") int id) {
        return "cart";
    }

    // 회원가입 페이지 볼 수 있게 회원가입.html 불러오기
    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/products/insert")
    public String  getProduct() {
        return "insertProduct";
    }


    @GetMapping("/user")
    public String getUserById() {
        return "user_detail";
    }

    @GetMapping("/product")
    public String getProductById( ) {
        return "product_detail";
    }
}
