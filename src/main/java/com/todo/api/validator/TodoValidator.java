package com.todo.api.validator;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.todo.api.exception.TodoBadRequestException;
import com.todo.api.models.Todo;
import com.todo.api.utils.StringUtils;

@Service
public class TodoValidator implements ITodoValidator {

    @Override
    public void validate(Todo todo){
        if(StringUtils.isBlank(todo.getTitle())){
            throw new TodoBadRequestException("Title is required");
        }
        if(StringUtils.isBlank(todo.getDescription())){
            throw new TodoBadRequestException("Description is required");
        }
        // if(Objects.isNull(todo.getStatus())){
        //     throw new TodoBadRequestException("Status is required");
        // }
    }
    
}
