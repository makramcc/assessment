package com.kbtg.bootcamp.posttest.response;

import java.util.List;

public class UserTicketResponse {
    public record buy(
            String id
    ) {
    }

    public record retrieve(
            List<String> tickets,
            Integer count,
            Integer cost
    ) {
    }

    public record sell(
            String ticket
    ) {
    }
}
