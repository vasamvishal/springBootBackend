package com.backend.bookStore.controller;

import com.backend.bookStore.entity.CartEntity;
import com.backend.bookStore.entity.CustomerInfoEntity;
import com.backend.bookStore.entity.Login;
import com.backend.bookStore.model.CustomerInfoRequest;
import com.backend.bookStore.service.CustomerInfoService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CustomerInfoController {
    @Autowired
    CustomerInfoService customerInfoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/post/customerInfoDetails")
    public ResponseEntity<CustomerInfoEntity> createCustomerInfo(@RequestBody CustomerInfoRequest customerInfo) {
        try {
            CustomerInfoEntity data = customerInfoService.createCustomerInfo(customerInfo);
            if (data != null) {
                System.out.println(data);
                return ResponseEntity.ok().body(data);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (ArithmeticException e) {
            return ResponseEntity.badRequest().build();
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000",exposedHeaders = "token",allowCredentials = "true")
    @PostMapping(path = "/login")
    public ResponseEntity<String> createCustomer(@RequestBody Login login, HttpServletResponse response) {
        try {
            System.out.println("login"+login);
            CustomerInfoEntity customerInfoEntity = customerInfoService.loginUser(login);
            System.out.println("Authorization" + customerInfoEntity);
            HttpHeaders responseHeaders = new HttpHeaders();
            String token=getJwtToken(customerInfoEntity.getPhoneNumber());
            System.out.println(token);
            responseHeaders.add("token", token);
            System.out.println(ResponseEntity.ok().headers(responseHeaders).build());
            return ResponseEntity.ok().headers(responseHeaders).body(customerInfoEntity.getUserName());
        } catch (ArithmeticException e) {
            System.out.println("VVV"+e);
            return ResponseEntity.badRequest().build();
        } catch (RuntimeException e) {
            System.out.println("VVV"+e);
            return ResponseEntity.status(500).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/getCartDetails/{phoneNumber}")
    public ResponseEntity<List<CartEntity>> getCartDetails(@PathVariable("phoneNumber") String phoneNumber){
        System.out.println(phoneNumber);
        List<CartEntity> cartEntity = customerInfoService.getCustomerInfo(phoneNumber);
        System.out.println("CARYr"+cartEntity);
        return ResponseEntity.ok().body(cartEntity);
    }

    private String getJwtToken(String phoneNumber) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities=
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(phoneNumber)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }
}
