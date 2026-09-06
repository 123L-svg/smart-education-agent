package com.smarteducation.promotion.strategy.scope;

import com.smarteducation.api.dto.promotion.OrderCourseDTO;
import com.smarteducation.promotion.constants.ScopeType;

import java.util.List;

public interface Scope {

    boolean canUse(OrderCourseDTO course);

    ScopeType getType();

    List<Long> getScopeIds();
}
