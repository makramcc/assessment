package com.kbtg.bootcamp.posttest.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class LotteryRequest {
    public record create(
            @NotBlank(message = "Ticket must not be blank")
            @Pattern(regexp = "[0-9]{6}", message = "Ticket must be exactly 6 digits")
            String ticket,
            @Positive(message = "Price must be greater than 0 or equal 0")
            int price,
            @Min(value = 1, message = "Amount must be greater than 1 or equal 1")
            int amount

    ) {}
}
