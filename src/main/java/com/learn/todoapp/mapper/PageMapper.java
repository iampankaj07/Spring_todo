package com.learn.todoapp.mapper;

import com.learn.todoapp.utils.PageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageMapper {
    public static <T> PageResponse<T> toPageResponse(Page<?> page, List<T> data) {
        return new PageResponse<>(
                data,
                page.getNumber(),
                page.getNumberOfElements(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast());
    }
}
