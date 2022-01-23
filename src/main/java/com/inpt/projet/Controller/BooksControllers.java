package com.inpt.projet.Controller;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inpt.projet.Clients.Address;
import com.inpt.projet.Clients.Books;
import com.inpt.projet.Clients.User;
import com.inpt.projet.dao.BookRepository;
import com.inpt.projet.dao.UserRepository;

@RestController
public class BooksControllers {
	
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private UserRepository userrepository;

	private String key = "popin123456mido0";
	private Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
	
	public static Books GetByID(long id, List<Books> books) {
		int i=0;
		while ((books.get(i).getid() != id) && i<books.size()-1 ) {
			i++;
			}
		if (books.get(i).getid() == id)
			{
			return books.get(i);}
		else 
			return null;
	}
	
//	
//	public static List<Books> GetByUserName(String Keyword, List<Books> books) {
//		List<Books> last =new ArrayList<Books>();
//		for (int i =0; i<books.size();i++) {
//			if (books.get(i).getBookName().contains(Keyword)) 
//				last.add(books.get(i));
//			}
//		return last;
//	}
	
//	@RequestMapping(value="/Search",method=RequestMethod.GET)
//	public ModelAndView Search(Model model,
//			@RequestParam(name="search",defaultValue="") String key,
//			@RequestParam(name="usr",defaultValue="") String User) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
//		
//		List<Books> books = bookrepository.findAll();
//		List<Books> last = GetByUserName(key, books);
//		ModelAndView modelV = new ModelAndView("redirect:/Home");
//		String s = UserControllers.encode(User,aesKey);
//		modelV.addObject("UsrName",s);
//		modelV.addObject("Books",last);
//		return modelV;
//		
//	}
	
	@RequestMapping(value="/Books",method=RequestMethod.GET)
	public ModelAndView controllerMethod(@RequestParam(value="myParam[]") String[] myParams,
			@RequestParam(value="usr") String usr) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		
	    List<Books> books = bookrepository.findAll();
	    String NomBooks = new String();
	    NomBooks = "You rented : ";
		for (int i = 0; i<myParams.length; i++) {
            long element = Long.parseLong(myParams[i]);
            Books Book = GetByID(element, books);
            bookrepository.deleteById(element);
            Book.setDisponibility(false);
            bookrepository.save(Book);
            NomBooks = NomBooks+Book.getBookName()+" / ";
        }
		ModelAndView modelV = new ModelAndView("redirect:/Home");
		String s = UserControllers.encode(usr,aesKey);
		modelV.addObject("Rent",NomBooks.substring(0, NomBooks.length() - 3));
		modelV.addObject("UsrName",s);
	    return modelV;
	    
	}
	
	@RequestMapping(value="/BookSuperUser",method=RequestMethod.POST)
	public ModelAndView AddBook(@RequestParam(name="BookName",defaultValue="") String BookName,
			@RequestParam(name="usr",defaultValue="") String usr,
			@RequestParam(name="Author",defaultValue="") String Author,
			@RequestParam(name="Prix",defaultValue="") String Prix) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		
		Books Book = new Books();
		Book.setBookName(BookName);
		Book.setAuthor(Author);
		Book.setPrix(Prix);
		Book.setDisponibility(true);
		bookrepository.save(Book);
		ModelAndView modelV = new ModelAndView("redirect:/Home");
		String s = UserControllers.encode(usr,aesKey);
		modelV.addObject("UsrName",s);
	    return modelV;

	}
}
