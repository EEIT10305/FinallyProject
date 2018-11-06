package model.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.PinginBean;
import model.bean.PinginDetailBean;
import model.dao.PinginDAO;
import model.dao.PinginDetailDAO;
import model.service.PkService;

@Service
@Transactional
public class PkServiceImpl implements PkService {
	@Autowired
	PinginDAO pinginDAO;
	@Autowired
	PinginDetailDAO pinginDetailDAO;
	
    @Override
	public List<PinginBean> pkSelectAll(){
//		System.out.println("=============================================================================");
//        System.out.println("pkpkpkpkpkpkpkpkpkpkpkpkpkpkpk    SERVICE");
//		System.out.println("=============================================================================");
		return pinginDAO.selectAll();
    }
    
    @Override
  	public List<PinginDetailBean> showPinginDetail(String name){
  		System.out.println("=============================================================================");
          System.out.println("pkpkpkpkpkpkpkpkpkpkpkpkpkpkpk    SERVICE");
  		System.out.println("=============================================================================");  		
  		return pinginDetailDAO.selectPinginDetailByName(name);
      }
    
}
