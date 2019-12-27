package com.refugiomascotas;

import com.refugiomascotas.models.Mascota;
import com.refugiomascotas.models.Tipo;
import com.refugiomascotas.repositories.MascotaRepository;
import com.refugiomascotas.repositories.TipoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RefugioApplication extends SpringBootServletInitializer {

    private Tipo perro;
    private Tipo gato;
    private Tipo guacamayo;
    private Tipo tortuga;

    private Mascota pepe;
    private Mascota rafael;
    private Mascota yogui;
    private Mascota piolin;
    private Mascota gary;

    public static void main(java.lang.String[] args) {
        SpringApplication.run(RefugioApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(TipoRepository tipoRepository, MascotaRepository mascotaRepository) {
        return (args) -> {

            //Tipos
            perro = new Tipo("Perro");
            gato = new Tipo("Gato");
            tortuga = new Tipo("Tortuga");
            guacamayo = new Tipo("Guacamayo");

            //Mascotas
            pepe = new Mascota("Pepe trueno", "Gato", "gruñon y juguetón",
                    "https://cdn2.traveler.es/uploads/images/thumbs/es/trav/3/s/2019/39/gatos_463_940x705.jpg", 3);
            rafael = new Mascota("Rafael", "Tortuga", "le encanta la lechuga y pasear por la casa (si, también le gusta la pizza)",
                    "https://siguealconejoblanco.es/wp-content/uploads/2010/07/Ninja-Turtle-in-Real-Life.jpg", 2);
            yogui = new Mascota("Yogui", "Perro", "super activo, le gusta correr mucho",
                    "https://static1.abc.es/media/recreo/2019/10/05/nori-perro-humano-kO2--620x349@abc.jpg", 1);
            piolin = new Mascota("Piolin", "Guacamayo", "muy colorida, come frutas y ¡habla!",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/Ara_macao_qtl1.jpg/275px-Ara_macao_qtl1.jpg", 3);
            gary = new Mascota("Gary", "Gato", "Es muy mimoso y marron",
                    "https://estaticos.miarevista.es/media/cache/760x570_thumb/uploads/images/article/57725158a1d4251a098bca20/int-gatosiames.jpg", 14);

            tipoRepository.save(perro);
            tipoRepository.save(gato);
            tipoRepository.save(tortuga);
            tipoRepository.save(guacamayo);

            mascotaRepository.save(pepe);
            mascotaRepository.save(rafael);
            mascotaRepository.save(yogui);
            mascotaRepository.save(piolin);
            mascotaRepository.save(gary);

        };
    }
}
