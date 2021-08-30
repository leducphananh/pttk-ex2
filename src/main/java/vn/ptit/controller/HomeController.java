package vn.ptit.controller;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ptit.entities.Book;
import vn.ptit.repositories.BookRepository;
import vn.ptit.services.BookService;

@Controller
public class HomeController {
	@Autowired BookRepository bookRepository;
	@Autowired BookService bookService;
	
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String index(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("listbook", bookRepository.findAll());
		return "index";
	}
	
	@RequestMapping(value = { "/add-book" }, method = { RequestMethod.GET })
	public String showAddBookForm(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("new-book", new Book());
		return "add_book";
	}
	
	@RequestMapping(value = { "/add-book" }, method = { RequestMethod.POST })
	public String addBook(@ModelAttribute("new-book") Book book, ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		book.setDatecreate(new Date());
		bookRepository.save(book);
		return "redirect:/";
	}
	
	@RequestMapping(value = { "/edit-book/{id}" }, method = { RequestMethod.GET })
	public String showEditBookForm(@PathVariable Integer id, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		model.addAttribute("book", bookService.searchBookById(id).get(0));
		return "edit_book";
	}
	
	@RequestMapping(value = { "/edit-book/{id}" }, method = { RequestMethod.POST })
	public String editBook(@ModelAttribute("book") Book book, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		book.setDatecreate(new Date());
		bookRepository.save(book);
		return "redirect:/";
	}
	
	@RequestMapping(value = { "/delete-book/{id}" }, method = { RequestMethod.GET })
	public String deleteBook(@PathVariable Integer id, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		bookRepository.delete(bookService.searchBookById(id).get(0));
		return "redirect:/";
	}
	
}
