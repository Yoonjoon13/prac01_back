package com.example.demo.reply;

import com.example.demo.reply.model.Reply;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByBoard_IdxOrderByIdxDesc(Long boardIdx);
}
