package com.clickit.dao;

import com.clickit.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedItemDao extends JpaRepository<OrderedItem,Long > {
}
