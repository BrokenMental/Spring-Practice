package org.test.persistence;

import org.test.domain.Criteria;
import org.test.domain.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.setting.mappers.ReplyMapper";

    @Override
    public List<ReplyVO> list(Integer bno){
        return session.selectList(namespace + ".list", bno);
    }

    @Override
    public void create(ReplyVO vo){
        session.insert(namespace + ".create", vo);
    }

    @Override
    public void update(ReplyVO vo){
        session.update(namespace + ".update", vo);
    }

    @Override
    public void delete(Integer rno){
        session.delete(namespace + ".delete", rno);
    }

    @Override
    public List<ReplyVO> listPage(Integer bno, Criteria cri) {
        Map<String, Object> paramMap = new HashMap<String, Object>(); // HashMap 사용 시 <Key, Value>를 명확하게 정해줘도 되고 안해줘도 된다.

        paramMap.put("bno", bno);
        paramMap.put("cri", cri);

        return session.selectList(namespace + ".listPage", paramMap);
    }

    @Override
    public int count(Integer bno) {
        return session.selectOne(namespace + ".count", bno);
    }
}
