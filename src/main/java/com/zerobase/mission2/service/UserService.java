package com.zerobase.mission2.service;

import com.zerobase.mission2.domain.Review;
import com.zerobase.mission2.domain.Store;
import com.zerobase.mission2.domain.User;
import com.zerobase.mission2.dto.ReservationDto;
import com.zerobase.mission2.dto.ReviewDto;
import com.zerobase.mission2.dto.StoreDetailDto;
import com.zerobase.mission2.dto.StoreDto;
import com.zerobase.mission2.dto.form.LoginForm;
import com.zerobase.mission2.dto.form.SignInForm;
import com.zerobase.mission2.dto.form.UserSignUpForm;
import com.zerobase.mission2.exception.CustomException;
import com.zerobase.mission2.repository.ReservationRepository;
import com.zerobase.mission2.repository.ReviewRepository;
import com.zerobase.mission2.repository.StoreRepository;
import com.zerobase.mission2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.zerobase.mission2.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReservationRepository reservationRepository;
    private final ReviewRepository reviewRepository;

    // 유저 회원가입
    public String userSignUp(UserSignUpForm form) {
        if (userRepository.findById(form.getId()).isPresent()) {
            throw new CustomException(ID_ALREADY_EXIST);
        }
        if (userRepository.findById(form.getId()).isPresent()) {
            throw new CustomException(USERNAME_ALREADY_EXIST);
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

    // 유저 로그인
    public LoginForm userSignIn(SignInForm form){
        User user = userRepository.findById(form.getId()).orElseThrow(() -> new CustomException(ID_UNMATCHED));
        if(!user.getPassword().equals(form.getPassword())){
            throw new CustomException(PASSWORD_UNMATCHED);
        }
        return LoginForm.builder()
                .id(user.getId())
                .loginTime(LocalDateTime.now())
                .build();
    }

    // 앱에서 가게정보를 보여주기
    public List<StoreDto> showStoreList() {
        return StoreDto.fromEntityList(storeRepository.findAll());
    }

    // 세부 가게정보 보여주기
    public StoreDetailDto showStoreDetail(Long storeId) {
        StoreDto store = StoreDto.fromEntity(storeRepository.findById(storeId)
                .orElseThrow(() -> new CustomException(STORE_NOT_FOUND)));
        List<ReservationDto> reservations = ReservationDto.fromEntityList(reservationRepository.findByStoreId(storeId));
        List<ReviewDto> reviews = ReviewDto.fromEntityList(reviewRepository.findByStoreId(storeId));
        return StoreDetailDto.builder()
                .store(store)
                .reservations(reservations)
                .reviews(reviews)
                .build();
    }

    // 가게정보 검색하기
    public StoreDetailDto searchStore(String name) {
        return showStoreDetail(storeRepository.findByName(name)
                .orElseThrow(() -> new CustomException(STORE_NOT_FOUND)).getId());
    }

    // 리뷰 작성하기
    public String setReview(ReviewDto review){
        User user = userRepository.findByUsername(review.getUserName()).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        Store store = storeRepository.findByName(review.getStoreName()).orElseThrow(() -> new CustomException(STORE_NOT_FOUND));
        reviewRepository.save(Review.builder()
                        .user(user)
                        .store(store)
                        .comment(review.getComment())
                        .rating(review.getRating())
                .build());
        return "리뷰를 작성하였습니다.";
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
