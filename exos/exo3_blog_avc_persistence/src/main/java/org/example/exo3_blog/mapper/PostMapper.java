package org.example.exo3_blog.mapper;

import org.example.exo3_blog.entity.Post;
import org.example.exo3_blog.model.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "title", target = "title")
    PostDto postToPostDto(Post post);

    @Mapping(source = "title", target = "title")
    Post postDtoToPost(PostDto postDto);

}
