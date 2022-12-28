package com.spring.ecomerce.childprocess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChildProcess {
    public boolean trainLikeProduct() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "/like.py");
            Process ps = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(ps.getInputStream())
            );

            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public boolean trainRelatedProduct() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "/relate.py");
            Process ps = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(ps.getInputStream())
            );

            return true;
        } catch (Exception ex){
            return false;
        }
    }
}
