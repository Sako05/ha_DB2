package com.example.demo;

import com.example.demo.model.RoleApp;
import com.example.demo.model.UserApp;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.model.*;
import com.example.demo.repositories.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;


@SpringBootApplication
//public class DemoApplication implements CommandLineRunner {

public class DemoApplication{

    @Autowired
    ProductRepository productRepositoryRepo;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CustomerRepository customerRepository;

    private Optional<Category> finalCat;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
          userService.saveRole(new RoleApp(null, "ROLE_USER"));
          userService.saveRole(new RoleApp(null, "ROLE_ADMIN"));

          userService.saveUser(new UserApp(null, "Salem K", "salem", "1234", new ArrayList<>()));
          userService.saveUser(new UserApp(null, "Admin", "admin", "1234", new ArrayList<>()));

          userService.addRoleToUser("admin", "ROLE_ADMIN");
          userService.addRoleToUser("admin", "ROLE_USER");
          userService.addRoleToUser("salem", "ROLE_USER");
        };
    }

/*
  @Override
    public void run(String... args) throws Exception {

        Category dairy = new Category("Mejeri");
        Category meat = new Category("Kött");
        Category hygiene = new Category("Hygien");
        Category vegetable = new Category("Frukt/Grönt");
        Category candy = new Category("Godis");
        Category pantry = new Category("Skafferi");
        Category other = new Category("Övrigt");

        dairy = categoryRepository.save(dairy);
        meat = categoryRepository.save(meat);
        hygiene = categoryRepository.save(hygiene);
        vegetable = categoryRepository.save(vegetable);
        candy = categoryRepository.save(candy);
        pantry = categoryRepository.save(pantry);
        other = categoryRepository.save(other);


        //Customer

        Customer cu1 = new Customer("Hakim", "livs", "hakim@livs.se", "Ha123456", "hakimlivs2", 11111L, "Stockholm", "Admin");
        customerRepository.save(cu1);

        //Dairy-products
        Product d1 = new Product("Mjölk", 10L, "Härlig och kall", "https://static.openfoodfacts.org//images//products//731//086//500//0361//front_sv.12.full.jpg", 97L);
        d1.setCategories(Collections.singleton(dairy));
        d1 = productRepositoryRepo.save(d1);

        Product d2 = new Product("Ost", 60L, "Med stora runda hål", "https://cdn.pixabay.com/photo/2017/09/01/14/51/cheese-2704448_1280.png", 46L);
        d2.setCategories(Collections.singleton(dairy));
        d2 = productRepositoryRepo.save(d2);

        Product d3 = new Product("Filmjölk", 15L, "Som mjölk, men fastare", "https://static.openfoodfacts.org//images//products//731//086//508//8222//front_sv.10.full.jpg", 5L);
        d3.setCategories(Collections.singleton(dairy));
        d3 = productRepositoryRepo.save(d3);

        Product d4 = new Product("Yoghurt", 16L, "Som filmjölk, men godare", "https://static.openfoodfacts.org//images//products//731//086//586//6424//front_en.3.full.jpg", 26L);
        d4.setCategories(Collections.singleton(dairy));
        d4 = productRepositoryRepo.save(d4);

        Product d5 = new Product("Gräddfil", 10L, "Krävs för att blanda dipp", "https://static.openfoodfacts.org//images//products//731//086//500//4703//front_sv.6.full.jpg", 50L);
        d5.setCategories(Collections.singleton(dairy));
        d5 = productRepositoryRepo.save(d5);

        Product d6 = new Product("Vispgrädde", 12L, "Fantastiskt resultat vid vispning", "https://static.openfoodfacts.org//images//products//730//015//658//4151//front_sv.9.full.jpg", 43L);
        d6.setCategories(Collections.singleton(dairy));
        d6 = productRepositoryRepo.save(d6);

        Product d7 = new Product("Creame freiche", 15L, "Går också att blanda dipp med", "https://static.openfoodfacts.org//images//products//731//086//500//3805//front_sv.3.full.jpg", 14L);
        d7.setCategories(Collections.singleton(dairy));
        d7 = productRepositoryRepo.save(d7);

        Product d8 = new Product("Smör", 10L, "Till smörgåsen", "https://static.openfoodfacts.org//images//products//731//086//500//5250//front_sv.10.full.jpg", 70L);
        d8.setCategories(Collections.singleton(dairy));
        d8 = productRepositoryRepo.save(d8);

        Product d9 = new Product("Kaffegrädde", 20L, "Till Kaffet", "https://static.openfoodfacts.org//images//products//731//086//506//6756//front_sv.4.full.jpg", 23L);
        d9.setCategories(Collections.singleton(dairy));
        d9 = productRepositoryRepo.save(d9);

        Product d10 = new Product("Kvarg", 50L, "Till något", "https://static.openfoodfacts.org//images//products//401//624//104//3047//front_sv.33.full.jpg", 75L);
        d10.setCategories(Collections.singleton(dairy));
        d10 = productRepositoryRepo.save(d10);


        //Meat-products
        Product m1 = new Product("Oxfile", 80L, "Alltid en hit.Dränk gärna i vitlökssmör", "https://static.openfoodfacts.org//images//products//231//310//830//1879//front_sv.14.full.jpg", 88L);
        m1.setCategories(Collections.singleton(meat));
        m1 = productRepositoryRepo.save(m1);

        Product m2 = new Product("Ryggbiff", 60L, "Ett stycke ryggbiff", "https://p2.piqsels.com//preview//813//236//937//entrecote-meat-beef-benefit-from-thumbnail.jpg", 13L);
        m2.setCategories(Collections.singleton(meat));
        m2 = productRepositoryRepo.save(m2);

        Product m3 = new Product("Entrecote", 90L, "Ett stycke entrecote", "https://cdn.pixabay.com/photo/2019/06/30/18/17/ribeye-4308534_1280.jpg", 97L);
        m3.setCategories(Collections.singleton(meat));
        m3 = productRepositoryRepo.save(m3);

        Product m4 = new Product("Fläskfile", 55L, "Ett stycke fläskfilé", "https://upload.wikimedia.org/wikipedia/commons/d/d6/Ica_Kvantum_Karlsson_Svedala_fl%C3%A4skfile_140522_0005_%2814061790878%29.jpg", 81L);
        m4.setCategories(Collections.singleton(meat));
        m4 = productRepositoryRepo.save(m4);

        Product m5 = new Product("Kyckling", 60L, "En hel kyckling", "https://p2.piqsels.com/preview/975/701/306/chicken-broiler-grilled-chicken-poultry.jpg", 26L);
        m5.setCategories(Collections.singleton(meat));
        m5 = productRepositoryRepo.save(m5);

        Product m6 = new Product("Lövbiff", 90L, "Flera stycken lövbiff", "https://upload.wikimedia.org/wikipedia/commons/0/0e/Rinderroulade-zutaten-02.JPG", 95L);
        m6.setCategories(Collections.singleton(meat));
        m6 = productRepositoryRepo.save(m6);

        Product m7 = new Product("Revbensspjäll", 60L, "Ett stycke revbensspjäll", "https://live.staticflickr.com/3010/5693609543_b768b36487_b.jpg", 76L);
        m7.setCategories(Collections.singleton(meat));
        m7 = productRepositoryRepo.save(m7);

        Product m8 = new Product("Kamben", 50L, "Den svenska termen för 'babyback ribs'", "https://cdn.pixabay.com/photo/2017/05/10/21/26/kamben-2302020_1280.jpg", 30L);
        m8.setCategories(Collections.singleton(meat));
        m8 = productRepositoryRepo.save(m8);

        Product m9 = new Product("Älghjärta", 60L, "Skogens konung? Inte länre!", "https://www.wallpaperuse.com/wallp/69-698886_m.jpg", 30L);
        m9.setCategories(Collections.singleton(meat));
        m9 = productRepositoryRepo.save(m9);

        Product m10 = new Product("Blandfärs", 50L, "800 g Blandfärs", "https://static.openfoodfacts.org/images/products/730/015/658/8791/front_sv.4.full.jpg", 35L);
        m10.setCategories(Collections.singleton(meat));
        m10 = productRepositoryRepo.save(m10);


        //Hygiene-products
        Product h1 = new Product("Tvål", 20L, "En bit handtvål", "https://cdn.pixabay.com/photo/2018/11/14/03/27/handmade-soap-3814400_1280.jpg", 44L);
        h1.setCategories(Collections.singleton(hygiene));
        h1 = productRepositoryRepo.save(h1);

        Product h2 = new Product("Shampo", 30L, "Flaska med schampo", "https://p2.piqsels.com/preview/20/239/608/shampoo-thai-shampoo-thai-herbal-shampoo-kaffir-lime-shampoo-thumbnail.jpg", 10L);
        h2.setCategories(Collections.singleton(hygiene));
        h2 = productRepositoryRepo.save(h2);

        Product h3 = new Product("Hudkräm", 50L, "Kräm för huden", "https://upload.wikimedia.org/wikipedia/commons/b/b6/Penaten_Creme_2004_%28Alter_Fritz%29.JPG", 15L);
        h3.setCategories(Collections.singleton(hygiene));
        h3 = productRepositoryRepo.save(h3);

        Product h4 = new Product("Handsprit", 40L, "Flaska med handsprit", "https://upload.wikimedia.org/wikipedia/commons/6/6c/Handsprit.jpg", 0L);
        h4.setCategories(Collections.singleton(hygiene));
        h4 = productRepositoryRepo.save(h4);

        Product h5 = new Product("Tandkräm", 15L, "En tub med tandkräm", "https://upload.wikimedia.org/wikipedia/commons/f/f0/Vademecum_tandkr%C3%A4m.jpg", 33L);
        h5.setCategories(Collections.singleton(hygiene));
        h5 = productRepositoryRepo.save(h5);

        Product h6 = new Product("Flasktvål", 20L, "Flaska med tvål", "https://live.staticflickr.com/14/15236236_6e1d552e5d_b.jpg", 8L);
        h6.setCategories(Collections.singleton(hygiene));
        h6 = productRepositoryRepo.save(h6);

        Product h7 = new Product("Balsam", 40L, "Flaska med hårbalsam", "https://static.openbeautyfacts.org/images/products/405/817/261/8970/front_de.4.full.jpg", 34L);
        h7.setCategories(Collections.singleton(hygiene));
        h7 = productRepositoryRepo.save(h7);

        Product h8 = new Product("Munskölj", 50L, "Flaska med munskölj", "https://static.openproductsfacts.org/images/products/590/760/861/7478/front_de.4.full.jpg", 44L);
        h8.setCategories(Collections.singleton(hygiene));
        h8 = productRepositoryRepo.save(h8);

        Product h9 = new Product("Tandtråd", 10L, "Ask med tandtråd", "https://i0.hippopx.com/photos/498/738/404/floss-oral-dental-hygiene-preview.jpg", 51L);
        h9.setCategories(Collections.singleton(hygiene));
        h9 = productRepositoryRepo.save(h9);

        Product h10 = new Product("Fotkräm", 50L, "Kräm för fot", "https://p2.piqsels.com/preview/161/189/257/medical-ointment-cloth-antique-thumbnail.jpg", 71L);
        h10.setCategories(Collections.singleton(hygiene));
        h10 = productRepositoryRepo.save(h10);


        //Vegetable-products
        Product v1 = new Product("Ekologiska bananer", 23L, "Ekologiska och rättvisemärkta bananer från Ecuador", "https://cdn.pixabay.com/photo/2018/09/24/20/12/bananas-3700718_960_720.jpg", 20L);
        v1.setCategories(Collections.singleton(vegetable));
        v1 = productRepositoryRepo.save(v1);

        Product v2 = new Product("Svenska äpplen", 26L, "Äpple med söt frisk smak och vitt fruktkött", "https://www.wexthuset.com/images/products/wexthuset/apple-signe-tillisch.jpg", 96L);
        v2.setCategories(Collections.singleton(vegetable));
        v2 = productRepositoryRepo.save(v2);

        Product v3 = new Product("Gurka", 20L, "Lokalt producerad svensk gurka", "https://pixnio.com/free-images/2020/01/20/2020-01-20-08-39-52-1200x800.jpg", 9L);
        v3.setCategories(Collections.singleton(vegetable));
        v3 = productRepositoryRepo.save(v3);

        Product v4 = new Product("Tomat", 45L, "Spänstiga tomater med söt tomatsmak året om", "https://allergitest.se/wp-content/uploads/2021/02/Allergitest-Tomat.jpg.webp", 16L);
        v4.setCategories(Collections.singleton(vegetable));
        v4 = productRepositoryRepo.save(v4);

        Product v5 = new Product("Svenska morötter", 14L, "Knapriga rötter med aningen söt smak som förstärks när de tillagas", "https://p2.piqsels.com/preview/4/203/788/carrot-turnip-vegetables-yellow-beets.jpg", 50L);
        v5.setCategories(Collections.singleton(vegetable));
        v5 = productRepositoryRepo.save(v5);

        //Candy-products
        Product c1 = new Product("Gott och blandat supersur", 19L, "Söta och sura gelegodisar", "https://assets.partyking.org/img/products/1300/gott-blandat-supersur-1.jpg", 3L);
        c1.setCategories(Collections.singleton(candy));
        c1 = productRepositoryRepo.save(c1);

        Product c2 = new Product("Jolt Cola", 9L, "Den klassiska colan som ger dig den energi du behöver", "https://live.staticflickr.com//2412//2128248625_8403a17be9_b.jpg", 89L);
        c2.setCategories(Collections.singleton(candy));
        c2 = productRepositoryRepo.save(c2);

        Product c3 = new Product("Ahlgrens bilar 160g",15L,"Ahlgrens bilar Original är en favorit bland godispåsar. De mjuka bilarna erbjuds här i de klassiska Ahlgrens bilar-färgerna rosa, vit och grön","https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/078\\/000\\/5212\\/front_sv.16.200.jpg",33L);
        c3.setCategories(Collections.singleton(candy));
        c3 = productRepositoryRepo.save(c3);

        Product c4 = new Product("Polly Milkchoco 200g",26L,"Polly är härligt sega skumtoppar dragerade med en ljuvlig chokladsmak","https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/004\\/003\\/4532\\/front_sv.4.200.jpg",81L);
        c4.setCategories(Collections.singleton(candy));
        c4 = productRepositoryRepo.save(c4);


        //Pantry-products
        Product p1 = new Product("Barilla farfalle", 15L, "Pasta Farfalle från Barilla är en durumpasta gjord på finaste råvaror", "https://static.openfoodfacts.org/images/products/807/680/806/0654/front_fr.202.200.jpg", 19L);
        p1.setCategories(Collections.singleton(pantry));
        p1 = productRepositoryRepo.save(p1);

        Product p2 = new Product("Barilla Snabbspaghetti", 16L, "Pasta Spaghetti från Barilla är den mest klassiska pastasorten från Italien", "https://static.openfoodfacts.org/images/products/807/680/957/2200/front_fr.38.200.jpg", 6L);
        p2.setCategories(Collections.singleton(pantry));
        p2 = productRepositoryRepo.save(p2);

        Product p3 = new Product("Uncle Ben’s basmatiris", 50L, "Uncle Ben’s Basmatiris är 100 % hållbart och odlas i Indien, vid Himalayas fot, innan det lagras i sex månader för att förfina den naturligt aromatiska doften och smaken", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Uncle_Ben%27s_basmati_rice.jpg/546px-Uncle_Ben%27s_basmati_rice.jpg", 0L);
        p3.setCategories(Collections.singleton(pantry));
        p3 = productRepositoryRepo.save(p3);

        Product p4 = new Product("Felix Potatismos",20L,"I Eslöv mitt i Skåne tillagas Felix klassiskt potatismos. Till 6 portioner används cirka 15 potatisar","https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/024\\/006\\/6128\\/front_sv.18.full.jpg",2L);
        p4.setCategories(Collections.singleton(pantry));
        p4 = productRepositoryRepo.save(p4);



    } */

    }


