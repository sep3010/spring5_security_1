package edu.kosmo.ex.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

   public String encode(CharSequence rawPassword) {

      log.warn("before encode :" + rawPassword);

      return rawPassword.toString();
   }
   
   public boolean matches(CharSequence rawPassword, String encodedPassword) {

      log.warn("matches: " + rawPassword + ":" + encodedPassword);

      return rawPassword.toString().equals(encodedPassword);
   }

}
// 암호화
// 비밀번호 1234를 입력하면 010101 덩어리로 저장된다...
// 암호화는 이 010101덩어리를 1234 그대로 저장하는 것이 아니라
// 다른 걸로 변형해서 저장한다. 
// 어떤 특정한 규칙을 적용해서 변경해 저장하는 것을 encoding(암화호화)라고 한다.
// 불러와 확인할 때는 encoding한 비밀번호를 decoding해서 (다시 원래대로 돌려서) 확인하다.
// 현재 CustomNoOpPasswordEncoder는 암호화가 적용되지 않은 버전이다..
