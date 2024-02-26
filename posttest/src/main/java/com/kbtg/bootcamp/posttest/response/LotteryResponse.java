package com.kbtg.bootcamp.posttest.response;

import java.util.List;

public class LotteryResponse {
    public record create(
            String ticket
    ) {}

    public record findAll(
            List<String> tickets
    ) {}
}
