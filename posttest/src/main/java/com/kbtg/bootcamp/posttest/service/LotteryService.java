package com.kbtg.bootcamp.posttest.service;

import com.kbtg.bootcamp.posttest.entity.Lottery;
import com.kbtg.bootcamp.posttest.exception.AlreadyExistsException;
import com.kbtg.bootcamp.posttest.mapper.LotteryMapper;
import com.kbtg.bootcamp.posttest.repository.LotteryRepository;
import com.kbtg.bootcamp.posttest.response.LotteryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LotteryService {
    private final LotteryRepository lotteryRepository;

    public ResponseEntity<LotteryResponse.create> create(Lottery lottery){
        if (lotteryRepository.existsById(lottery.getTicketId())){
            throw new AlreadyExistsException("Lottery already exist");
        }
        lotteryRepository.save(lottery);
        return ResponseEntity.status(201).body(LotteryMapper.INSTANCE.mapLotteryToCreateResponse(lottery));
    }

    public ResponseEntity<LotteryResponse.findAll> findAll(){
        List<String> tickets = lotteryRepository.findAll()
                .stream()
                .map(Lottery::getTicketId)
                .collect(Collectors.toList());
        return ResponseEntity.status(200).body(new LotteryResponse.findAll(tickets));
    }
}
