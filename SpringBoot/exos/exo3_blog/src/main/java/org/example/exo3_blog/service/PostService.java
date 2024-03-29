
package org.example.exo3_blog.service;

import org.example.exo3_blog.model.Comment;
import org.example.exo3_blog.model.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
                    "In this post, we explore the mysteries of the unknown and encounter exciting adventures. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    LocalDate.of(2023, 10, 15),
                    "JohnDoe",
                    "https://img.freepik.com/photos-gratuite/foret-automne-peinture-acrylique-crepuscule-mysterieux-effrayant-genere-par-ia_188544-15640.jpg?w=1060&t=st=1708125798~exp=1708126398~hmac=8442a642f764b0387a91840bd867363f148b13d9286f943a72f21d428cefca9c",
                    createComment("Commenter1", "commenter1@example.com", "Great post! I really enjoyed reading it.", LocalDate.of(2023, 12, 18), LocalTime.of(12, 30)),
                    createComment("Commenter2", "commenter2@example.com", "Interesting thoughts. Looking forward to more content.", LocalDate.of(2023, 12, 17), LocalTime.of(14, 39)));

            Post post2 = createPost("The Art of Relaxation",
                    "Discover the secrets to achieving true relaxation.",
                    "Unwind and relax with this guide to mastering the art of tranquility and peace. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    LocalDate.of(2023, 10, 16),
                    "BobJohnson",
                    "https://img.freepik.com/vecteurs-libre/gens-plats-meditant_23-2148965673.jpg?w=1380&t=st=1708126428~exp=1708127028~hmac=ceff6cc6014ed34bd77fa344f68c1e7b09780b3c0c96daec85536ae84e35aa8d",
                    createComment("Commenter3", "commenter3@example.com", "This topic is very relevant. Thanks for sharing.", LocalDate.of(2024, 1, 1), LocalTime.of(13, 33)));

            Post post3 = createPost("Exploring the Cosmos",
                    "A cosmic journey into the wonders of the universe.",
                    "Join us as we delve into the mysteries of outer space, exploring distant galaxies and celestial phenomena. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    LocalDate.of(2023, 10, 17),
                    "EmilyWhite",
                    "https://img.freepik.com/photos-gratuite/ciel-nocturne-brille-ia-generative-irisee-dans-espace-lointain_188544-11285.jpg?w=1060&t=st=1708125355~exp=1708125955~hmac=d9349ee159f6635d3308452d6fd7af85437c4dff0b684d329e7b2f7de40d00e7",
                    createComment("Commenter4", "commenter4@example.com", "Well-written post! I appreciate your insights.", LocalDate.of(2024, 2, 10), LocalTime.of(17, 41)));

            Post post4 = createPost("The Culinary Delight",
                    "A fusion of flavors that will tantalize your taste buds.",
                    "Experience the delightful combinations of diverse cuisines coming together in a harmonious fusion of taste. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    LocalDate.of(2023, 10, 18),
                    "DavidBrown",
                    "https://img.freepik.com/photos-gratuite/plat-signature-meilleurs-chefs-dans-presentation-culinaire-haut-gamme_157027-4306.jpg?w=1060&t=st=1708125623~exp=1708126223~hmac=d3525afdd60b2dd60960c42eaf18768b7f32662ce749fe2e8bbf208da23948a1",
                    createComment("Commenter5", "commenter5@example.com", "I have a different perspective. Let's discuss.", LocalDate.of(2023, 12, 25), LocalTime.of(9, 47)));

            Post post5 = createPost("Innovations in Technology",
                    "Stay ahead with the latest technological advancements.",
                    "Explore the cutting-edge innovations that are shaping the future in the world of technology. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    LocalDate.of(2023, 10, 19),
                    "SophieGreen",
                    "https://img.freepik.com/photos-gratuite/coup-moyen-homme-portant-lunettes-vr_23-2149126949.jpg?w=1060&t=st=1708125306~exp=1708125906~hmac=5c49d8a0d5ea46afc791dfea345963e69ded53d369b2eaa32178ae06f78f096e",
                    createComment("Commenter6", "commenter6@example.com", "Your post inspired me. Thank you!", LocalDate.of(2023, 11, 27), LocalTime.of(20, 12)));

            Post post6 = createPost("Fashion Week: too much ?",
                    "Stay ahead with the latest fashion.",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\" Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    LocalDate.of(2023, 10, 19),
                    "SophieGreen",
                    "https://img.freepik.com/photos-gratuite/concept-mode-rapide-tas-vetements_23-2150871246.jpg?w=996&t=st=1708126673~exp=1708127273~hmac=1a0eb601565b89d00561a848e3332118918640202e4c6371ae9b9fa05880738e",
                    createComment("Commenter6", "commenter6@example.com", "Your post inspired me. Thank you!", LocalDate.of(2023, 11, 25), LocalTime.of(12, 30)));

            Post post7 = createPost("Exploring Nature: A Journey Into the Wilderness",
                    "Discover the beauty of untouched landscapes and diverse ecosystems.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    LocalDate.of(2023, 9, 15),
                    "NatureExplorer",
                    "https://img.freepik.com/photos-gratuite/beau-paysage-vallee-verte-pres-montagnes-alp-autriche-sous-ciel-nuageux_181624-6979.jpg?w=996&t=st=1708188340~exp=1708188940~hmac=432603b04c1432f1c8582d4b46ab627e5f96e0c11b32ddd95f0ef0dbb4eda418",
                    createComment("NatureLover", "naturelover@example.com", "This looks like an amazing adventure! Can't wait to explore nature.", LocalDate.of(2023, 9, 20), LocalTime.of(14, 45)));

            Post post8 = createPost("Tech Trends: Embracing the Future",
                    "Stay updated on the latest technological advancements and innovations.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                    LocalDate.of(2023, 8, 5),
                    "TechGeek",
                    "https://img.freepik.com/photos-gratuite/fond-humain-poignee-main-robot-ere-numerique-futuriste_53876-129770.jpg?w=996&t=st=1708189299~exp=1708189899~hmac=def6d2fbcce21a77f8d5662d4a84c8533d3a298dbc4bdbbec02e2e87a422f81c",
                    createComment("TechEnthusiast", "techenthusiast@example.com", "Incredible! The future is indeed fascinating.", LocalDate.of(2023, 8, 10), LocalTime.of(10, 15)));

            Post post9 = createPost("Culinary Delights: Tasting the World's Flavors",
                    "Embark on a gastronomic journey to savor diverse cuisines.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                    LocalDate.of(2023, 7, 12),
                    "FoodExplorer",
                    "https://img.freepik.com/vecteurs-libre/vue-aerienne-nourriture-assiette_1308-47251.jpg?w=740&t=st=1708188501~exp=1708189101~hmac=1f1004d86f34e524453c50cec18defc5766287d46dad731f876c0774ccb22a59",
                    createComment("Foodie", "foodie@example.com", "Your culinary adventures are making me hungry! Looks delicious.", LocalDate.of(2023, 7, 18), LocalTime.of(19, 30)));

            Post post10 = createPost("Artistic Expressions: Unveiling Creativity",
                    "Dive into the world of art and explore diverse forms of expression.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    LocalDate.of(2023, 6, 28),
                    "ArtLover",
                    "https://img.freepik.com/vecteurs-libre/illustration-style-picasso-dessine-main_23-2149577316.jpg?w=996&t=st=1708188274~exp=1708188874~hmac=6a592878d895a2b3fcf031731b3b9478e01a220c566a4de94be2378dd7c5ae01",
                    createComment("ArtAppreciator", "artappreciator@example.com", "Your artistic journey is truly inspiring. Keep creating!", LocalDate.of(2023, 7, 5), LocalTime.of(15, 50)));

            Post post11 = createPost("Fitness Journey: Achieving Wellness Goals",
                    "Embark on a fitness journey to enhance physical and mental well-being.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? ",
                    LocalDate.of(2023, 4, 8),
                    "FitExplorer",
                    "https://img.freepik.com/vecteurs-libre/activites-sportives-homme_102902-2338.jpg?w=740&t=st=1708189376~exp=1708189976~hmac=4683712a584563dca585f1e7c4081cc83c1d889abb992f47ac8c246a4cbfe233",
                    createComment("FitnessEnthusiast", "fitnessenthusiast@example.com", "Your dedication to fitness is truly inspiring. Keep pushing your limits!", LocalDate.of(2023, 4, 15), LocalTime.of(17, 20)));


            Post post12 = createPost("Travel Diaries: Roaming the Globe",
                    "Embark on an adventure to explore diverse cultures and landscapes.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                    LocalDate.of(2023, 5, 20),
                    "GlobeTrotter",
                    "https://img.freepik.com/photos-gratuite/belle-fille-debout-bateau-recherche-montagnes-dans-barrage-ratchaprapha-au-parc-national-khao-sok-province-surat-thani-thailande_335224-849.jpg?w=996&t=st=1708188204~exp=1708188804~hmac=4752217fd8384cd110be9eb1fcdb737764eaa12bc487fbf5444d78de799389c6",
                    createComment("TravelEnthusiast", "travelenthusiast@example.com", "Your travel stories are motivating me to plan my next adventure!", LocalDate.of(2023, 5, 26), LocalTime.of(11, 10)));


            posts.put(post1.getId(), post1);
            posts.put(post2.getId(), post2);
            posts.put(post3.getId(), post3);
            posts.put(post4.getId(), post4);
            posts.put(post5.getId(), post5);
            posts.put(post6.getId(), post6);
            posts.put(post7.getId(), post7);
            posts.put(post8.getId(), post8);
            posts.put(post9.getId(), post9);
            posts.put(post10.getId(), post10);
            posts.put(post11.getId(), post11);
            posts.put(post12.getId(), post12);

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
                            post.getTitle().toLowerCase().contains(searchLower))
                    .toList();
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

        private Post createPost(String title, String description, String content, LocalDate date, String authorPseudo, String imageUrl, Comment... comments) {
            return Post.builder()
                    .id(UUID.randomUUID())
                    .title(title)
                    .description(description)
                    .content(content)
                    .date(date)
                    .authorPseudo(authorPseudo)
                    .imageUrl(imageUrl)
                    .commentList(new ArrayList<>(List.of(comments)))
                    .build();
        }

        private Comment createComment(String username, String email, String content, LocalDate date, LocalTime time) {
            return Comment.builder()
                    .id(UUID.randomUUID())
                    .username(username)
                    .email(email)
                    .content(content)
                    .date(date)
                    .time(time)
                    .build();
        }

    }


