package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.mapper.LotteryMapper;
import com.kbtg.bootcamp.posttest.request.LotteryRequest;
import com.kbtg.bootcamp.posttest.response.LotteryResponse;
import com.kbtg.bootcamp.posttest.service.LotteryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController extends BaseController{
    private final LotteryService lotteryService;

    @PostMapping("/lotteries")
    public ResponseEntity<LotteryResponse.create> createLottery(@Valid  @RequestBody LotteryRequest.create request, BindingResult result){
        validateData(result);
        return lotteryService.create(LotteryMapper.INSTANCE.mapCreateRequestToLottery(request));
    }

}
