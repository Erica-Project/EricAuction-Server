package ericauction.ericaution.domain.request.auction;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ProductSaveRequestDto {

    private ArrayList<String> images;
    private String title;
    private String category;
    private String detailCategory;
    private String productState;
    private int immediatePurchasePrice;
    private int lowestPriceAuction;
    private String contents;

}
