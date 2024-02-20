package org.example.exo3_blog.mapper;

import org.example.exo3_blog.entity.Comment;
import org.example.exo3_blog.model.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "username", target = "username")
    CommentDto commentToCommentDto(Comment comment);

    @Mapping(source = "username", target = "username")
    Comment commentDtoToComment(CommentDto commentDto);

}
