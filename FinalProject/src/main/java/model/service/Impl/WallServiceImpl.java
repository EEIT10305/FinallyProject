package model.service.Impl;

import java.io.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WallBean;
import model.dao.WallDAO;
import model.service.WallService;
@Service
@Transactional
public class WallServiceImpl implements WallService {
    @Autowired
	private WallDAO wallDao;
	@Override
	public List<WallBean> getNeedPhoto() {
		return wallDao.selectNeedPhoto();
	}
	
	@Override
	public List<WallBean> getNeedPhoto2() {
		return wallDao.selectNeedPhoto2();
	}
	@Override
	public boolean changePhotoSeq(String str,String change,String amount) {
		if(str != null && str.length() > 0 && amount != null && amount.length() > 0) {
			String getStr [] = str.split(",");
			int count = 0;
			for(String get : getStr) {
				wallDao.updateSeqBySrc(count++, get);
			}
			if(change != null &&  change.length() > 0 ) {
				if(getStr.length < Integer.parseInt(amount)) {
					wallDao.updateNoSeqBySrc(change); 	
				}				
			}

			return true;
		}
		return false;
	}
	@Override
	public boolean writeFileToProj(String upload_file) {
		System.out.println(upload_file);
		String [] get = upload_file.split("\\\\");
		
		File in = new File("C:\\temp\\"+get[2]);
		File out = new File("C:\\GitVersionControl\\repository\\FinalProject\\src\\main\\webapp\\image\\"+get[2]);
		
		try {
			FileInputStream fis = new FileInputStream(in);
			FileOutputStream fos = new FileOutputStream(out);
			byte b [] = new byte[8192];
			int len = 0 ;
			
			while((len = fis.read(b))!= -1) {
				fos.write(b, 0, len);
			}
			
			fos.close();
		    fis.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean insertPhotoSeq(String upload_file) {
		String [] get = upload_file.split("\\\\");
		WallBean bean = new WallBean(null,"image/" + get[2], -1, "on");
		WallBean insert = wallDao.insert(bean);
		if(insert != null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean changePhotoSeq(String removesrc) {
		
		List<WallBean> insert = wallDao.selectBySrc(removesrc);
		if(insert != null) {
			insert.get(0).setStatu("off");
			return true;
		}
		
		return false;
	}


}
