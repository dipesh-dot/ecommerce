package com.productservice.controller;



import com.productservice.entity.Product;
import com.productservice.generic.CustomResponseMessage;
import com.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/price/{id}")
    public double getProductPrice(@PathVariable Long id) {
//        return productService.getProductPrice(id);
        return 50.0;
    }


    @PostMapping("/save")
    ResponseEntity<CustomResponseMessage> productSave(@RequestBody Product product){
        return getGlobalResponse(HttpStatus.CREATED,productService.saveProduct(product),"Product Saved SuccessFully ");
    }

    @GetMapping("/{id}")
    ResponseEntity<CustomResponseMessage> getProductById(@PathVariable Long id){
        return getGlobalResponse(HttpStatus.FOUND,productService.getByIdProduct(id),"Product found  ");
    }

    @GetMapping("/all")
    ResponseEntity<CustomResponseMessage> getAll(){
        return getGlobalResponse(HttpStatus.FOUND,productService.getAllProduct(),"All Product found  ");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<CustomResponseMessage> deleteProduct(@PathVariable Long id ){
        return getGlobalResponse(HttpStatus.OK,productService.deleteProductById(id),"Product deleted by id   ");
    }


    private ResponseEntity<CustomResponseMessage> getGlobalResponse(HttpStatus status, Object data, String message) {
        return ResponseEntity.ok(CustomResponseMessage.builder().status(status).data(data).message(message).build());
    }
}
