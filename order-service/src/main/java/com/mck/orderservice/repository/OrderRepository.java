package com.mck.orderservice.repository;

import com.mck.orderservice.model.*;
import org.springframework.data.jpa.repository.*;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
