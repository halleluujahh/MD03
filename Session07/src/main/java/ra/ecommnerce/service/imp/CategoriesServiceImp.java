package ra.ecommnerce.service.imp;

import ra.ecommnerce.entity.Categories;
import ra.ecommnerce.repository.CategoriesRepository;
import ra.ecommnerce.repository.imp.CategoriesRepositoryImp;
import ra.ecommnerce.service.CategoriesService;

import java.util.List;

public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImp() {
        categoriesRepository = new CategoriesRepositoryImp();
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public boolean create(Categories catalog) {
        return categoriesRepository.create(catalog);
    }

    @Override
    public Categories findById(int catalogId) {
        return categoriesRepository.findById(catalogId);
    }

    @Override
    public boolean update(Categories catalog) {
        return categoriesRepository.update(catalog);
    }

    @Override
    public boolean delete(int catalogId) {
        return categoriesRepository.delete(catalogId);
    }
}
