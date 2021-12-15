package com.example.party.contoller;

import com.example.party.payload.request.UserRequest;
import com.example.party.security.services.AddressValitade;
import com.example.party.security.services.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class UserAddressController {

    private AddressValitade addressValitade;
    private Producer producer;

    @PostMapping
    public ResponseEntity<String> updateAddress(@RequestBody UserRequest request) throws JsonProcessingException {
      String result =  addressValitade.validateAddress(request.getCity(),request.getZip());
       // addressService.save(addressRequest);

        producer.sendMessage(request);

        if (Boolean.parseBoolean(result))
            return new ResponseEntity<>("Party created successfully ", HttpStatus.OK);
       else
            return new ResponseEntity<>("Party created successfully, Address is not standard", HttpStatus.OK);
    }
}
