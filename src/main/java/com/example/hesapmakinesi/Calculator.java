package com.example.hesapmakinesi;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/calculator")
public class Calculator {
    @GetMapping("/calculate")
    public ResponseEntity<Map<String, Object>>
        calculate(@RequestParam int num1, @RequestParam int num2, @RequestParam char operator) {
        int result = 0;
        Map<String, Object> response = new HashMap<>();
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0)
                    result = num1 / num2;
                break;
            default:
                response.put("error", "invalid error");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("num1", num1);
        response.put("num2", num2);
        response.put("operator", operator);
        response.put("result", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
