package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.mapper.UserTicketMapper;
import com.kbtg.bootcamp.posttest.request.UserTicketRequest;
import com.kbtg.bootcamp.posttest.response.UserTicketResponse;
import com.kbtg.bootcamp.posttest.service.LotteryService;
import com.kbtg.bootcamp.posttest.service.UserTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController extends BaseController{

    private final LotteryService lotteryService;
    private final UserTicketService userTicketService;

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public ResponseEntity<UserTicketResponse.buy> buyLottery(@PathVariable String userId, @PathVariable String ticketId){
        UserTicketRequest.buy userTicketRequest = new UserTicketRequest.buy(userId, ticketId);
        return userTicketService.buy(UserTicketMapper.INSTANCE.mapBuyRequestToUserTicket(userTicketRequest));
    }

    @GetMapping("/{userId}/lotteries")
    public ResponseEntity<UserTicketResponse.retrieve> retrieveLotteries(@PathVariable String userId){
        return userTicketService.retrieve(userId);
    }

    @DeleteMapping("/{userId}/lotteries/{ticketId}")
    public ResponseEntity<UserTicketResponse.sell> sellLottery(@PathVariable String userId, @PathVariable String ticketId){
        return userTicketService.sell(userId, ticketId);
    }
}
