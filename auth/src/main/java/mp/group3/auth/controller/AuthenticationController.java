package mp.group3.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test() throws Exception {
        return ResponseEntity.ok("test");
    }

    @RequestMapping(value = "/api/user/{test}", method = RequestMethod.GET)
    public ResponseEntity<?> testAPI(@PathVariable String test){
        return ResponseEntity.ok(test);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public ResponseEntity<?> test(@RequestParam String test){
        return ResponseEntity.ok(test);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<?> admin(){
        return ResponseEntity.ok("admin");
    }

}