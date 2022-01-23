package com.inpt.projet.Controller;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inpt.projet.Clients.Address;
import com.inpt.projet.Clients.User;
import com.inpt.projet.dao.AddressRepository;
import com.inpt.projet.dao.BookRepository;
import com.inpt.projet.dao.UserRepository;

@RestController
public class AddressControllers {
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private AddressRepository addrepository;
	

	private String key = "popin123456mido0";
	private Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
	
	@RequestMapping(value="/UserAddress",method=RequestMethod.POST)
	public ModelAndView placeOrder(@RequestParam(name="Adresse",defaultValue="") String adresse,
			@RequestParam(name="Code_Postal",defaultValue="") String Code_postal,
			@RequestParam(name="usr",defaultValue="") String usr,
			@RequestParam(name="id",defaultValue="") long Id,
			@RequestParam(name="Tel",defaultValue="") String Tel) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Address usr_add1 = new Address();
		usr_add1.setId(Id);
		usr_add1.setAdresse(adresse);
		usr_add1.setCode_postal(Code_postal);
		usr_add1.setNum_Tel(Tel);
		addrepository.save(usr_add1);
		ModelAndView modelV = new ModelAndView("redirect:/Home");
		String s = UserControllers.encode(usr.toString(),aesKey);
		modelV.addObject("UsrName",s);
	    return modelV;

	}
}
