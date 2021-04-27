package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.model.*;
import com.example.demo.repositories.*;

import java.util.List;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    ProductRepository productRepositoryRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category dairy = new Category("Mejeri");
        Category meat = new Category("Kött");
        Category hygiene = new Category("Hygien");
        Category vegetable = new Category("Frukt/Grönt");
        Category candy = new Category("Godis");
        Category pantry = new Category("Skafferi");
        Category other = new Category("Övrigt");


        //Dairy-products
        Product d1 = new Product("Mjölk", 10L, "Härlig och kall", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/0361\\/front_sv.12.full.jpg", 97L);
        d1.getCategories().add(dairy);

        Product d2 = new Product("Ost", 60L, "Med stora runda hål", "https:\\/\\/cdn.pixabay.com\\/photo\\/2017\\/09\\/01\\/14\\/51\\/cheese-2704448_1280.png", 46L);
        d2.getCategories().add(dairy);

        Product d3 = new Product("Filmjölk", 15L, "Som mjölk, men fastare", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/508\\/8222\\/front_sv.10.full.jpg", 5L);
        d3.getCategories().add(dairy);

        Product d4 = new Product("Yoghurt", 16L, "Som filmjölk, men godare", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/586\\/6424\\/front_en.3.full.jpg", 26L);
        d4.getCategories().add(dairy);

        Product d5 = new Product("Gräddfil", 10L, "Krävs för att blanda dipp", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/4703\\/front_sv.6.full.jpg", 50L);
        d5.getCategories().add(dairy);

        Product d6 = new Product("Vispgrädde", 12L, "Fantastiskt resultat vid vispning", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/730\\/015\\/658\\/4151\\/front_sv.9.full.jpg", 43L);
        d6.getCategories().add(dairy);

        Product d7 = new Product("Creame freiche", 15L, "Går också att blanda dipp med", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/3805\\/front_sv.3.full.jpg", 14L);
        d7.getCategories().add(dairy);

        Product d8 = new Product("Smör", 10L, "Till smörgåsen", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/5250\\/front_sv.10.full.jpg", 70L);
        d8.getCategories().add(dairy);

        Product d9 = new Product("Kaffegrädde", 20L, "Till Kaffet", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/506\\/6756\\/front_sv.4.full.jpg", 23L);
        d9.getCategories().add(dairy);

        Product d10 = new Product("Kvarg", 50L, "Till något", "https:\\\\/static.openfoodfacts.org\\/images\\/products\\/401\\/624\\/104\\/3047\\/front_sv.33.full.jpg", 75L);
        d10.getCategories().add(dairy);

        dairy.getProducts().addAll(List.of(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10));


        //Meat-products
        Product m1 = new Product("Oxfile", 80L, "Alltid en hit.Dränk gärna i vitlökssmör", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/231\\/310\\/830\\/1879\\/front_sv.14.full.jpg", 88L);
        m1.getCategories().add(meat);

        Product m2 = new Product("Ryggbiff", 60L, "Ett stycke ryggbiff", "https:\\/\\/p2.piqsels.com\\/preview\\/813\\/236\\/937\\/entrecote-meat-beef-benefit-from-thumbnail.jpg", 13L);
        m2.getCategories().add(meat);

        Product m3 = new Product("Entrecote", 90L, "Ett stycke entrecote", "https:\\/\\/cdn.pixabay.com\\/photo\\/2019\\/06\\/30\\/18\\/17\\/ribeye-4308534_1280.jpg", 97L);
        m3.getCategories().add(meat);

        Product m4 = new Product("Fläskfile", 55L, "Ett stycke fläskfilé", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/d\\/d6\\/Ica_Kvantum_Karlsson_Svedala_fl%C3%A4skfile_140522_0005_%2814061790878%29.jpg", 81L);
        m4.getCategories().add(meat);

        Product m5 = new Product("Kyckling", 60L, "En hel kyckling", "https:\\/\\/p2.piqsels.com\\/preview\\/975\\/701\\/306\\/chicken-broiler-grilled-chicken-poultry.jpg", 26L);
        m5.getCategories().add(meat);

        Product m6 = new Product("Lövbiff", 90L, "Flera stycken lövbiff", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/0\\/0e\\/Rinderroulade-zutaten-02.JPG", 95L);
        m6.getCategories().add(meat);

        Product m7 = new Product("Revbensspjäll", 60L, "Ett stycke revbensspjäll", "https:\\/\\/live.staticflickr.com\\/3010\\/5693609543_b768b36487_b.jpg", 76L);
        m7.getCategories().add(meat);

        Product m8 = new Product("Kamben", 50L, "Den svenska termen för 'babyback ribs'", "https:\\/\\/cdn.pixabay.com\\/photo\\/2017\\/05\\/10\\/21\\/26\\/kamben-2302020_1280.jpg", 30L);
        m8.getCategories().add(meat);

        Product m9 = new Product("Älghjärta", 60L, "Skogens konung? Inte länre!", "https:\\/\\/www.wallpaperuse.com\\/wallp\\/69-698886_m.jpg", 30L);
        m9.getCategories().add(meat);

        Product m10 = new Product("Blandfärs", 50L, "800 g Blandfärs", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/730\\/015\\/658\\/8791\\/front_sv.4.full.jpg", 35L);
        m10.getCategories().add(meat);

        meat.getProducts().addAll(List.of(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10));


        //Hygiene-products
        Product h1 = new Product("Tvål", 20L, "En bit handtvål", "https:\\/\\/cdn.pixabay.com\\/photo\\/2018\\/11\\/14\\/03\\/27\\/handmade-soap-3814400_1280.jpg", 44L);
        h1.getCategories().add(hygiene);

        Product h2 = new Product("Shampo", 30L, "Flaska med schampo", "https:\\/\\/p2.piqsels.com\\/preview\\/20\\/239\\/608\\/shampoo-thai-shampoo-thai-herbal-shampoo-kaffir-lime-shampoo-thumbnail.jpg", 10L);
        h2.getCategories().add(hygiene);

        Product h3 = new Product("Hudkräm", 50L, "Kräm för huden", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/b\\/b6\\/Penaten_Creme_2004_%28Alter_Fritz%29.JPG", 15L);
        h3.getCategories().add(hygiene);

        Product h4 = new Product("Handsprit", 40L, "Flaska med handsprit", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/6\\/6c\\/Handsprit.jpg", 0L);
        h4.getCategories().add(hygiene);

        Product h5 = new Product("Tandkräm", 15L, "En tub med tandkräm", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/f\\/f0\\/Vademecum_tandkr%C3%A4m.jpg", 33L);
        h5.getCategories().add(hygiene);

        Product h6 = new Product("Flasktvål", 20L, "Flaska med tvål", "https:\\/\\/live.staticflickr.com\\/14\\/15236236_6e1d552e5d_b.jpg", 8L);
        h6.getCategories().add(hygiene);

        Product h7 = new Product("Balsam", 40L, "Flaska med hårbalsam", "https:\\/\\/static.openproductsfacts.org\\/images\\/products\\/590\\/760\\/861\\/7478\\/front_de.4.full.jpg", 34L);
        h7.getCategories().add(hygiene);

        Product h8 = new Product("Munskölj", 50L, "Flaska med munskölj", "https:\\/\\/static.openproductsfacts.org\\/images\\/products\\/590\\/760\\/861\\/7478\\/front_de.4.full.jpg", 44L);
        h8.getCategories().add(hygiene);

        Product h9 = new Product("Tandtråd", 10L, "Ask med tandtråd", "https:\\/\\/i0.hippopx.com\\/photos\\/498\\/738\\/404\\/floss-oral-dental-hygiene-preview.jpg", 51L);
        h9.getCategories().add(hygiene);

        Product h10 = new Product("Fotkräm", 50L, "Kräm för fot", "https:\\/\\/p2.piqsels.com\\/preview\\/161\\/189\\/257\\/medical-ointment-cloth-antique-thumbnail.jpg", 71L);
        h10.getCategories().add(hygiene);

        hygiene.getProducts().addAll(List.of(h1,h2,h3,h4,h5,h6,h7,h8,h9,h10));


        //Vegetable-products
        Product v1 = new Product("Ekologiska bananer", 23L, "Ekologiska och rättvisemärkta bananer från Ecuador", "https:\\/\\/cdn.pixabay.com\\/photo\\/2018\\/09\\/24\\/20\\/12\\/bananas-3700718_960_720.jpg", 20L);
        v1.getCategories().add(vegetable);

        Product v2 = new Product("Svenska äpplen", 26L, "Äpple med söt frisk smak och vitt fruktkött", "https:\\/\\/www.wexthuset.com\\/images\\/products\\/wexthuset\\/apple-signe-tillisch.jpg", 96L);
        v2.getCategories().add(vegetable);

        Product v3 = new Product("Gurka", 20L, "Lokalt producerad svensk gurka", "https:\\/\\/pixnio.com\\/free-images\\/2020\\/01\\/20\\/2020-01-20-08-39-52-1200x800.jpg", 9L);
        v3.getCategories().add(vegetable);

        Product v4 = new Product("Tomat", 45L, "Spänstiga tomater med söt tomatsmak året om", "https:\\/\\/allergitest.se\\/wp-content\\/uploads\\/2021\\/02\\/Allergitest-Tomat.jpg.webp", 16L);
        v4.getCategories().add(vegetable);

        Product v5 = new Product("Svenska morötter", 14L, "Knapriga rötter med aningen söt smak som förstärks när de tillagas", "https:\\/\\/p2.piqsels.com\\/preview\\/4\\/203\\/788\\/carrot-turnip-vegetables-yellow-beets.jpg", 50L);
        v5.getCategories().add(vegetable);

        vegetable.getProducts().addAll(List.of(v1,v2,v3,v4,v5));


        //Candy-products
        Product c1 = new Product("Gott och blandat supersur", 19L, "Söta och sura gelegodisar", "https:\\/\\/assets.partyking.org\\/img\\/products\\/1300\\/gott-blandat-supersur-1.jpg", 3L);
        c1.getCategories().add(candy);

        Product c2 = new Product("Jolt Cola", 9L, "Den klassiska colan som ger dig den energi du behöver", "https:\\/\\/live.staticflickr.com\\/2412\\/2128248625_8403a17be9_b.jpg", 89L);
        c2.getCategories().add(candy);

        candy.getProducts().addAll(List.of(c1,c2));

        //Pantry-products
        Product p1 = new Product("Barilla farfalle", 15L, "Pasta Farfalle från Barilla är en durumpasta gjord på finaste råvaror", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/807\\/680\\/806\\/0654\\/front_fr.202.200.jpg", 19L);
        p1.getCategories().add(pantry);

        Product p2 = new Product("Barilla Snabbspaghetti", 16L, "Pasta Spaghetti från Barilla är den mest klassiska pastasorten från Italien", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/807\\/680\\/957\\/2200\\/front_fr.38.200.jpg", 6L);
        p2.getCategories().add(pantry);

        Product p3 = new Product("Uncle Ben’s basmatiris", 50L, "Uncle Ben’s Basmatiris är 100 % hållbart och odlas i Indien, vid Himalayas fot, innan det lagras i sex månader för att förfina den naturligt aromatiska doften och smaken", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/thumb\\/7\\/7d\\/Uncle_Ben%27s_basmati_rice.jpg\\/546px-Uncle_Ben%27s_basmati_rice.jpg", 0L);
        p3.getCategories().add(pantry);

        pantry.getProducts().addAll(List.of(p1,p2,p3));


       productRepositoryRepo.saveAll(List.of(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,v1,v2,v3,v4,v5,c1,c2,p1,p2,p3));

    };

}



