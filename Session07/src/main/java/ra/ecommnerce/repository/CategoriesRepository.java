package ra.ecommnerce.repository;

import ra.ecommnerce.entity.Categories;

import javax.xml.catalog.Catalog;
import java.util.List;

public interface CategoriesRepository {
    List<Categories> findAll();

    boolean create(Categories catalog);

    Categories findById(int catalogId);

    boolean update(Categories catalog);

    boolean delete(int catalogId);
}
