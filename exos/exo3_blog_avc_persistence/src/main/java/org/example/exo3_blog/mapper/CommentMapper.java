package org.example.exo3_blog.mapper;

import org.example.exo3_blog.entity.Comment;
import org.example.exo3_blog.model.CommentDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CommentMapper {


    CommentDto commentToCommentDto(Comment comment);


    Comment commentDtoToComment(CommentDto commentDto);

}
