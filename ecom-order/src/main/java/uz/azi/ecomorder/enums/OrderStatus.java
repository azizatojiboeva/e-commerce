package uz.azi.ecomorder.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {

    NEW,
    PAID,
    DELIVERED,
    CANCELLED,
    PAID_CANCELLED,
    CLOSED;

}
