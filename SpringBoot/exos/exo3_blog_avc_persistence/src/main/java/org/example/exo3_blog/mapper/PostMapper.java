package org.example.exo3_blog.mapper;

import org.example.exo3_blog.entity.Post;
import org.example.exo3_blog.model.PostDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);

}
