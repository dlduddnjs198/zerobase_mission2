package com.zerobase.mission2.service;

import com.zerobase.mission2.domain.User;
import com.zerobase.mission2.dto.StoreDto;
import com.zerobase.mission2.dto.form.UserSignUpForm;
import com.zerobase.mission2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public String userSignUp(UserSignUpForm form) {

        if (userRepository.findById(form.getId()).isPresent()) {
            // exception
//            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
            throw new RuntimeException("이미 있는 아이디입니다.");
        } else if (userRepository.findById(form.getId()).isPresent()) {
            throw new RuntimeException("이미 있는 닉네임입니다.");
        } else {
            User user = User.builder()
                    .email(form.getEmail())
                    .id(form.getId())
                    .password(form.getPassword())
                    .username(form.getUsername())
                    .build();
            userRepository.save(user);
            log.info(user.toString());
            return "유저 회원가입에 성공했습니다";
        }
    }

    // 앱에서 가게정보를 보여주기
    public List<StoreDto> showStoreList() {
        return null;
    }

    // 세부 가게정보 보여주기
    public StoreDto showStoreDetail() {
        return null;
    }

    // 가게정보 검색하기
    public StoreDto searchStore(String name) {
        return null;
    }


//    public void customerVerify(String email, String code){
//        signUpCustomerService.verifyEmail(email, code);
//    }
//
//    public String customerSignUp(SignUpForm form){
//        if(signUpCustomerService.isEmailExist(form.getEmail())){
//            // exception
//            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
//        }else{
//            Customer c = signUpCustomerService.signUp(form);
//
//            String code = getRandomCode();
//            SendMailForm sendMailForm = SendMailForm.builder()
//                    .from("tester@dannymytester.com")
//                    .to(form.getEmail())
//                    .subject("Verification Email!")
//                    .text(getVerificationEmailBody(form.getEmail(), form.getName(), "customer", code))
//                    .build();
//            mailgunClient.sendEmail(sendMailForm);
//            signUpCustomerService.changeCustomerValidateEmail(c.getId(), code);
//            return "회원 가입에 성공하였습니다.";
//        }
//    }

}
