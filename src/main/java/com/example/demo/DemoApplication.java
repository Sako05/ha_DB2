package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.model.*;
import com.example.demo.repositories.*;


import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner bootstrap(ProductRepository productRepositoryRepo, CategoryRepository categoryRepositoryRepo) {
        return (args) -> {
            //save categories
            Category dairy = new Category("Mejeri");
            categoryRepositoryRepo.save(dairy);
            Category meat = new Category("Kött");
            categoryRepositoryRepo.save(meat);
//            Category hygiene = new Category("Hygien");
//            categoryRepositoryRepo.save(hygiene);
//            Category vegetable = new Category("Frukt/Grönt");
//            categoryRepositoryRepo.save(vegetable);
//            Category candy = new Category("Godis");
//            categoryRepositoryRepo.save(candy);
//            Category pantry = new Category("Skafferi");
//            categoryRepositoryRepo.save(pantry);
//            Category other = new Category("Övrigt");
//            categoryRepositoryRepo.save(other);


            //save products
            Product mjölk = new Product("Mjölk", 10L, "Härlig och kall", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/0361\\/front_sv.12.full.jpg", 97L, Arrays.asList(dairy));
            productRepositoryRepo.save(mjölk);
//            Product ost = new Product("Ost", 60L, "Med stora runda hål", "https:\\/\\/cdn.pixabay.com\\/photo\\/2017\\/09\\/01\\/14\\/51\\/cheese-2704448_1280.png", 46L, Arrays.asList(dairy));
//            productRepositoryRepo.save(ost);
//            Product filmjölk = new Product("Filmjölk", 15L, "Som mjölk, men fastare", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/508\\/8222\\/front_sv.10.full.jpg", 5L, Arrays.asList(dairy));
//            productRepositoryRepo.save(filmjölk);
//            Product yoghurt = new Product("Yoghurt", 16L, "Som filmjölk, men godare", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/586\\/6424\\/front_en.3.full.jpg", 26L, Arrays.asList(dairy));
//            productRepositoryRepo.save(yoghurt);
//            Product gräddfil = new Product("Gräddfil", 10L, "Krävs för att blanda dipp", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/4703\\/front_sv.6.full.jpg", 50L, Arrays.asList(dairy));
//            productRepositoryRepo.save(gräddfil);
//            Product vispgrädde = new Product("Vispgrädde", 12L, "Fantastiskt resultat vid vispning", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/730\\/015\\/658\\/4151\\/front_sv.9.full.jpg", 43L, Arrays.asList(dairy));
//            productRepositoryRepo.save(vispgrädde);
//            Product cremeFreiche = new Product("Creame freiche", 15L, "Går också att blanda dipp med", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/3805\\/front_sv.3.full.jpg", 14L, Arrays.asList(dairy));
//            productRepositoryRepo.save(cremeFreiche);
//            Product smör = new Product("Smör", 10L, "Till smörgåsen", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/500\\/5250\\/front_sv.10.full.jpg", 70L, Arrays.asList(dairy));
//            productRepositoryRepo.save(smör);
//            Product kaffegrädde = new Product("Kaffegrädde", 20L, "Till Kaffet", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/731\\/086\\/506\\/6756\\/front_sv.4.full.jpg", 23L, Arrays.asList(dairy));
//            productRepositoryRepo.save(kaffegrädde);
//            Product kvarg = new Product("Kvarg", 50L, "Till något", "https:\\\\/static.openfoodfacts.org\\/images\\/products\\/401\\/624\\/104\\/3047\\/front_sv.33.full.jpg", 75L, Arrays.asList(dairy));
//            productRepositoryRepo.save(kaffegrädde);
//            Product oxfile = new Product("Oxfile", 80L, "Alltid en hit.Dränk gärna i vitlökssmör", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/231\\/310\\/830\\/1879\\/front_sv.14.full.jpg", 88L, Arrays.asList(meat));
//            productRepositoryRepo.save(oxfile);
//            Product ryggbiff = new Product("Ryggbiff", 60L, "Ett stycke ryggbiff", "https:\\/\\/p2.piqsels.com\\/preview\\/813\\/236\\/937\\/entrecote-meat-beef-benefit-from-thumbnail.jpg", 13L, Arrays.asList(meat));
//            productRepositoryRepo.save(ryggbiff);
//            Product entrecote = new Product("Entrecote", 90L, "Ett stycke entrecote", "https:\\/\\/cdn.pixabay.com\\/photo\\/2019\\/06\\/30\\/18\\/17\\/ribeye-4308534_1280.jpg", 97L, Arrays.asList(meat));
//            productRepositoryRepo.save(entrecote);
//            Product fläskfile = new Product("Fläskfile", 55L, "Ett stycke fläskfilé", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/d\\/d6\\/Ica_Kvantum_Karlsson_Svedala_fl%C3%A4skfile_140522_0005_%2814061790878%29.jpg", 81L, Arrays.asList(meat));
//            productRepositoryRepo.save(fläskfile);
//            Product kyckling = new Product("Kyckling", 60L, "En hel kyckling", "https:\\/\\/p2.piqsels.com\\/preview\\/975\\/701\\/306\\/chicken-broiler-grilled-chicken-poultry.jpg", 26L, Arrays.asList(meat));
//            productRepositoryRepo.save(kyckling);
//            Product lövbiff = new Product("Lövbiff", 90L, "Flera stycken lövbiff", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/0\\/0e\\/Rinderroulade-zutaten-02.JPG", 95L, Arrays.asList(meat));
//            productRepositoryRepo.save(lövbiff);
//            Product revbensspjäll = new Product("Revbensspjäll", 60L, "Ett stycke revbensspjäll", "https:\\/\\/live.staticflickr.com\\/3010\\/5693609543_b768b36487_b.jpg", 76L, Arrays.asList(meat));
//            productRepositoryRepo.save(revbensspjäll);
//            Product kamben = new Product("Kamben", 50L, "Den svenska termen för 'babyback ribs'", "https:\\/\\/cdn.pixabay.com\\/photo\\/2017\\/05\\/10\\/21\\/26\\/kamben-2302020_1280.jpg", 30L, Arrays.asList(meat));
//            productRepositoryRepo.save(kamben);
//            Product älghjärta = new Product("Älghjärta", 60L, "Skogens konung? Inte länre!", "https:\\/\\/www.wallpaperuse.com\\/wallp\\/69-698886_m.jpg", 30L, Arrays.asList(meat));
//            productRepositoryRepo.save(älghjärta);
//            Product blandfärs = new Product("Blandfärs", 50L, "800 g Blandfärs", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/730\\/015\\/658\\/8791\\/front_sv.4.full.jpg", 35L, Arrays.asList(meat));
//            productRepositoryRepo.save(blandfärs);
//            Product tvål = new Product("Tvål", 20L, "En bit handtvål", "https:\\/\\/cdn.pixabay.com\\/photo\\/2018\\/11\\/14\\/03\\/27\\/handmade-soap-3814400_1280.jpg", 44L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(tvål);
//            Product shampo = new Product("Shampo", 30L, "Flaska med schampo", "https:\\/\\/p2.piqsels.com\\/preview\\/20\\/239\\/608\\/shampoo-thai-shampoo-thai-herbal-shampoo-kaffir-lime-shampoo-thumbnail.jpg", 10L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(shampo);
//            Product hudkräm = new Product("Hudkräm", 50L, "Kräm för huden", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/b\\/b6\\/Penaten_Creme_2004_%28Alter_Fritz%29.JPG", 15L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(hudkräm);
//            Product handsprit = new Product("Handsprit", 40L, "Flaska med handsprit", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/6\\/6c\\/Handsprit.jpg", 0L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(handsprit);
//            Product tandkräm = new Product("Tandkräm", 15L, "En tub med tandkräm", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/f\\/f0\\/Vademecum_tandkr%C3%A4m.jpg", 33L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(tandkräm);
//            Product flasktvål = new Product("Flasktvål", 20L, "Flaska med tvål", "https:\\/\\/live.staticflickr.com\\/14\\/15236236_6e1d552e5d_b.jpg", 8L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(flasktvål);
//            Product balsam = new Product("Balsam", 40L, "Flaska med hårbalsam", "https:\\/\\/static.openproductsfacts.org\\/images\\/products\\/590\\/760\\/861\\/7478\\/front_de.4.full.jpg", 34L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(balsam);
//            Product munskölj = new Product("Munskölj", 50L, "Flaska med munskölj", "https:\\/\\/static.openproductsfacts.org\\/images\\/products\\/590\\/760\\/861\\/7478\\/front_de.4.full.jpg", 44L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(munskölj);
//            Product tandtråd = new Product("Tandtråd", 10L, "Ask med tandtråd", "https:\\/\\/i0.hippopx.com\\/photos\\/498\\/738\\/404\\/floss-oral-dental-hygiene-preview.jpg", 51L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(tandtråd);
//            Product fotkräm = new Product("Fotkräm", 50L, "Kräm för fot", "https:\\/\\/p2.piqsels.com\\/preview\\/161\\/189\\/257\\/medical-ointment-cloth-antique-thumbnail.jpg", 71L, Arrays.asList(hygiene));
//            productRepositoryRepo.save(fotkräm);
//            Product bananer = new Product("Ekologiska bananer", 23L, "Ekologiska och rättvisemärkta bananer från Ecuador", "https:\\/\\/cdn.pixabay.com\\/photo\\/2018\\/09\\/24\\/20\\/12\\/bananas-3700718_960_720.jpg", 20L, Arrays.asList(vegetable));
//            productRepositoryRepo.save(bananer);
//            Product äpplen = new Product("Svenska äpplen", 26L, "Äpple med söt frisk smak och vitt fruktkött", "https:\\/\\/www.wexthuset.com\\/images\\/products\\/wexthuset\\/apple-signe-tillisch.jpg", 96L, Arrays.asList(vegetable));
//            productRepositoryRepo.save(äpplen);
//            Product gurka = new Product("Gurka", 20L, "Lokalt producerad svensk gurka", "https:\\/\\/pixnio.com\\/free-images\\/2020\\/01\\/20\\/2020-01-20-08-39-52-1200x800.jpg", 9L, Arrays.asList(vegetable));
//            productRepositoryRepo.save(gurka);
//            Product tomat = new Product("Tomat", 45L, "Spänstiga tomater med söt tomatsmak året om", "https:\\/\\/allergitest.se\\/wp-content\\/uploads\\/2021\\/02\\/Allergitest-Tomat.jpg.webp", 16L, Arrays.asList(vegetable));
//            productRepositoryRepo.save(tomat);
//            Product morot = new Product("Svenska morötter", 14L, "Knapriga rötter med aningen söt smak som förstärks när de tillagas", "https:\\/\\/p2.piqsels.com\\/preview\\/4\\/203\\/788\\/carrot-turnip-vegetables-yellow-beets.jpg", 50L, Arrays.asList(vegetable));
//            productRepositoryRepo.save(morot);
//            Product gottOchBlandat = new Product("Gott och blandat supersur", 19L, "Söta och sura gelegodisar", "https:\\/\\/assets.partyking.org\\/img\\/products\\/1300\\/gott-blandat-supersur-1.jpg", 3L, Arrays.asList(candy));
//            productRepositoryRepo.save(gottOchBlandat);
//            Product joltCola = new Product("Jolt Cola", 9L, "Den klassiska colan som ger dig den energi du behöver", "https:\\/\\/live.staticflickr.com\\/2412\\/2128248625_8403a17be9_b.jpg", 89L, Arrays.asList(candy));
//            productRepositoryRepo.save(joltCola);
//            Product farfalle = new Product("Barilla farfalle", 15L, "Pasta Farfalle från Barilla är en durumpasta gjord på finaste råvaror", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/807\\/680\\/806\\/0654\\/front_fr.202.200.jpg", 19L, Arrays.asList(pantry));
//            productRepositoryRepo.save(farfalle);
//            Product spaghetti = new Product("Barilla Snabbspaghetti", 16L, "Pasta Spaghetti från Barilla är den mest klassiska pastasorten från Italien", "https:\\/\\/static.openfoodfacts.org\\/images\\/products\\/807\\/680\\/957\\/2200\\/front_fr.38.200.jpg", 6L, Arrays.asList(pantry));
//            productRepositoryRepo.save(spaghetti);
//            Product ris = new Product("Uncle Ben’s basmatiris", 50L, "Uncle Ben’s Basmatiris är 100 % hållbart och odlas i Indien, vid Himalayas fot, innan det lagras i sex månader för att förfina den naturligt aromatiska doften och smaken", "https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/thumb\\/7\\/7d\\/Uncle_Ben%27s_basmati_rice.jpg\\/546px-Uncle_Ben%27s_basmati_rice.jpg", 0L, Arrays.asList(pantry));
//            productRepositoryRepo.save(ris);


        };

    }

}




//        {
//            "name": "Avokado",
//                "descp": "En mogen avokado har mjukt, krämigt fruktkött med mild och lite nötaktig smak",
//                "price": 16,
//                "image": "https:\/\/www.everfresh.se\/globalassets\/bilder-gronsaker\/ovr_gronsaker\/h2_avokado.png",
//                "quantity": 83,
//                "category": "Frukt\/Grönt"
//        },
//        {
//            "name": "Gul lök",
//                "descp": "Gul lök passar i både varm och kall matlagning. Lägg den skurna löken i kallt vatten innan användning, så blir den snällare",
//                "price": 10,
//                "image": "https:\/\/c.pxhere.com\/photos\/bc\/13\/Cooking_Dinner_farmers_market_Food_Garden_Harvest_Ingredients_Meal-1622247.jpg!d",
//                "quantity": 43,
//                "category": "Frukt\/Grönt"
//        },
//        {
//            "name": "Sötpotatis",
//                "descp": "Rotfrukt med rödaktigt kött som påminner om potatis i konsistensen",
//                "price": 33,
//                "image": "https:\/\/pixnio.com\/free-images\/2017\/03\/11\/2017-03-11-11-31-02-725x544.jpg",
//                "quantity": 64,
//                "category": "Frukt\/Grönt"
//        },
//        {
//            "name": "Vindruvor",
//                "descp": "Friskt söt och lite kryddig smak",
//                "price": 40,
//                "image": "https:\/\/cdn.pixabay.com\/photo\/2013\/07\/18\/09\/04\/grapes-163420_960_720.jpg",
//                "quantity": 65,
//                "category": "Frukt\/Grönt"
//        },
//        {
//            "name": "Citroner",
//                "descp": "Citron passar som smaksättare till bland annat fisk, i såser, dressingar, desserter, glass och bakverk eller lägg några skivor i måltidsvattnet",
//                "price": 7,
//                "image": "https:\/\/c.pxhere.com\/photos\/cc\/2c\/lemons_yellow_fruit_tart_refreshment_citrus_fruits_vitamins_fruity-1181836.jpg!d",
//                "quantity": 82,
//                "category": "Frukt\/Grönt"
//        },
//        {
//            "name": "Röd grapefrukt",
//                "descp": "Syrlig och fräsch röd grapefrukt",
//                "price": 13,
//                "image": "https:\/\/p2.piqsels.com\/preview\/533\/250\/509\/grapefruit-fruit-red-sweet.jpg",
//                "quantity": 95,
//                "category": "Frukt\/Grönt"
//        },
//
//            "name": "Maoam Maomix",
//                "descp": "Blandade fruktkolor",
//                "price": 22,
//                "image": "https:\/\/cdn.pixabay.com\/photo\/2016\/02\/11\/23\/06\/bag-1194960_960_720.jpg",
//                "quantity": 58,
//                "category": "Godis"
//        },
//        {
//            "name": "Ahlgrens bilar 160g",
//                "descp": "Ahlgrens bilar Original är en favorit bland godispåsar. De mjuka bilarna erbjuds här i de klassiska Ahlgrens bilar-färgerna rosa, vit och grön",
//                "price": 15,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/731\/078\/000\/5212\/front_sv.16.200.jpg",
//                "quantity": 33,
//                "category": "Godis"
//        },
//        {
//            "name": "Polly Milkchoco 200g",
//                "descp": "Polly är härligt sega skumtoppar dragerade med en ljuvlig chokladsmak",
//                "price": 26,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/731\/004\/003\/4532\/front_sv.4.200.jpg",
//                "quantity": 81,
//                "category": "Godis"
//        },
//        {
//            "name": "Marabou Mjölkchoklad 100g",
//                "descp": "Marabou Mjölkchoklad är Sveriges allra mest älskade chokladkaka. Den har funnits i sortimentet sedan Marabou grundades och är fortfarande lika populär",
//                "price": 16,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/73550013\/front_sv.7.200.jpg",
//                "quantity": 39,
//                "category": "Godis"
//        },
//        {
//            "name": "Nestlé KitKat",
//                "descp": "Spröda kex med krämig mjölkchoklad",
//                "price": 15,
//                "image": "https:\/\/live.staticflickr.com\/5503\/9835700665_d24596c529_b.jpg",
//                "quantity": 94,
//                "category": "Godis"
//        },
//        {
//            "name": "OLW Sourcream and onion chips 200g",
//                "descp": "Riktigt goda chips gör fredagsmyset ännu bättre. På OLW använder vi oss av naturliga ingredienser och den allra finaste potatisen",
//                "price": 22,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/730\/040\/038\/1703\/front_sv.3.full.jpg",
//                "quantity": 28,
//                "category": "Godis"
//        },
//        {
//            "name": "OLW Klassisk nötmix 200g",
//                "descp": "En perfekt blandning av dina favoritsnacks. Lättsaltade och rostade",
//                "price": 31,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/734\/000\/540\/3462\/front_sv.12.200.jpg",
//                "quantity": 13,
//                "category": "Godis"
//        },
//        {
//            "name": "Geisha 37g",
//                "descp": "Geisha är en omtyckt mjölkchoklad med en krämig fyllning gjord på hasselnötter",
//                "price": 8,
//                "image": "https:\/\/live.staticflickr.com\/7334\/13999798048_99b7b1f73a_b.jpg",
//                "quantity": 9,
//                "category": "Godis"
//        },
//
//        {
//            "name": "Felix Potatismos",
//                "descp": "I Eslöv mitt i Skåne tillagas Felix klassiskt potatismos. Till 6 portioner används cirka 15 potatisar",
//                "price": 20,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/731\/024\/006\/6128\/front_sv.18.full.jpg",
//                "quantity": 2,
//                "category": "Skafferi"
//        },
//        {
//            "name": "Mutti Krossade tomater",
//                "descp": "Krossade tomater från Italien",
//                "price": 32,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/800\/511\/017\/0300\/front_it.38.200.jpg",
//                "quantity": 85,
//                "category": "Skafferi"
//        },
//        {
//            "name": "Heinz vita bönor i tomatsås",
//                "descp": "Ursprungsland Storbritannien",
//                "price": 12,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/500\/015\/702\/4671\/front_sv.60.full.jpg",
//                "quantity": 51,
//                "category": "Skafferi"
//        },
//        {
//            "name": "Samyang ramen Hot Chicken",
//                "descp": "Helt okej kinesisk kyckling",
//                "price": 6,
//                "image": "https:\/\/live.staticflickr.com\/4452\/37371024100_fb262e0087_b.jpg",
//                "quantity": 39,
//                "category": "Skafferi"
//        },
//        {
//            "name": "Kungsörnens pepparkaksmix",
//                "descp": "Klassiskt pepparkaksrecept med minimalt arbete",
//                "price": 24,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/731\/013\/015\/5512\/front_fr.4.200.jpg",
//                "quantity": 11,
//                "category": "Skafferi"
//        },
//        {
//            "name": "Tomatpure på burk",
//                "descp": "Söta tomater perfekta till grytor",
//                "price": 25,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/70111019\/front_en.8.full.jpg",
//                "quantity": 94,
//                "category": "Skafferi"
//        },
//        {
//            "name": "Santa Maria Tortillabröd",
//                "descp": "Ursprungsland Sverige",
//                "price": 22,
//                "image": "https:\/\/static.openfoodfacts.org\/images\/products\/731\/131\/031\/2879\/front_en.9.200.jpg",
//                "quantity": 2,
//                "category": "Skafferi"
//        }


