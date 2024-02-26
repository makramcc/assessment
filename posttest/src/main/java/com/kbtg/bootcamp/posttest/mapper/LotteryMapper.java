package com.kbtg.bootcamp.posttest.mapper;
import com.kbtg.bootcamp.posttest.entity.Lottery;
import com.kbtg.bootcamp.posttest.request.LotteryRequest;
import com.kbtg.bootcamp.posttest.response.LotteryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LotteryMapper {

    LotteryMapper INSTANCE = Mappers.getMapper(LotteryMapper.class);

    @Mapping(target = "ticketId", source = "ticket")
    Lottery mapCreateRequestToLottery(LotteryRequest.create request);

    @Mapping(target = "ticket", source = "ticketId")
    LotteryResponse.create mapLotteryToCreateResponse(Lottery lottery);
}
