package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.response.LotteryResponse;
import com.kbtg.bootcamp.posttest.service.LotteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class LotteryController {
    private final LotteryService lotteryService;

    @GetMapping("/lotteries")
    public ResponseEntity<LotteryResponse.findAll> findAll(){
        return lotteryService.findAll();
    }
}
