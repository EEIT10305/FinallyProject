package model.dao;

import java.util.List;

import model.bean.VgaBean;
import model.bean.WallBean;

public interface WallDAO {
	List<WallBean> selectAll();

	WallBean selectById(int id);
	
	List<WallBean> selectNeedPhoto();

	WallBean insert(WallBean bean);

	boolean update(WallBean bean);

	boolean updateSeqBySrc(Integer seq, String src);

	List<WallBean> selectNeedPhoto2();

	List<WallBean> selectBySrc(String src);

	boolean updateNoSeqBySrc(String src);
}
