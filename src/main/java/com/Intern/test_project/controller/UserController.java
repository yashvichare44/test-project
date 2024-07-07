package com.Intern.test_project.controller;

import com.Intern.test_project.domain.dto.UserDto;
import com.Intern.test_project.service.inter.UserService;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DaoAuthenticationProvider authenticationProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.jwt.secret-key}")
    private String jwtSecretKey;
    @Value("${security.jwt.issuer}")
    private String jwtIssuer;

    @PostMapping("/add")
    public UserDto addUser(@RequestBody UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userService.saveUser(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @PatchMapping("/{id}")
    public UserDto partialUpdateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.partialUpdateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        try {
            // Perform authentication

            Authentication authentication = authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            String.valueOf(userDto.getId()), userDto.getPassword()));

            // If authentication is successful, generate JWT token
            if (authentication.isAuthenticated()) {
                String jwtToken = createJwtToken(userDto.getId());
                return ResponseEntity.ok(jwtToken);
            } else {
                throw new RuntimeException("Authentication failed");
            }
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password", e);
        }
    }

            private String createJwtToken ( int user){
                Instant now = Instant.now();

                JwtClaimsSet claims = JwtClaimsSet.builder()
                        .issuedAt(now)
                        .expiresAt(now.plusSeconds(120))  // 24 hours
                        .subject(String.valueOf(user))
                        .issuer(jwtIssuer)
                        .build();

                var encoder = new NimbusJwtEncoder(
                        new ImmutableSecret<>(jwtSecretKey.getBytes())
                );
                var params = JwtEncoderParameters.from(
                        JwsHeader.with(MacAlgorithm.HS256).build(), claims);

                return encoder.encode(params).getTokenValue();
            }
        }
