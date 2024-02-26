package com.kbtg.bootcamp.posttest.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserTicketRequest {
    public record buy(
            String userId,
            String ticketId

    ) {}

    public record sell(
            String userId,
            String ticketId

    ) {}
}
