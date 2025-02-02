package com.tracker.Expense.Tracker.controller;


import com.tracker.Expense.Tracker.entities.RefreshToken;
import com.tracker.Expense.Tracker.model.UserInfoDto;
import com.tracker.Expense.Tracker.response.JwtResponseDto;
import com.tracker.Expense.Tracker.service.JwtService;
import com.tracker.Expense.Tracker.service.RefreshTokenService;
import com.tracker.Expense.Tracker.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
@RestController
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("auth/v1/signup")
    public ResponseEntity SignUp(@RequestBody UserInfoDto userInfoDto) {
        try{
            Boolean isSignUped= userDetailsService.signupUser(userInfoDto);
            if(Boolean.FALSE.equals(isSignUped)) {
                return new ResponseEntity<>("Already Exist", HttpStatus.BAD_REQUEST);

            }
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(userInfoDto.getUsername());
            String jwtToken = jwtService.GenerateToken(userInfoDto.getUsername());
            return new ResponseEntity<>(JwtResponseDto.builder().accessToken(jwtToken).
                    token(refreshToken.getToken()).build(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Exception in user Service", HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }
}
























