package com.zerobase.mission2.controller;

import com.zerobase.mission2.dto.form.PartnerSignUpForm;
import com.zerobase.mission2.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/partner")
public class PartnerController {

    private final PartnerService partnerService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUpPartner(@RequestBody PartnerSignUpForm form) {
        return ResponseEntity.ok(partnerService.partnerSignUp(form));
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signInPartner(@RequestBody PartnerSignUpForm form) {
        return ResponseEntity.ok(partnerService.partnerSignUp(form));
    }
}
