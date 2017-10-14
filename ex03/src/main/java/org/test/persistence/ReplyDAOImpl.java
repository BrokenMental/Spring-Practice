package org.test.persistence;

import org.test.domain.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

    @Autowired
    private SqlSession session;

    private static String namespacea = "com.setting.mappers.ReplyMapper";

    @Override
    public List<ReplyVO> list(Integer bno){
        return session.selectList(namespacea + ".list", bno);
    }

    @Override
    public void create(ReplyVO vo){
        session.insert(namespacea + ".create", vo);
    }

    @Override
    public void update(ReplyVO vo){
        session.update(namespacea + ".update", vo);
    }

    @Override
    public void delete(Integer rno){
        session.delete(namespacea + ".delete", rno);
    }

}
