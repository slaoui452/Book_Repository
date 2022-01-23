package com.inpt.projet.Controller;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inpt.projet.Clients.Address;
import com.inpt.projet.Clients.Books;
import com.inpt.projet.Clients.User;
import com.inpt.projet.dao.AddressRepository;
import com.inpt.projet.dao.BookRepository;
import com.inpt.projet.dao.UserRepository;
import com.inpt.projet.dto.UserRequest;


@RestController
public class UserControllers {
	

	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private AddressRepository addrepository;

	private String key = "popin123456mido0";
	private Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    

	public static User GetByUserName(String uid, List<User> Users) {
		int i=0;
		while ((!Users.get(i).getUserName().equals(uid)) && i<Users.size()-1 ) {
			i++;
			}
		if (Users.get(i).getUserName().equals(uid))
			{
			return Users.get(i);}
		else 
			return null;
	}
	
	public static Address GetByID(long id, List<Address> add) {
		int i=0;
		while ((add.get(i).getId() != id) && i<add.size()-1 ) {
			i++;
			}
		if (add.get(i).getId() == id)
			{
			return add.get(i);}
		else 
			return null;
	}
	
	public static String encode(String usr1, Key aesKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	    String usr_str= usr1;
	    byte[] encrypted = cipher.doFinal(usr_str.getBytes());
	    String s = new String(encrypted, StandardCharsets.ISO_8859_1);
	    return s;
	}
	
	public static String decode(String usr1, Key aesKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    	Cipher cipher = Cipher.getInstance("AES");
    	cipher.init(Cipher.DECRYPT_MODE, aesKey);
    	byte[] bytes = usr1.getBytes(StandardCharsets.ISO_8859_1);
        String decrypted = new String(cipher.doFinal(bytes));
	    return decrypted;
	}
	
	public static User ToUser(String usr) {
		String[] test = usr.split(", ");
		User usr1 = new User(Long.parseLong(test[0]),test[1],test[2],test[3],test[4],test[5],null);
		return usr1;
		
	}
	@RequestMapping(value="/UserRegister",method=RequestMethod.POST)
	public ModelAndView placeOrder(@RequestParam(name="Name",defaultValue="") String Name,
			@RequestParam(name="Last_Name",defaultValue="") String Last_Name,
			@RequestParam(name="UsrName",defaultValue="") String UsrName,
			@RequestParam(name="mail",defaultValue="") String mail,
			@RequestParam(name="pwd",defaultValue="") String pwd) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		User usr1 = new User();
		usr1.setBooks(null);
		usr1.setNom(Name);
		usr1.setPrenom(Last_Name);
		usr1.setUserName(UsrName);
		usr1.setPassWord(pwd);
		usr1.setEmail(mail);
		userrepository.save(usr1);
		ModelAndView modelV = new ModelAndView("redirect:/Home");
		String s = encode(usr1.toString(),aesKey);
		modelV.addObject("UsrName",s);
	    return modelV;

	}
	
	@RequestMapping(value="/Home",method=RequestMethod.GET)
	public ModelAndView test(Model model,
			@RequestParam(name="UsrName",defaultValue="") String user,
			@RequestParam(name="Rent",defaultValue="") String Rent
	) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("header.html");
	    if (!user.equals("")) {
	    	String decrypted = decode(user, aesKey);
	    	User info_user = ToUser(decrypted);
            model.addAttribute("UsrName",decrypted);
            long x=info_user.getId();
            List<Address> addr = addrepository.findAll();
            Address usr_addr=null;
            try {
            usr_addr= GetByID(x,addr);}
            catch(Exception e) {
            }
            model.addAttribute("bool_add",usr_addr);
            model.addAttribute("info_user",info_user);
	    }

	    List<Books> books = bookrepository.findAll();
        model.addAttribute("Books",books);
        model.addAttribute("Rent",Rent);
	    return modelAndView;
	}
	
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public ModelAndView findAllUsers(Model model,
			@RequestParam(name="uid",defaultValue="") String uid,
			@RequestParam(name="pwd",defaultValue="") String pass_word){
		List<User> All_users = userrepository.findAll();
		 try {
		 User usr1=GetByUserName(uid,All_users);
		 if (usr1.getPassWord().equals(pass_word)){
			ModelAndView modelV = new ModelAndView("redirect:/Home");
			String s = encode(usr1.toString(),aesKey);
			modelV.addObject("UsrName",s);
			
		    return modelV;
		 }
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		return null;
	}

	

}
