package com.zerobase.mission2.service;

import com.zerobase.mission2.domain.Partner;
import com.zerobase.mission2.domain.Store;
import com.zerobase.mission2.dto.form.PartnerSignUpForm;
import com.zerobase.mission2.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartnerService {

    private final PartnerRepository partnerRepository;

    public String partnerSignUp(PartnerSignUpForm form) {

        if(partnerRepository.findById(form.getPartner().getId()).isPresent()){
            // exception
//            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
            throw new RuntimeException("이미 있는 아이디입니다.");
        }else if(partnerRepository.findById(form.getPartner().getId()).isPresent()){
            throw new RuntimeException("이미 있는 닉네임입니다.");
        }else{
            Partner partner = Partner.builder()
                    .email(form.getPartner().getEmail())
                    .id(form.getPartner().getId())
                    .password(form.getPassword())
                    .username(form.getPartner().getUsername())
                    .build();
            partnerRepository.save(partner);
            log.info(partner.toString());

            Store store = Store.builder()
                    .name(form.getStoreName())
                    .location(form.getLocation())
                    .description(form.getDescription())
                    .partner(partner)
                    .build();
            log.info(store.toString());

            return "파트너 회원가입에 성공했습니다";
        }
    }

//    public void sellerVerify(String email, String code){
//        sellerService.verifyEmail(email, code);
//    }
//
//    public String sellerSignUp(SignUpForm form){
//        if(sellerService.isEmailExist(form.getEmail())){
//            // exception
//            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
//        }else{
//            Seller s = sellerService.signUp(form);
//
//            String code = getRandomCode();
//            SendMailForm sendMailForm = SendMailForm.builder()
//                    .from("tester@dannymytester.com")
//                    .to(form.getEmail())
//                    .subject("Verification Email!")
//                    .text(getVerificationEmailBody(form.getEmail(), form.getName(), "seller", code))
//                    .build();
//            mailgunClient.sendEmail(sendMailForm);
//            sellerService.changeSellerValidateEmail(s.getId(), code);
//            return "회원 가입에 성공하였습니다.";
//        }
//    }

}
