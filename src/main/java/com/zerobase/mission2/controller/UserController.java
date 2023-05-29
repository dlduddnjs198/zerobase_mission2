package com.zerobase.mission2.controller;

import com.zerobase.mission2.dto.form.UserSignUpForm;
import com.zerobase.mission2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 유저 회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody UserSignUpForm form){
        return ResponseEntity.ok(userService.userSignUp(form));
    }

    // 유저 로그인
    @PostMapping("/signin")
    public ResponseEntity<String> signInUser(@RequestBody UserSignUpForm form){
        return ResponseEntity.ok(userService.userSignUp(form));
    }

    // 상점 정보 리스트
    @GetMapping("/store/list")
    public ResponseEntity<String> getStoreList(@RequestBody UserSignUpForm form){
        return ResponseEntity.ok(userService.userSignUp(form));
    }

    // 상점 세부정보 보여주기(하나의 상점 클릭시 진행)
    @GetMapping("/store/detail")
    public ResponseEntity<String> getStoreDetail(@RequestBody UserSignUpForm form){
        return ResponseEntity.ok(userService.userSignUp(form));
    }

    // 상점 검색시 보여주기
    @GetMapping("/store/search")
    public ResponseEntity<String> getStoreSearch(@RequestBody UserSignUpForm form){
        return ResponseEntity.ok(userService.userSignUp(form));
    }

}
