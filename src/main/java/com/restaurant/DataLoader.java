package com.restaurant;

import com.restaurant.models.Product;
import com.restaurant.models.Role;
import com.restaurant.models.User;
import com.restaurant.models.Category;
import com.restaurant.repositories.ProductRepository;
import com.restaurant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // add admin upon init
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setName("Admin User");
            admin.setEmail("admin@restaurant.com");
            admin.setPassword(passwordEncoder.encode("adminpassword"));
            admin.setRole(Role.ADMIN);
            admin.setStatus(1);
            admin.setAddedDate(LocalDateTime.now());
            admin.setDeletedDate(null);
            admin.setPhoneNumber("+11234567890");
            admin.setAddress("123 Admin Street, Cityville, Adminland");

            userRepository.save(admin);

            System.out.println("Admin user created successfully");
        }

        // add products when database is empty
        if (productRepository.count() == 0) {
            Product product1 = new Product();
            product1.setName("Halo-halo Special");
            product1.setDescription("A refreshing Filipino dessert with crushed ice, milk, and a mix of sweet ingredients like ube, leche flan, and macapuno.");
            product1.setPrice(118);
            product1.setStatus(1);
            product1.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Halo-Halo-Special.png");
            product1.setCategory(Category.BEST_SELLER);

            Product product2 = new Product();
            product2.setName("Halo-halo Jr.");
            product2.setDescription("A smaller version of our Halo-halo Special, packed with the same delicious ingredients in a lighter serving.");
            product2.setPrice(88);
            product2.setStatus(1);
            product2.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Halo-Halo-Jr.png");
            product2.setCategory(Category.BEST_SELLER);

            Product product3 = new Product();
            product3.setName("Palabok Overload");
            product3.setDescription("A generously topped palabok dish with a rich, savory shrimp-based sauce, chicharrón, boiled eggs, and spring onions.");
            product3.setPrice(149);
            product3.setStatus(1);
            product3.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Palabok-Overload.png");
            product3.setCategory(Category.BEST_SELLER);

            Product product4 = new Product();
            product4.setName("Palabok Special");
            product4.setDescription("A flavorful pancit palabok dish with classic ingredients, including shrimp sauce, garlic, eggs, and chicharrón.");
            product4.setPrice(119);
            product4.setStatus(1);
            product4.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Palabok-Special-533x400.png");
            product4.setCategory(Category.BEST_SELLER);

            Product product5 = new Product();
            product5.setName("Palabok Jr.");
            product5.setDescription("A smaller serving of our Palabok Special, perfect for those looking for a light yet satisfying meal.");
            product5.setPrice(99);
            product5.setStatus(1);
            product5.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Palabok-Jr-533x400.png");
            product5.setCategory(Category.BEST_SELLER);

            Product product6 = new Product();
            product6.setName("Glenn's Palabok");
            product6.setDescription("A signature palabok dish with a unique blend of flavors, topped with our special sauce and fresh ingredients.");
            product6.setPrice(109);
            product6.setStatus(1);
            product6.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Glenn_s-Palabok-533x400.png");
            product6.setCategory(Category.BEST_SELLER);

            Product product7 = new Product();
            product7.setName("Glenn's Palabok Jr.");
            product7.setDescription("A junior-sized portion of Glenn's Palabok, delivering the same signature taste in a smaller serving.");
            product7.setPrice(89);
            product7.setStatus(1);
            product7.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Glenn_s-Jr-Palabok-533x400.png");
            product7.setCategory(Category.BEST_SELLER);

            Product product8 = new Product();
            product8.setName("Fresh Lumpia");
            product8.setDescription("A soft, savory lumpia roll filled with fresh vegetables, wrapped in a delicate crepe, and served with sweet garlic sauce.");
            product8.setPrice(49);
            product8.setStatus(1);
            product8.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Fresh-Lumpia-533x400.png");
            product8.setCategory(Category.BEST_SELLER);

            Product product9 = new Product();
            product9.setName("Fried Lumpia");
            product9.setDescription("A crispy and golden-fried spring roll filled with a delicious mix of vegetables and meat, served with a tasty dipping sauce.");
            product9.setPrice(49);
            product9.setStatus(1);
            product9.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Fried-Lumpia-533x400.png");
            product9.setCategory(Category.BEST_SELLER);

            Product product10 = new Product();
            product10.setName("Lumpiang Shanghai");
            product10.setDescription("A Filipino favorite—crispy bite-sized spring rolls stuffed with seasoned ground meat and served with a tangy dipping sauce.");
            product10.setPrice(69);
            product10.setStatus(1);
            product10.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Lumpiang-Shanghai-533x400.png");
            product10.setCategory(Category.BEST_SELLER);

            Product product11 = new Product();
            product11.setName("Ube Macapuno");
            product11.setDescription("A rich and creamy ube-flavored dessert topped with sweet macapuno, offering a delightful combination of flavors.");
            product11.setPrice(109);
            product11.setStatus(1);
            product11.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Ube-Macapuno-533x400.png");
            product11.setCategory(Category.BEST_SELLER);

            Product product12 = new Product();
            product12.setName("Ube Macapuno Jr.");
            product12.setDescription("A junior-sized serving of our Ube Macapuno dessert, perfect for satisfying your sweet tooth without the guilt.");
            product12.setPrice(89);
            product12.setStatus(1);
            product12.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Ube-Macapuno-Jr-533x400.png");
            product12.setCategory(Category.BEST_SELLER);

            Product product13 = new Product();
            product13.setName("Mais Con Leche");
            product13.setDescription("Sweet corn kernels mixed with creamy milk, served chilled for a refreshing treat.");
            product13.setPrice(109);
            product13.setStatus(1);
            product13.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Mais-Con-Leche-533x400.png");
            product13.setCategory(Category.BEST_SELLER);

            Product product14 = new Product();
            product14.setName("Mais Macapuno");
            product14.setDescription("A delightful blend of sweet corn and chewy macapuno coconut in creamy milk.");
            product14.setPrice(109);
            product14.setStatus(1);
            product14.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Mais-Macapuno-533x400.png");
            product14.setCategory(Category.BEST_SELLER);

            Product product15 = new Product();
            product15.setName("Caldo Overload");
            product15.setDescription("A hearty bowl of arroz caldo packed with toppings, perfect for a satisfying meal.");
            product15.setPrice(149);
            product15.setStatus(1);
            product15.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Caldo-Overload-533x400.png");
            product15.setCategory(Category.BEST_SELLER);

            Product product16 = new Product();
            product16.setName("Special Caldo");
            product16.setDescription("A rich and flavorful arroz caldo made with chicken, ginger, and spices.");
            product16.setPrice(99);
            product16.setStatus(1);
            product16.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Special-Caldo-533x400.png");
            product16.setCategory(Category.BEST_SELLER);

            Product product17 = new Product();
            product17.setName("Regular Caldo");
            product17.setDescription("A classic and comforting bowl of arroz caldo, perfect for any time of the day.");
            product17.setPrice(89);
            product17.setStatus(1);
            product17.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Regular-Caldo-533x400.png");
            product17.setCategory(Category.BEST_SELLER);

            Product product18 = new Product();
            product18.setName("Home-made Spaghetti");
            product18.setDescription("Filipino-style spaghetti with a sweet and savory sauce, topped with cheese.");
            product18.setPrice(99);
            product18.setStatus(1);
            product18.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Home-Made-Spaghetti-533x400.png");
            product18.setCategory(Category.BEST_SELLER);

            Product product19 = new Product();
            product19.setName("Pancit Canton");
            product19.setDescription("Savory stir-fried noodles with vegetables, meat, and a flavorful sauce.");
            product19.setPrice(79);
            product19.setStatus(1);
            product19.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Pancit-Canton-533x400.png");
            product19.setCategory(Category.BEST_SELLER);

            Product product20 = new Product();
            product20.setName("Special Lomi");
            product20.setDescription("Thick and savory egg noodle soup loaded with meat and vegetables.");
            product20.setPrice(99);
            product20.setStatus(1);
            product20.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Special-Lomi-533x400.png");
            product20.setCategory(Category.BEST_SELLER);

            Product product21 = new Product();
            product21.setName("Bangus Belly with Egg");
            product21.setDescription("Crispy fried bangus belly served with egg and garlic rice.");
            product21.setPrice(99);
            product21.setStatus(1);
            product21.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Bangus-Belly-with-Egg.png");
            product21.setCategory(Category.VALUE_MEALS);

            Product product22 = new Product();
            product22.setName("Burger Steak with Egg");
            product22.setDescription("Juicy burger patties smothered in rich mushroom gravy, served with egg and rice.");
            product22.setPrice(99);
            product22.setStatus(1);
            product22.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Burger-Steak-with-Egg.png");
            product22.setCategory(Category.VALUE_MEALS);

            Product product23 = new Product();
            product23.setName("Crispy Porkchop with Egg");
            product23.setDescription("Golden-fried crispy porkchop served with egg and garlic rice.");
            product23.setPrice(99);
            product23.setStatus(1);
            product23.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Crispy-Porkchop-with-Egg.png");
            product23.setCategory(Category.VALUE_MEALS);

            Product product24 = new Product();
            product24.setName("Shanghai with Egg");
            product24.setDescription("Crispy and flavorful lumpiang shanghai served with egg and rice.");
            product24.setPrice(99);
            product24.setStatus(1);
            product24.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Shanghai-with-Egg-533x400.png");
            product24.setCategory(Category.VALUE_MEALS);

            Product product25 = new Product();
            product25.setName("Bibing-mamon Original");
            product25.setDescription("A soft, fluffy, and lightly sweetened bibing-mamon that melts in your mouth, offering a classic taste of tradition.");
            product25.setPrice(49);
            product25.setStatus(1);
            product25.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Original.png");
            product25.setCategory(Category.BIBING_MAMON);

            Product product26 = new Product();
            product26.setName("Bibing-mamon Cheezy Melt");
            product26.setDescription("A delightful twist on the classic bibing-mamon, topped with a generous layer of melted cheese for an extra savory bite.");
            product26.setPrice(59);
            product26.setStatus(1);
            product26.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Cheezy-Melt.png");
            product26.setCategory(Category.BIBING_MAMON);

            Product product27 = new Product();
            product27.setName("Bibing-mamon Custard and Cheese");
            product27.setDescription("A rich and creamy bibing-mamon topped with smooth custard and a layer of cheese, blending sweetness with a hint of saltiness.");
            product27.setPrice(59);
            product27.setStatus(1);
            product27.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Custard-and-Cheese.png");
            product27.setCategory(Category.BIBING_MAMON);

            Product product28 = new Product();
            product28.setName("Bibing-mamon Nutty Custard");
            product28.setDescription("A deliciously moist bibing-mamon infused with creamy custard and topped with crunchy nuts for a delightful texture and taste.");
            product28.setPrice(59);
            product28.setStatus(1);
            product28.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Nutty-Custard-533x400.png");
            product28.setCategory(Category.BIBING_MAMON);

            Product product29 = new Product();
            product29.setName("Bibing-mamon Original Box of 6 pcs");
            product29.setDescription("A box of six classic bibing-mamon, perfect for sharing or enjoying throughout the day.");
            product29.setPrice(279);
            product29.setStatus(1);
            product29.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Bibingmamon-Original-Box-of-6-Pcs-533x400.png");
            product29.setCategory(Category.BIBING_MAMON);

            Product product30 = new Product();
            product30.setName("Bibing-mamon Assorted Box of 6 pcs");
            product30.setDescription("A variety pack featuring six pieces of bibing-mamon in different flavors, ideal for those who love to try different tastes.");
            product30.setPrice(325);
            product30.setStatus(1);
            product30.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Bibingmamon-Assorted-Box-of-6-Pcs-533x400.png");
            product30.setCategory(Category.BIBING_MAMON);

            Product product31 = new Product();
            product31.setName("Mini Bibing-mamon Original Box of 16 pcs");
            product31.setDescription("Mini versions of the classic bibing-mamon, packed in a box of 16—great for bite-sized indulgence.");
            product31.setPrice(425);
            product31.setStatus(1);
            product31.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Mini-Bibingmamon-Original-Box-of-16-pcs-533x400.png");
            product31.setCategory(Category.BIBING_MAMON);

            Product product32 = new Product();
            product32.setName("Mini Bibing-mamon with Cheese Box of 16 pcs");
            product32.setDescription("A box of 16 mini bibing-mamon topped with cheese, offering a perfect balance of sweetness and savoriness in every bite.");
            product32.setPrice(425);
            product32.setStatus(1);
            product32.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Bibingmamon-Assorted-Box-of-6-Pcs-533x400.png");
            product32.setCategory(Category.BIBING_MAMON);

            Product product33 = new Product();
            product33.setName("Pork Binagoongang with Talong");
            product33.setDescription("A savory Filipino dish featuring tender pork cooked in rich, flavorful shrimp paste, paired with eggplant for added depth.");
            product33.setPrice(199);
            product33.setStatus(1);
            product33.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Pork-Binagoongan-with-Talong.png");
            product33.setCategory(Category.FAMILY_FAVORITES);

            Product product34 = new Product();
            product34.setName("Beef Kaldereta");
            product34.setDescription("A hearty and comforting beef stew slow-cooked in a rich tomato sauce with vegetables and spices, a true Filipino favorite.");
            product34.setPrice(199);
            product34.setStatus(1);
            product34.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Beef-Kaldereta.png");
            product34.setCategory(Category.FAMILY_FAVORITES);

            Product product35 = new Product();
            product35.setName("Sizzling Porkchop Delight");
            product35.setDescription("Juicy pork chop served on a sizzling plate, topped with a flavorful sauce and paired with rice for a satisfying meal.");
            product35.setPrice(179);
            product35.setStatus(1);
            product35.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Sizzling-Porkchop-Delight.png");
            product35.setCategory(Category.FAMILY_FAVORITES);

            Product product36 = new Product();
            product36.setName("Sizzling Boneless Bangus");
            product36.setDescription("A delicious boneless milkfish fillet, perfectly grilled and served on a sizzling plate for a rich and smoky flavor.");
            product36.setPrice(179);
            product36.setStatus(1);
            product36.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Sizzling-Boneless-Bangus-533x400.png");
            product36.setCategory(Category.FAMILY_FAVORITES);

            Product product37 = new Product();
            product37.setName("Special Beef Kare-Kare");
            product37.setDescription("A rich and savory Filipino stew made with tender beef cuts, peanut sauce, and fresh vegetables, served with bagoong (shrimp paste) on the side.");
            product37.setPrice(199);
            product37.setStatus(1);
            product37.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Special-Beef-Kare-Kare-533x400.png");
            product37.setCategory(Category.FAMILY_FAVORITES);

            Product product38 = new Product();
            product38.setName("Sizzling Pork Sisig");
            product38.setDescription("A flavorful and crispy pork dish served on a sizzling plate, topped with onions, chili, and a special seasoning blend.");
            product38.setPrice(175);
            product38.setStatus(1);
            product38.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Sizzling-Pork-Sisig-533x400.png");
            product38.setCategory(Category.FAMILY_FAVORITES);

            Product product39 = new Product();
            product39.setName("Beef Kaldereta");
            product39.setDescription("A classic Filipino beef stew cooked in a rich tomato sauce with potatoes, carrots, bell peppers, and a touch of liver spread.");
            product39.setPrice(499);
            product39.setStatus(1);
            product39.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Beef-Kaldereta-2.png");
            product39.setCategory(Category.PARTY_PACK);

            Product product40 = new Product();
            product40.setName("Beef Kare-Kare");
            product40.setDescription("A party-sized serving of our famous beef kare-kare, featuring slow-cooked beef in a creamy peanut sauce with fresh vegetables.");
            product40.setPrice(499);
            product40.setStatus(1);
            product40.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Beef-Kare-Kare.png");
            product40.setCategory(Category.PARTY_PACK);

            Product product41 = new Product();
            product41.setName("Pork Binagoongan");
            product41.setDescription("Tender pork cooked in a flavorful shrimp paste sauce, delivering a perfect balance of salty and savory flavors.");
            product41.setPrice(499);
            product41.setStatus(1);
            product41.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Pork-Binagoongan.png");
            product41.setCategory(Category.PARTY_PACK);

            Product product42 = new Product();
            product42.setName("Pork Sisig");
            product42.setDescription("A generous party-size portion of our sizzling pork sisig, perfect for sharing with friends and family.");
            product42.setPrice(499);
            product42.setStatus(1);
            product42.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Pork-Sisig-533x400.png");
            product42.setCategory(Category.PARTY_PACK);

            Product product43 = new Product();
            product43.setName("Beef Kaldereta");
            product43.setDescription("A single-serving rice bowl featuring tender beef chunks in a rich tomato-based sauce with vegetables.");
            product43.setPrice(99);
            product43.setStatus(1);
            product43.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Beef-Kaldereta-3.png");
            product43.setCategory(Category.RICE_BOWL);

            Product product44 = new Product();
            product44.setName("Dinuguan");
            product44.setDescription("A classic Filipino savory stew made with tender pork meat and offal simmered in a rich, tangy pork blood sauce.");
            product44.setPrice(99);
            product44.setStatus(1);
            product44.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Dinuguan.png");
            product44.setCategory(Category.RICE_BOWL);

            Product product45 = new Product();
            product45.setName("Pork Binagoongan with Talong");
            product45.setDescription("A delicious rice bowl with pork cooked in shrimp paste, served with fried eggplant for an extra layer of flavor.");
            product45.setPrice(109);
            product45.setStatus(1);
            product45.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Pork-Binagoongan-with-Talong-1.png");
            product45.setCategory(Category.RICE_BOWL);

            Product product46 = new Product();
            product46.setName("Pork Sisig");
            product46.setDescription("A single-serving rice bowl of our classic pork sisig, topped with calamansi and chili for a flavorful kick.");
            product46.setPrice(99);
            product46.setStatus(1);
            product46.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Pork-Sisig-1-533x400.png");
            product46.setCategory(Category.RICE_BOWL);

            Product product47 = new Product();
            product47.setName("Roast Beef");
            product47.setDescription("Tender slices of slow-roasted beef served with a rich, savory gravy, paired perfectly with steamed rice.");
            product47.setPrice(109);
            product47.setStatus(1);
            product47.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Roast-Beef-533x400.png");
            product47.setCategory(Category.RICE_BOWL);

            Product product48 = new Product();
            product48.setName("Special Beef Kare-Kare");
            product48.setDescription("A rice bowl version of our signature beef kare-kare, featuring creamy peanut sauce and fresh vegetables.");
            product48.setPrice(119);
            product48.setStatus(1);
            product48.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Special-Beef-Kare-Kare-1-533x400.png");
            product48.setCategory(Category.RICE_BOWL);

            Product product49 = new Product();
            product49.setName("Special Beef Tapa");
            product49.setDescription("A classic Filipino breakfast favorite, featuring tender beef tapa marinated in a savory-sweet sauce, served with garlic rice and a fried egg.");
            product49.setPrice(119);
            product49.setStatus(1);
            product49.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Special-Beef-Tapa-533x400.png");
            product49.setCategory(Category.RICE_BOWL);

            Product product50 = new Product();
            product50.setName("Bottled Water");
            product50.setDescription("Refreshing and pure bottled water to keep you hydrated throughout the day.");
            product50.setPrice(30);
            product50.setStatus(1);
            product50.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Bottled-Water.png");
            product50.setCategory(Category.BEVERAGES);

            Product product51 = new Product();
            product51.setName("Brewed Coffee");
            product51.setDescription("Freshly brewed coffee with a rich aroma and bold flavor, perfect for starting your day or a mid-day pick-me-up.");
            product51.setPrice(49);
            product51.setStatus(1);
            product51.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Brewed-Coffee.png");
            product51.setCategory(Category.BEVERAGES);

            Product product52 = new Product();
            product52.setName("Iced Tea");
            product52.setDescription("A refreshing glass of iced tea, brewed to perfection with a balance of sweetness and citrusy notes.");
            product52.setPrice(49);
            product52.setStatus(1);
            product52.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Iced-Tea.png");
            product52.setCategory(Category.BEVERAGES);

            Product product53 = new Product();
            product53.setName("Soda in Can");
            product53.setDescription("Chilled soda in a can, available in classic flavors to complement any meal.");
            product53.setPrice(70);
            product53.setStatus(1);
            product53.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Soda-in-Can-533x400.png");
            product53.setCategory(Category.BEVERAGES);

            Product product54 = new Product();
            product54.setName("Tsokolate Batirol");
            product54.setDescription("A traditional Filipino hot chocolate drink made from pure tablea, rich, thick, and comforting.");
            product54.setPrice(49);
            product54.setStatus(1);
            product54.setImageUrl("https://razonsbyglenn.com/wp-content/uploads/2024/11/Tsokolate-Batirol-533x400.png");
            product54.setCategory(Category.BEVERAGES);



            // Save the products to the database
            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);
            productRepository.save(product6);
            productRepository.save(product7);
            productRepository.save(product8);
            productRepository.save(product9);
            productRepository.save(product10);
            productRepository.save(product11);
            productRepository.save(product12);
            productRepository.save(product13);
            productRepository.save(product14);
            productRepository.save(product15);
            productRepository.save(product16);
            productRepository.save(product17);
            productRepository.save(product18);
            productRepository.save(product19);
            productRepository.save(product20);
            productRepository.save(product21);
            productRepository.save(product22);
            productRepository.save(product23);
            productRepository.save(product24);
            productRepository.save(product25);
            productRepository.save(product26);
            productRepository.save(product27);
            productRepository.save(product28);
            productRepository.save(product29);
            productRepository.save(product30);
            productRepository.save(product31);
            productRepository.save(product32);
            productRepository.save(product33);
            productRepository.save(product34);
            productRepository.save(product35);
            productRepository.save(product36);
            productRepository.save(product37);
            productRepository.save(product38);
            productRepository.save(product39);
            productRepository.save(product40);
            productRepository.save(product41);
            productRepository.save(product42);
            productRepository.save(product43);
            productRepository.save(product44);
            productRepository.save(product45);
            productRepository.save(product46);
            productRepository.save(product47);
            productRepository.save(product48);
            productRepository.save(product49);
            productRepository.save(product50);
            productRepository.save(product51);
            productRepository.save(product52);
            productRepository.save(product53);
            productRepository.save(product54);

            System.out.println("Initial products added successfully");
        }
    }
}