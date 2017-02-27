package org.test.persistence;

import java.util.List;

import org.test.domain.BoardVO;
import org.test.domain.Criteria;

public interface BoardDAO {
	
	public void create(BoardVO vo)throws Exception;
	public void update(BoardVO vo)throws Exception;
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	public List<BoardVO> listPage(int page)throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
}
