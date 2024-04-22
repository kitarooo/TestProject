package backend.microservices.testproject.dto.request;

import backend.microservices.testproject.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    Product product;
    int quantity;
    String address;
    String phoneNumber;
}
