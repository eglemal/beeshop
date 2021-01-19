package com.example.eshop_backend.product;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class MockProductRepository implements ProductRepository {

    private final Map<String, Product> productMap = new HashMap<>();

    public MockProductRepository() {
        save(new Product(1L, getImage("static/bitute.jpg"), getImage("static/bitesudraugu.jpg"), getImage("static/bitutesudraugu2.jpg"), "bitute", 5L, "Labai smagi, ryski bitute. Gali buti kaip suvenyras, kaip zaislas, ar net kaip draugas."));
        save(new Product(2L, getImage("static/juosta1.jpg"), getImage("static/juosta1_modelis.jpg"), getImage("static/alpaca.jpeg"), "juosta1", 2L, "Juostute ant galvutes."));
        save(new Product(3L, getImage("static/pirstines.jpg"),getImage("static/pirstines_modelis.jpg"), getImage("static/pirstines_modelis2.jpg"),  "pirstines", 6L, "Pirstinytes siltos, visa ka..."));
        save(new Product(4L, getImage("static/kepure1.jpg"), getImage("static/kepure1_modelis.jpg"), getImage("static/alpaca.jpeg"),"kepure", 6L, "Kepuryte didelei galvytei su mazu bumbuliuku. Jei siandien ne bumbulo diena, ne beda - kepure dvipuse, bumbulas lengvai pasislepia."));
        save(new Product(5L, getImage("static/dekliukas.jpg"), getImage("static/dekliukas2.jpg"), getImage("static/alpaca.jpeg"),"dekliukas", 2L, "Dekliukas realiai bet kam, geriausiai atrodo tiktu kortelems. Kortos tilptu taip pat."));
        save(new Product(6L, getImage("static/dezute1.jpg"), getImage("static/dezute2.jpg"),getImage("static/dezute1.jpg"),"dezute", 2L, "Dezute skirta laikyti ivairiausiems dalykeliams. As deciau saldainiukus, bet galima ir sausainiukus, ar zefyriukus."));
        save(new Product(7L, getImage("static/gertuves_deklas.jpg"),getImage("static/gertuves_deklas_modelis.jpg"),getImage("static/alpaca.jpeg"),"gertuves deklas", 2L, "Prie -20 gertuves reikia rengti. Taigi gertuves deklas skuba jums i pagalba."));
        save(new Product(8L, getImage("static/kepure_simple.jpg"),getImage("static/kepure_simple_modelis1.jpg"),getImage("static/kepure_simple_ilgesne.jpg"),"kepure simple", 4L, "Kepure pavadinimu simple. Kaip sakoma: simple, bet ne prasciausia. Ivairiausi nesiojimo budai."));
        save(new Product(9L, getImage("static/kepuriu_pora.jpg"),getImage("static/kepuriu_pora_modelis1.jpg"),getImage("static/kepuriu_pora_modelis2.jpg"),"kepuriu pora", 6L, "Kepuriu pora, arba kitaip sakant dvi kepures. Tinka jei esate dviese. Arba jei esate siamo dvyniai."));
        save(new Product(10L, getImage("static/milzinukepure.jpg"),getImage("static/kepure_milzinams_modelis.jpg"),getImage("static/milzinukepuremodelis.jpg"),"milzino kepure", 6L, "I sia kepure tilps bet kas. Ypac tinka burtams."));


    }

    @Override
    public void save(Product product) {
        productMap.put(product.getProductName(), product);
    }

    @Override
    public Product findByProductName(String productName) {
        return productMap.get(productName);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    private String getImage(String path) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);
        byte[] image;
        try {
            image = is.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] encode = Base64.getEncoder().encode(image);
        return new String(encode);
    }
}
