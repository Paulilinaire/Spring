
package org.example.exo3_blog.service;

import org.example.exo3_blog.model.Comment;
import org.example.exo3_blog.model.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

    @Service
    public class PostService implements BaseService<Post> {

        private final Map<UUID, Post> posts;

        public PostService() {
            posts = new HashMap<>();

            Post post1 = createPost("Exciting Adventure in the Unknown",
                    "Embark on a thrilling journey of discovery.",
                    "In this post, we explore the mysteries of the unknown and encounter exciting adventures.",
                    LocalDate.of(2023, 10, 15),
                    "JohnDoe",
                    createComment("Commenter1", "commenter1@example.com", "Great post! I really enjoyed reading it."),
                    createComment("Commenter2", "commenter2@example.com", "Interesting thoughts. Looking forward to more content."));

            Post post2 = createPost("The Art of Relaxation",
                    "Discover the secrets to achieving true relaxation.",
                    "Unwind and relax with this guide to mastering the art of tranquility and peace.",
                    LocalDate.of(2023, 10, 16),
                    "BobJohnson",
                    createComment("Commenter3", "commenter3@example.com", "This topic is very relevant. Thanks for sharing."));

            Post post3 = createPost("Exploring the Cosmos",
                    "A cosmic journey into the wonders of the universe.",
                    "Join us as we delve into the mysteries of outer space, exploring distant galaxies and celestial phenomena.",
                    LocalDate.of(2023, 10, 17),
                    "EmilyWhite",
                    createComment("Commenter4", "commenter4@example.com", "Well-written post! I appreciate your insights."));

            Post post4 = createPost("The Culinary Delight",
                    "A fusion of flavors that will tantalize your taste buds.",
                    "Experience the delightful combinations of diverse cuisines coming together in a harmonious fusion of taste.",
                    LocalDate.of(2023, 10, 18),
                    "DavidBrown",
                    createComment("Commenter5", "commenter5@example.com", "I have a different perspective. Let's discuss."));

            Post post5 = createPost("Innovations in Technology",
                    "Stay ahead with the latest technological advancements.",
                    "Explore the cutting-edge innovations that are shaping the future in the world of technology.",
                    LocalDate.of(2023, 10, 19),
                    "SophieGreen",
                    createComment("Commenter6", "commenter6@example.com", "Your post inspired me. Thank you!"));

            posts.put(post1.getId(), post1);
            posts.put(post2.getId(), post2);
            posts.put(post3.getId(), post3);
            posts.put(post4.getId(), post4);
            posts.put(post5.getId(), post5);
        }

        @Override
        public List<Post> getAll() {
            return new ArrayList<>(posts.values());
        }

        @Override
        public Post getById(UUID id) {
            return posts.get(id);
        }

        @Override
        public boolean create(Post post) {
            throw new UnsupportedOperationException("create method not implemented");
        }

        @Override
        public List<Post> search(String search) {
            String searchLower = search.toLowerCase();

            return posts
                    .values()
                    .stream()
                    .filter(post ->
                            post.getTitle().toLowerCase().contains(searchLower) ||
                                    post.getDescription().toLowerCase().contains(searchLower))
                    .toList();
        }

        @Override
        public List<Comment> getCommentsForPost(UUID postId) {
            Post post = posts.get(postId);
            return (post != null) ? post.getCommentList() : new ArrayList<>();
        }

        @Override
        public boolean addCommentToPost(UUID postId, Comment comment) {
            Post post = posts.get(postId);
            if (post != null) {
                comment.setId(UUID.randomUUID());
                post.getCommentList().add(comment);
                return true;
            }
            return false;
        }

        private Post createPost(String title, String description, String content, LocalDate date, String authorPseudo, Comment... comments) {
            return Post.builder()
                    .id(UUID.randomUUID())
                    .title(title)
                    .description(description)
                    .content(content)
                    .date(date)
                    .authorPseudo(authorPseudo)
                    .commentList(List.of(comments))
                    .build();
        }

        private Comment createComment(String username, String email, String content) {
            return Comment.builder()
                    .id(UUID.randomUUID())
                    .username(username)
                    .email(email)
                    .content(content)
                    .build();
        }
    }


