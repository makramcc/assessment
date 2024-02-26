package com.kbtg.bootcamp.posttest.service;

import com.kbtg.bootcamp.posttest.entity.Lottery;
import com.kbtg.bootcamp.posttest.entity.UserTicket;
import com.kbtg.bootcamp.posttest.exception.AlreadyExistsException;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.repository.UserTicketRepository;
import com.kbtg.bootcamp.posttest.response.UserTicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTicketService {
    private final UserTicketRepository userTicketRepository;

    public ResponseEntity<UserTicketResponse.buy> buy(UserTicket userTicket){
        if (userTicketRepository.existsUserTicketByTicketId(userTicket.getTicketId())){
            throw new AlreadyExistsException("Already buy this ticket: "+userTicket.getTicketId());
        }
        userTicket = userTicketRepository.save(userTicket);
;       return ResponseEntity.status(201).body(new UserTicketResponse.buy(String.valueOf(userTicket.getId())));
    }

    public ResponseEntity<UserTicketResponse.retrieve> retrieve(String userId){
        List<Lottery> lotteryList = userTicketRepository.findUserTicketsByUserId(userId);
        List<String> ticketIdList = lotteryList
                .stream()
                .map(Lottery::getTicketId)
                .toList();
        int cost = lotteryList.stream().mapToInt(Lottery::getPrice).sum();
        int count = lotteryList.stream().mapToInt(Lottery::getAmount).sum();
        return ResponseEntity.status(200).body(new UserTicketResponse.retrieve(ticketIdList, count, cost));
    }

    public ResponseEntity<UserTicketResponse.sell> sell(String userId, String ticketId){
        if (! userTicketRepository.existsUserTicketByUserIdAndTicketId(userId, ticketId)){
            throw new NotFoundException("Ticket: "+ticketId+" not found");
        }
        userTicketRepository.deleteByUserIdAndTicketId(userId, ticketId);
        return ResponseEntity.status(200).body(new UserTicketResponse.sell(ticketId));
    }
}
