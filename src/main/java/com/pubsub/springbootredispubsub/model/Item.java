package com.pubsub.springbootredispubsub.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

      String itemID;
      String itemName;


}
