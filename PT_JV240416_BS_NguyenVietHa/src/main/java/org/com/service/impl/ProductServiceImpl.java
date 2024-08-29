package org.com.service.impl;

import org.com.dto.mapper.impl.MapperProductImpl;
import org.com.dto.request.ProductDTO;
import org.com.dto.response.ProductRes;
import org.com.entity.Product;
import org.com.repository.ProductRepository;
import org.com.service.ProductService;
import org.com.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MapperProductImpl mapperProductImpl;
    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public boolean save(ProductDTO productDTO) {
        if (productRepository.findByName(productDTO.getName()) != null) {
            return false;
        }
        Product p;
        if(productDTO.getImage()!=null) {
            String avatarUrlFirebase = uploadFileService.uploadFileToLocal(productDTO.getImage());
            p = mapperProductImpl.mapperRequestToEntity(productDTO);
            p.setImage(avatarUrlFirebase);
        }else{
            p = mapperProductImpl.mapperRequestToEntity(productDTO);
            p.setImage(productRepository.findById(productDTO.getId()).getImage());
        }

        return productRepository.save(p);
    }

    @Override
    public List<ProductRes> findAll(Integer pageNo, int pageSize) {
        if(pageNo<=0){
            pageNo=1;
        }
        List<Product> listP = productRepository.findAll(pageNo, pageSize);
        List<ProductRes> listProductRes = new ArrayList<ProductRes>();
        for (int i = 0; i < listP.size(); i++) {
            listProductRes.add(mapperProductImpl.mapperEntityToResponse(listP.get(i)));
        }
        return listProductRes;
    }

    @Override
    public Product findById(int id) {
        if(productRepository.findById(id) != null) {
            return productRepository.findById(id);
        }
        return null;
    }

    @Override
    public boolean remove(int id) {
        return productRepository.remove(id);
    }

    @Override
    public boolean update(ProductDTO productDTO) {
        if (productRepository.findByName(productDTO.getName()) != null) {
            return false;
        }
        Product p;
        if(productDTO.getImage()!=null) {
            String avatarUrlFirebase = uploadFileService.uploadFileToLocal(productDTO.getImage());
            p = mapperProductImpl.mapperRequestToEntity(productDTO);
            p.setImage(avatarUrlFirebase);
        }else{
            p = mapperProductImpl.mapperRequestToEntity(productDTO);
            p.setImage(productRepository.findById(productDTO.getId()).getImage());
        }
        return productRepository.update(p);
    }

    @Override
    public List<ProductRes> findAllByName(String name) {
        List<Product> listP = productRepository.findAllByName(name);
        List<ProductRes> listProductRes = new ArrayList<ProductRes>();
        for (int i = 0; i < listP.size(); i++) {
            listProductRes.add(mapperProductImpl.mapperEntityToResponse(listP.get(i)));
        }
        return listProductRes;
    }
}
