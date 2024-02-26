package com.kbtg.bootcamp.posttest.repository;

import com.kbtg.bootcamp.posttest.entity.Lottery;
import com.kbtg.bootcamp.posttest.entity.UserTicket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Integer> {
    @Query("SELECT l FROM UserTicket u JOIN Lottery l ON u.ticketId = l.ticketId WHERE u.userId = :user_id")
    public List<Lottery> findUserTicketsByUserId(@Param("user_id") String userId);

    @Transactional
    @Modifying
    public void deleteByUserIdAndTicketId(String userId, String ticketId);

    public boolean existsUserTicketByTicketId(String ticketId);

    public boolean existsUserTicketByUserIdAndTicketId(String userId, String ticketId);
}
