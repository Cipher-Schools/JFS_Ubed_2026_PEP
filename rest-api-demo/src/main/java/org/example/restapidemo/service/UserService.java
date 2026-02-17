package org.example.restapidemo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService implements ServiceInter {

    @Override
    public String getServiceType() {
        return "User Service Implementation (Alternative)";
    }
}
