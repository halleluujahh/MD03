package ra.ecommnerce.controller;

import ra.ecommnerce.entity.Categories;
import ra.ecommnerce.service.CategoriesService;
import ra.ecommnerce.service.imp.CategoriesServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriesController", value = "/CategoriesController")
public class CategoriesController extends HttpServlet {
    private final CategoriesService categoriesService;

    public CategoriesController() {
        categoriesService = new CategoriesServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lây tham số action trên URL
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllCategories(request, response);
        } else if (action.equals("initUpdate")) {
            //-Lấy catalogId trong request
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            //-Từ catalogId lấy thông tin catalog cần cập nhật trong database
            Categories catalogUpdate = categoriesService.findById(catalogId);
            //-Chuyên catalog sang trang jsp hiển thị cho người dùng sửa
            request.setAttribute("catalogUpdate", catalogUpdate);
            request.getRequestDispatcher("views/updateCatalog.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            //Thực hiện xóa
            //-Lấy catalogId trong request
            int catalogIdDelete = Integer.parseInt(request.getParameter("catalogId"));
            //-Gọi service thực hiên xóa catalog theo catalogId
            boolean result = categoriesService.delete(catalogIdDelete);
            if (result){
                findAllCategories(request,response);
            }else{
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }

    public void findAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> listCategories = categoriesService.findAll();
        //add listCategories vào request để chuyển sang trang categories.jsp hiển thị
        request.setAttribute("listCategories", listCategories);
        //Chuyển sang trạng categories.jsp và forward cả request và response
        request.getRequestDispatcher("views/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            //Thêm mới danh mục
            //-B1: Lấy dữ liệu trên form trong body của request
            Categories catalog = new Categories();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setDescription(request.getParameter("description"));
            catalog.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //-B2: Gọi service thực hiện them mới
            boolean result = categoriesService.create(catalog);
            //-B3: Lấy dữ liệu mới hiển thị trên categories.jsp
            if (result) {
                findAllCategories(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action.equals("Update")) {
            //Thực hiện update
            //-Lấy dữ liệu catalogUpdate trong request
            Categories catalogUpdate = new Categories();
            catalogUpdate.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            catalogUpdate.setCatalogName(request.getParameter("catalogName"));
            catalogUpdate.setDescription(request.getParameter("description"));
            catalogUpdate.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //-Goi sang service thực hiện update
            boolean result = categoriesService.update(catalogUpdate);
            //-Gọi findAllCategories để lấy dữ liệu trong database và hiển thị trên categories.jsp
            if (result) {
                findAllCategories(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }
}