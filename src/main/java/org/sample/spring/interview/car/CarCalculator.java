package org.sample.spring.interview.car;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/car")
public class CarCalculator {

    private Double price = 10.0;

    @RequestMapping(method = RequestMethod.POST)
    public void newPrice(Double price) {
        this.price = price;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPrice() {
        return ResponseEntity.ok(price);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity recalculatePrice(@RequestParam int type) {
        if (type == 2 || type == 4) {
            this.price = 5.0;
        } else {
            this.price = 7.0;
        }
        return ResponseEntity.ok(this.price);
    }
}
