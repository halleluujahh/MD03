package ra.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.crud.model.Book;
import ra.crud.service.BookService;
import ra.crud.service.imp.BookServiceImp;

import java.util.List;

@Controller
@RequestMapping("/bookController")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookServiceImp bookServiceImp) {
        bookService = bookServiceImp;
    }

    //    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @GetMapping("/findAll")
    public ModelAndView findAllBook() {
        //1. khai báo đối tượng ModelAndView - views/books.jsp
        ModelAndView mav = new ModelAndView("books");
        //2. Lấy dữ liệu từ service
        List<Book> listBook = bookService.findAll();
        //3. Add listBook vào mav
        mav.addObject("listBook", listBook);
        return mav;
    }

    @GetMapping("/initCreate")
    public String initCreateBook(Model model) {
        //1. khởi tạo đối tượng Book để map vào form nhập liệu
        Book bookNew = new Book();
        //2. add vào model
        model.addAttribute("bookNew", bookNew);
        //3. return view sau khi thực hiện sau - return "/views/newBooks.jsp"
        return "newBook";
    }

    @PostMapping("/create")
    //public String createBook(@ModelAttribute("bookNew") Book book){
    public String createBook(Book bookNew) {
        //1. Gọi sang service thực hiện thêm mới
        boolean result = bookService.create(bookNew);
        //2. Thành công thì chuyển sang findAll, sai thì chuyển sang error.jsp
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
//    public String initUpdateBook(@RequestParam("bookId") String bookIdUpdate){
    public String initUpdateBook(String bookId, Model model) {
        Book bookUpdate = bookService.findById(bookId);
        model.addAttribute("bookUpdate", bookUpdate);
        return "updateBook";
    }

    @PostMapping("/update")
    public String updateBook(Book bookUpdate) {
        boolean result = bookService.update(bookUpdate);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/delete")
    public String deleteBook(String bookId) {
        boolean result = bookService.delete(bookId);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
}
