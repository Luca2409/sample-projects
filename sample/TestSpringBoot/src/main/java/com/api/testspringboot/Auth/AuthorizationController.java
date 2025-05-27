package com.api.testspringboot.Auth;

import com.plaid.client.model.LinkTokenCreateResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

    private final AuthService authService;

    @Autowired
    public AuthorizationController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("")
    public List<UserDTO> authorize(@RequestParam String clientId, @RequestParam String secret) {
      return null;
    }

    @PostMapping("create-user")
    @ResponseBody
    public String createUser(@RequestBody @Valid User user) {

        return authService.createInitialUser(user);
    }

    @GetMapping("/link-token")
    @ResponseBody
    public LinkTokenCreateResponse getLinkToken(@RequestParam(required = false) String clientId, @RequestParam(required = false) String secret) throws IOException {

        return authService.retrieveLinkToken(clientId, secret);
    }

    @GetMapping("/auth-token")
    public ResponseEntity<String> getAuthToken(@RequestParam(required = false) String clientId, @RequestParam(required = false) String secret, @RequestParam(required = false) String publicToken) throws IOException {

        return authService.retrieveAuthToken(clientId, secret, publicToken);
    }



}
