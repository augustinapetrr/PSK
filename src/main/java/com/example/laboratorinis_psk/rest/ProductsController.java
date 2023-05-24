package com.example.laboratorinis_psk.rest;

import com.example.laboratorinis_psk.entities.Product;
import com.example.laboratorinis_psk.persistence.ProductsDAO;
import com.example.laboratorinis_psk.rest.contracts.ProductDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;


@ApplicationScoped
@Path("/products")
public class ProductsController {

    @Inject
    @Setter @Getter
    private ProductsDAO productsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Product product = productsDAO.findOne(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return Response.ok(productDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer productId,
            ProductDto productData) {
        try {
            Product existingProduct = productsDAO.findOne(productId);
            if (existingProduct == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingProduct.setName(productData.getName());
            existingProduct.setPrice(productData.getPrice());
            existingProduct.setDescription(productData.getDescription());
            productsDAO.update(existingProduct);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response add(ProductDto productData) {

        Product newProduct = new Product();
        newProduct.setName(productData.getName());
        newProduct.setDescription(productData.getDescription());
        newProduct.setPrice(productData.getPrice());

        productsDAO.persist(newProduct);

        return Response.ok().build();
    }
}
