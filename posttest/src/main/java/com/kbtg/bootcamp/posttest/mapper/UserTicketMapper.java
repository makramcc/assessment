package com.kbtg.bootcamp.posttest.mapper;

import com.kbtg.bootcamp.posttest.entity.UserTicket;
import com.kbtg.bootcamp.posttest.request.UserTicketRequest;
import com.kbtg.bootcamp.posttest.response.UserTicketResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserTicketMapper {
    UserTicketMapper INSTANCE = Mappers.getMapper(UserTicketMapper.class);

    UserTicket mapBuyRequestToUserTicket(UserTicketRequest.buy request);
    UserTicket mapSellRequestToUserTicket(UserTicketRequest.sell request);

    UserTicketResponse.sell mapUserTickerToSellResponse(UserTicket userTicket);
}
