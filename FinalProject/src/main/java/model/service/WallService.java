package model.service;

import java.util.List;

import model.bean.WallBean;

public interface WallService {
	public List<WallBean> getNeedPhoto();
	public List<WallBean> getNeedPhoto2();
	public boolean changePhotoSeq(String str, String change, String amount);
	boolean writeFileToProj(String upload_file);
	boolean insertPhotoSeq(String upload_file);
	boolean changePhotoSeq(String removesrc);
}
