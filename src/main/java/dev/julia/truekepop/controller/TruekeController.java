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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // Método para obtener todos los truekes
    @GetMapping
    public List<Trueke> getAllTruekes() {
        return truekeService.getAllTruekes();
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
            Categoria categoria = truekeService.findCategoriaById(categoryId);
            if (categoria == null) {
                return ResponseEntity.status(400).body("Categoría no encontrada");
            }

            Trueke trueke = new Trueke();
            trueke.setName(name);
            trueke.setDescription(description);
            trueke.setLocation(location);
            trueke.setDesiredItem(desiredItem);
            trueke.setType(type);
            trueke.setLikes(0);
            trueke.setCategoria(categoria);

            if (image != null && !image.isEmpty()) {
                String directory = "images/";
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path path = Paths.get(directory + fileName);
                Files.createDirectories(path.getParent());
                Files.write(path, image.getBytes());
                trueke.setImage(directory + fileName);
            }

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
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteTrueke(@PathVariable Long id) {
        truekeService.deleteTrueke(id);
        return ResponseEntity.noContent().build();
    }

    // Método para editar un trueke
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTrueke(
            @PathVariable Long id,
            @RequestBody Trueke updatedTrueke) {
        try {
            Trueke existingTrueke = truekeService.findTruekeById(id);
            if (existingTrueke == null) {
                return ResponseEntity.status(404).body("Trueke no encontrado");
            }
    
            
            existingTrueke.setName(updatedTrueke.getName());
            existingTrueke.setDescription(updatedTrueke.getDescription());
            existingTrueke.setLocation(updatedTrueke.getLocation());
            existingTrueke.setDesiredItem(updatedTrueke.getDesiredItem());
            existingTrueke.setType(updatedTrueke.getType());
    
            
            if (updatedTrueke.getCategoria() != null) {
                Categoria categoria = truekeService.findCategoriaById(updatedTrueke.getCategoria().getId());
                if (categoria == null) {
                    return ResponseEntity.status(400).body("Categoría no encontrada");
                }
                existingTrueke.setCategoria(categoria);
            }
    
            
            if (updatedTrueke.getImage() != null && !updatedTrueke.getImage().isEmpty()) {
                existingTrueke.setImage(updatedTrueke.getImage());
            }
    
            truekeService.saveTrueke(existingTrueke);
            return ResponseEntity.ok("Trueke actualizado con éxito!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al actualizar el trueke: " + e.getMessage());
        }
            }
        }
        
    