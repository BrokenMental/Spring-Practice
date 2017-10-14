package org.test.service;

import org.test.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    void addReply(ReplyVO vo);

    List<ReplyVO> listReply(Integer bno);

    void modifyReply(ReplyVO vo);

    void removeReply(Integer rno);
}
