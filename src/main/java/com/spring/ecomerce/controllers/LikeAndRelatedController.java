package com.spring.ecomerce.controllers;

import com.spring.ecomerce.arch.BaseResponseEntity;
import com.spring.ecomerce.childprocess.ChildProcess;
import com.spring.ecomerce.commons.MessageManager;
import com.spring.ecomerce.entities.clone.ProductEntity;
import com.spring.ecomerce.exception.SystemException;
import com.spring.ecomerce.services.ProductService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LikeAndRelatedController {
    @Autowired
    private ChildProcess childProcess;

    @Autowired
    private MessageManager messageManager;

    @Autowired
    private BaseResponseEntity baseResponse;

    @GetMapping("/train-like")
    public String getLikeProduct() throws SystemException {
        try{
            boolean isSuccess =  childProcess.trainLikeProduct();
            if(isSuccess){
                baseResponse.retrieved();
                baseResponse.setMessage("Training successfully");
            }
            else{
                baseResponse.failed(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Training failed");
            }

            return baseResponse.getResponseBody();

        }catch (Exception ex){
            baseResponse.failed(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Training failed");
        }

        return baseResponse.getResponseBody();
    }

    @GetMapping("/train-relate")
    public String getRelateProduct() throws SystemException {
        try{
            boolean isSuccess =  childProcess.trainRelatedProduct();
            if(isSuccess){
                baseResponse.retrieved();
                baseResponse.setMessage("Training successfully");
            }
            else{
                baseResponse.failed(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Training failed");
            }

            return baseResponse.getResponseBody();

        }catch (Exception ex){
            baseResponse.failed(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Training failed");
        }

        return baseResponse.getResponseBody();
    }
}
