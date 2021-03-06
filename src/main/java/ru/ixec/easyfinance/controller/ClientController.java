package ru.ixec.easyfinance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ixec.easyfinance.entity.ClientEntity;
import ru.ixec.easyfinance.service.ClientService;

@RequestMapping("/client")
@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @ResponseBody
    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientEntity signUp(@RequestBody ClientEntity clientEntity) {
        return clientService.signUp(clientEntity);
    }

    void signIn() {

    }

    void changePassword() {

    }

    void changeName() {

    }

    void changeEmail() {

    }
}
