package dev.julia.truekepop.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.julia.truekepop.models.Categoria;
import dev.julia.truekepop.models.Trueke;
import dev.julia.truekepop.services.TruekeService;

@RestController
@RequestMapping("api/trueke")
public class TruekeController {

    @Autowired
    private TruekeService truekeService;



    @GetMapping("/urgente")
    public List<Trueke> getUrgentTruekes() {
        return truekeService.findByCategoriaId(1L);
    }

    @GetMapping("/novedades")
    public List<Trueke> getNovedades() {
        return truekeService.findByCategoriaId(4L);
    }

    @GetMapping("/escuchoOfertas")
    public List<Trueke> getEscuchoOfertas() {
        return truekeService.findByCategoriaId(3L);
    }

    @GetMapping("/directo")
    public List<Trueke> getDirecto() {
        return truekeService.findByCategoriaId(2L);
    }

    // Método para crear un trueke
    @PostMapping
    public ResponseEntity<String> createTrueke(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("location") String location,
            @RequestParam("desiredItem") String desiredItem,
            @RequestParam("type") String type,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("image") MultipartFile image) {

        try {
            // Buscar la categoría en la base de datos
            Categoria categoria = truekeService.findCategoriaById(categoryId);
            if (categoria == null) {
                return ResponseEntity.status(400).body("Categoría no encontrada");
            }

            // Crear un nuevo objeto Trueke
            Trueke trueke = new Trueke();
            trueke.setName(name);
            trueke.setDescription(description);
            trueke.setLocation(location);
            trueke.setDesiredItem(desiredItem);
            trueke.setType(type);
            trueke.setLikes(0);

            // Asignar la categoría encontrada al trueke
            trueke.setCategoria(categoria);

            // Guardar la imagen en el sistema de archivos
            if (image != null && !image.isEmpty()) {
                String directory = "images/";
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path path = Paths.get(directory + fileName);
                Files.createDirectories(path.getParent()); // Crear el directorio si no existe
                Files.write(path, image.getBytes());

                // Guardar la ruta de la imagen en la base de datos
                trueke.setImage(directory + fileName);
            }

            // Guardar el trueke usando el servicio
            truekeService.saveTrueke(trueke);

            return ResponseEntity.ok("Trueke creado con éxito!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al crear el trueke: " + e.getMessage());
        }
    }

    // Endpoint para servir las imágenes
    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path path = Paths.get("images/" + filename);
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // Cambia el tipo de contenido si es necesario
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
