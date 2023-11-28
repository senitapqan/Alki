package kz.senitapqan.alki.utils;

import lombok.Getter;

public enum OrderStatus {
    PENDING("still in progress"),
    ACCEPTED("product successfully sent"),
    REJECTED("order was rejected due to some problems");
    @Getter
    private String value;
    OrderStatus(String value){
        this.value = value;
    }



}
