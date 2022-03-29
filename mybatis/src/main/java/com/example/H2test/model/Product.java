package com.example.H2test.model;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Product
{

    private Long prodId;
    @NonNull private String prodName;
    @NonNull private int prodPrice;
}
