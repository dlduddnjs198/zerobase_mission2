package com.zerobase.mission2.controller;

import com.zerobase.mission2.dto.StoreDetailDto;
import com.zerobase.mission2.dto.StoreDto;
import com.zerobase.mission2.dto.form.LoginForm;
import com.zerobase.mission2.dto.form.SignInForm;
import com.zerobase.mission2.dto.form.UserSignUpForm;
import com.zerobase.mission2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<LoginForm> signInUser(@RequestBody SignInForm form){
        return ResponseEntity.ok(userService.userSignIn(form));
    }

    // 상점 정보 리스트
    @GetMapping("/store/list")
    public ResponseEntity<List<StoreDto>> getStoreList(){
        return ResponseEntity.ok(userService.showStoreList());
    }

    // 상점 세부정보 보여주기(하나의 상점 클릭시 진행)
    @GetMapping("/store/detail")
    public ResponseEntity<StoreDetailDto> getStoreDetail(@RequestBody Long storeId){
        return ResponseEntity.ok(userService.showStoreDetail(storeId));
    }

    // 상점 검색시 보여주기
    @GetMapping("/store/search")
    public ResponseEntity<StoreDetailDto> getStoreSearch(@RequestBody String name){
        return ResponseEntity.ok(userService.searchStore(name));
    }

}
