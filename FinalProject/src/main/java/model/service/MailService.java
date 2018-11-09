package model.service;

import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonElement;

public interface MailService {
	List<HashMap<String,Object>> getMailForMe(String email);

	boolean readMail(String id);

	List<HashMap<String,Object>> readMailAll(String email);

}
