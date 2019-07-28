package com.mir.lab.sec.oauth.jwt.ds.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/me")
public class UserController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Principal> get(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
    
    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> getUser() {    	
        return ResponseEntity.ok("TODO: Only User can access.");
    }
    
    @GetMapping("/guest")
    @PreAuthorize("hasRole('ROLE_GUEST')")
    public ResponseEntity<String> getGUEST() {    	
        return ResponseEntity.ok("TODO: only Guest Can access..");
    }
    
    @GetMapping("/any")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_GUEST')")
    public ResponseEntity<String> getAny() {    	
        return ResponseEntity.ok("TODO: User & Guest both can access.");
    }

}
