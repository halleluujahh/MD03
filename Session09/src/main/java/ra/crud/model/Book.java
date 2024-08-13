package ra.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private String bookId;
    private String bookName;
    private float price;
    private boolean status;
}
