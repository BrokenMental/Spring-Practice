package org.test.service;

import org.test.domain.Criteria;
import org.test.domain.ReplyVO;
import org.test.persistence.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDAO dao;

    @Override
    public void addReply(ReplyVO vo){
        dao.create(vo);
    }

    @Override
    public List<ReplyVO> listReply(Integer bno){
        return dao.list(bno);
    }

    @Override
    public void modifyReply(ReplyVO vo){
        dao.update(vo);
    }

    @Override
    public void removeReply(Integer rno){
        dao.delete(rno);
    }

    @Override
    public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) {
        return dao.listPage(bno,cri);
    }

    @Override
    public int count(Integer bno) {
        return dao.count(bno);
    }
}
