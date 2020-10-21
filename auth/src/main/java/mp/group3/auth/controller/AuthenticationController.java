package mp.group3.auth.controller;

import mp.group3.auth.dto.JwtRequest;
import mp.group3.auth.dto.JwtResponse;
import mp.group3.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private UserService userService;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test() throws Exception {
        return ResponseEntity.ok("test");
    }

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public ResponseEntity<?> testAPI(Principal principal) throws Exception {
        return ResponseEntity.ok(principal.getName());
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public ResponseEntity<?> createTestUser() throws Exception {
        return ResponseEntity.ok(userService.createTestUser());
    }

}